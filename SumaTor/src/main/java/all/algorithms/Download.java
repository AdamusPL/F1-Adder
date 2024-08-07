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
    public ArrayList<Quote> downloadQuotes() { //method making arraylist of quotes from txt file
        ArrayList<Quote> quoteArrayList = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("1.txt"));

            while ((line = br.readLine()) != null) {
                String[] data = line.split("; ");
                Quote quote = new Quote(data[0]);
                quoteArrayList.add(quote);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't read file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quoteArrayList;
    }

    private ArrayList<Driver> lifeScores;
    private ArrayList<String> stuff;

    public Download(){
        this.lifeScores = new ArrayList<>();
        this.stuff = new ArrayList<>();
    }

    private Elements initialize(String link) throws IOException {
        Document doc = Jsoup.connect(link).timeout(6000).get();
        return doc.select("td"); //copying html content of page
    }

    public ArrayList<Driver> downloadScoresFromQualiOrSS(String link) throws IOException {

        Elements elements = initialize(link);

        int i = 1;

        boolean stop = false;
        boolean times = false;

        for (Element e : elements) {

            if (!e.text().isEmpty()) {
                stuff.add(e.text());

                if (e.text().contains(":")) {
                    times = true;
                }

                if (!e.text().contains(":") && times) {
                    stop = true;
                }

                if (stuff.size() == 8 && stop) { //top 10 has 8 pieces of data, 10-15 7 pieces of data, 15-20 6 pieces of data
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if (parts[1].equals("Guanyu")) parts[1] = "Zhou"; //exception for one driver
                    Driver driver = new Driver(i, Integer.parseInt(stuff.get(1)), parts[1], stuff.get(3),
                            stuff.get(4), stuff.get(5), stuff.get(6), Integer.parseInt(stuff.get(7)));
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                    stop = false;
                    times = false;
//                    stuff.add(e.text());
                } else if (stuff.size() == 7 && stop) {
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if (parts[1].equals("Guanyu")) parts[1] = "Zhou"; //exception for one driver
                    Driver driver = new Driver(i, Integer.parseInt(stuff.get(1)), parts[1], stuff.get(3),
                            stuff.get(4), stuff.get(5), Integer.parseInt(stuff.get(6)));
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                    stop = false;
                    times = false;
                } else if (stuff.size() == 6 && stop) {
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if (parts[1].equals("Guanyu")) parts[1] = "Zhou";
                    Driver driver = new Driver(i, Integer.parseInt(stuff.get(1)), parts[1], stuff.get(3),
                            stuff.get(4), Integer.parseInt(stuff.get(5)));
                    i++;
                    lifeScores.add(driver);
                    stuff.clear();
                    stop = false;
                    times = false;
                }
            }

        }

        return lifeScores;
    }

    public ArrayList<Driver> downloadScoresFromRaceOrSprint(String link) throws IOException { //downloading scores from race from official F1 page
        Elements elements = initialize(link);

        int i = 1;
        for (Element e : elements) {
            if (!e.text().isEmpty()) {
                stuff.add(e.text());
                if (stuff.size() == 7) {
                    String[] parts = stuff.get(2).split(" ");
//                	System.out.println(parts[1]);
                    if (parts[1].equals("Guanyu")) parts[1] = "Zhou";
                    Driver driver = new Driver(i, Integer.parseInt(stuff.get(1)), parts[1], stuff.get(3),
                            Integer.parseInt(stuff.get(4)), stuff.get(5), Integer.parseInt(stuff.get(6)));
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
        Elements elements = initialize(link);

        int i = 0;
        for (Element e : elements) { //for testing purposes
            if (!e.text().isEmpty()) {
                if (i == 2) {
                    String[] parts = e.text().split(" ");
                    return parts[1];
                }
                i++;
            }
        }
        return null;
    }

    public ArrayList<Participant> downloadParticipants() throws IOException { //method downloading arraylist of participants from specific page
        ArrayList<Participant> participantArrayList = new ArrayList<>();
        Document doc = Jsoup.connect("https://sites.google.com/view/typowanief1/strona-g%C5%82%C3%B3wna").timeout(6000).get();
        Elements elements = doc.getElementsByClass("C9DxTc ");

        for (Element e : elements) {
            if (e.text().contains("pkt")) {

                String string = e.text();
                String[] parts = string.split(" ");
                String name = parts[0];
                String surname = parts[1];
                String points = parts[2];
                String jokers = parts[4];

                int numberOfUsedJokers = jokers.length();

                Participant participant = new Participant(name, surname, Double.parseDouble(points), numberOfUsedJokers);
                participantArrayList.add(participant);
//                System.out.println(name);
//                System.out.println(surname);
//                System.out.println(points);
            }

        }
        return participantArrayList;
    }

}
