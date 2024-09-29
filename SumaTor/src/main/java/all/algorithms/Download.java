package all.algorithms;

import all.model.Driver;
import all.model.Participant;
import all.model.Quote;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Driver> downloadScoresFromF1Page(String link) throws IOException { //downloading scores from race from official F1 page
        try {
            ArrayList<Driver> driverArrayList = new ArrayList<>();
            WebDriver driver;
            System.setProperty("webdriver.firefox.marionette","C:\\apps\\geckodriver.exe");

            // Create an instance of FirefoxOptions
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true); // Enable headless mode

            driver = new FirefoxDriver(options);
            String baseUrl = link;

            driver.get(baseUrl);

            List<WebElement> sth = driver.findElements(By.className("max-tablet:hidden"));

            int position = 1;
            for(WebElement webElement : sth){
                String surname = webElement.getText();
                Driver driverObject = new Driver(position, surname);
                driverArrayList.add(driverObject);
                position++;
            }

            return driverArrayList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String downloadFastestLap(String link) throws IOException {
        try {
            WebDriver driver;
            System.setProperty("webdriver.firefox.marionette","C:\\apps\\geckodriver.exe");
            // Create an instance of FirefoxOptions
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true); // Enable headless mode

            driver = new FirefoxDriver(options);
            String baseUrl = link;

            driver.get(baseUrl);

            List<WebElement> sth = driver.findElements(By.className("max-tablet:hidden"));

            return sth.get(0).getText();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Participant> downloadParticipants() throws IOException { //method downloading arraylist of participants from specific page
        ArrayList<Participant> participantArrayList = new ArrayList<>();
        Document doc = Jsoup.connect("https://sites.google.com/view/f1rk88/strona-g%C5%82%C3%B3wna").timeout(6000).get();
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
            }

        }
        return participantArrayList;
    }

}