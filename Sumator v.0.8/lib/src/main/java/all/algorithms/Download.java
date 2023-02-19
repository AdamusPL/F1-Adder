package all.algorithms;

import all.model.Driver;
import all.model.Participant;
import all.model.Quote;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Download {

    public ArrayList<Quote> downloadQuotes(){ //metoda robiąca arraylistę powiedzonek
        ArrayList<Quote> quoteArrayList = new ArrayList<>();
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("1.txt"));
            line=br.readLine();

            while((line=br.readLine())!=null){
                String[] data=line.split("; ");
                Quote quote = new Quote(data[0]);
                quoteArrayList.add(quote);
            }
            br.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Nie mozna bylo odczytac pliku");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quoteArrayList;
    }

    public ArrayList<Driver> downloadScores() throws IOException { //pobieranie wyników ze strony f1
        ArrayList<Driver> lifeScores = new ArrayList<>();

        //niech użytkownik wprowadzi link, bo konwencja jego nazywania jest niealgorytmiczna; danych ze strony kwalifikacji jest wiecej niz z wyscigu, rozwiazac!
        Document doc = Jsoup.connect("https://www.formula1.com/en/results.html/2022/races/1138/abu-dhabi/race-result.html").timeout(6000).get();

        Elements elements = doc.select("td"); //skopiowanie zawartosci strony
        ArrayList<String> stuff = new ArrayList<>();

        for (Element e : elements) { //do testowania
            if(!e.text().isEmpty()){
                System.out.println(e.text());
            }
        }

        int i=1;
        for (Element e: elements) {
            if(!e.text().isEmpty()){
                if(stuff.size()==7){
                	String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    Driver driver = new Driver(i,Integer.parseInt(stuff.get(1)),parts[1],stuff.get(3),
                            Integer.parseInt(stuff.get(4)),stuff.get(5),Integer.parseInt(stuff.get(6)));
                    System.out.println(driver.getPosition()+" "+driver.getNumber()+" "+driver.getName()+" "
                            +driver.getTeam()+" "+driver.getDrivenLaps()+" "+driver.getLose()+" "+driver.getPoints());
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                    stuff.add(e.text());
                }
                else stuff.add(e.text());
            }
        }

        return lifeScores;
    }
    
    public String downloadFastestLap() throws IOException {
    	String driverSurname;
    	Document doc = Jsoup.connect("https://www.formula1.com/en/results.html/2022/races/1138/abu-dhabi/fastest-laps.html").timeout(6000).get();

        Elements elements = doc.select("td"); //skopiowanie zawartosci strony
        
        int i=0;
        for (Element e : elements) { //do testowania
            if(!e.text().isEmpty()){
            	if(i==2) {
            		String[] parts = e.text().split(" ");
            		return parts[1];
            	}
                i++;
            }
        }
        return null;
    }

    public ArrayList<Participant> downloadParticipants() throws IOException { //metoda pobierająca arraylistę uczestników
        ArrayList<Participant> participantArrayList=new ArrayList<>();
        Document doc = Jsoup.connect("https://sites.google.com/view/typerf1/klasyfikacja?authuser=0").timeout(6000).get();

        Elements elements = doc.select("li");

        for (Element e: elements) {
            if(e.text().contains("pkt")){
                int numberOfUsedJokers=0;
                String string = e.text();
                String[] parts = string.split(" ");
                String name = parts[0];
                String surname = parts[1];
                String points = parts[2];

                int i=4;
//                System.out.println(parts.length);
                while(i<parts.length) {
                    if(parts[i].equals("J")) {
                        numberOfUsedJokers++;
                        i++;
                    }
                }

                //jeszcze jak dojda jokery na stronie to wpisac jokery
                Participant participant = new Participant(name,surname,Double.parseDouble(points),numberOfUsedJokers);
                participantArrayList.add(participant);
//                System.out.println(name);
//                System.out.println(surname);
//                System.out.println(points);
            }
        }
        return participantArrayList;
    }

}
