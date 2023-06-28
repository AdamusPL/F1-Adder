package all.algorithms;

import all.model.Driver;
import all.model.Participant;
import all.model.Quote;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
                String[] data = line.split("; ");
                Quote quote = new Quote(data[0]);
                quoteArrayList.add(quote);
            }
            br.close();
        }
        catch (FileNotFoundException ex){
//            System.out.println("Nie mozna bylo odczytac pliku");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quoteArrayList;
    }

    public ArrayList<Driver> downloadScoresFromQualiOrSS(String link) throws IOException{
        ArrayList<Driver> lifeScores = new ArrayList<>();
        Document doc = Jsoup.connect(link).timeout(6000).get();

        Elements elements = doc.select("td"); //skopiowanie zawartosci strony
        ArrayList<String> stuff = new ArrayList<>();

        for (Element e : elements) { //do testowania
            if(!e.text().isEmpty()){
//                System.out.println(e.text());
            }
        }

        int i=1;

        boolean stop=false;
        boolean times=false;

        for (Element e: elements) {

            if(!e.text().isEmpty()){
                stuff.add(e.text());

                if(e.text().contains(":")){
                    times=true;
                }

                if(!e.text().contains(":") && times){
                    stop=true;
                }

                if(stuff.size()==8 && stop){ //top 10 ma 8 danych, 10-15 7 danych, 15-20 6 danych
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if(parts[1].equals("Guanyu")) parts[1]="Zhou";
                    Driver driver = new Driver(i,Integer.parseInt(stuff.get(1)),parts[1],stuff.get(3),
                        stuff.get(4),stuff.get(5),stuff.get(6),Integer.parseInt(stuff.get(7)));
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                    stop=false;
                    times=false;
//                    stuff.add(e.text());
                }

                else if(stuff.size()==7 && stop){
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if(parts[1].equals("Guanyu")) parts[1]="Zhou";
                    Driver driver = new Driver(i,Integer.parseInt(stuff.get(1)),parts[1],stuff.get(3),
                            stuff.get(4),stuff.get(5),Integer.parseInt(stuff.get(6)));
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                    stop=false;
                    times=false;
                }

                else if(stuff.size()==6 && stop){
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if(parts[1].equals("Guanyu")) parts[1]="Zhou";
                    Driver driver = new Driver(i,Integer.parseInt(stuff.get(1)),parts[1],stuff.get(3),
                            stuff.get(4),Integer.parseInt(stuff.get(5)));
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                    stop=false;
                    times=false;
                }
            }

        }

        return lifeScores;
    }

    public ArrayList<Driver> downloadScoresFromRaceOrSprint(String link) throws IOException { //pobieranie wyników ze strony f1
        ArrayList<Driver> lifeScores = new ArrayList<>();

        Document doc = Jsoup.connect(link).timeout(6000).get();

        Elements elements = doc.select("td"); //skopiowanie zawartosci strony
        ArrayList<String> stuff = new ArrayList<>();

        for (Element e : elements) { //do testowania
            if(!e.text().isEmpty()){
//                System.out.println(e.text());
            }
        }

        int i=1;
        for (Element e: elements) {
            if(!e.text().isEmpty()){
                stuff.add(e.text());
                if(stuff.size()==7){
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if(parts[1].equals("Guanyu")) parts[1]="Zhou";
                    Driver driver = new Driver(i,Integer.parseInt(stuff.get(1)),parts[1],stuff.get(3),
                            Integer.parseInt(stuff.get(4)),stuff.get(5),Integer.parseInt(stuff.get(6)));
//                    System.out.println(driver.getPosition()+" "+driver.getNumber()+" "+driver.getName()+" "
//                            +driver.getTeam()+" "+driver.getDrivenLaps()+" "+driver.getLose()+" "+driver.getPoints());
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                }
            }
        }

        return lifeScores;
    }

    public String downloadFastestLap(String link) throws IOException {
        Document doc = Jsoup.connect(link).timeout(6000).get();

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
