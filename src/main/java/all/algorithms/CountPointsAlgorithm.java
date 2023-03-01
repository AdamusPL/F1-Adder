package all.algorithms;

import java.util.ArrayList;

import javax.swing.JTextArea;

import all.model.Bet;
import all.model.Driver;
import all.model.Participant;

public class CountPointsAlgorithm {
    ArrayList<Bet> betsArray = new ArrayList<>();

    //nie liczy 10. i 20. pozycji
    public void countRace(JTextArea bets, ArrayList<Driver> driversArrayList, Participant chosen, String fastestDriver){
        boolean joker=false;
        String getBets = bets.getText(); //wziecie betow z jtextarea
        String[] parts = getBets.split("\n"); //podzial na pozycja+kierowca

        int jokers=0;
        double points=0;

        for (String string : parts) {
            String s=string;
            if(s.contains("NO: ")) {
                if(s.contains(fastestDriver)){
                    System.out.println(s+" "+1);
                    points+=1;
                }
                else System.out.println(s+" "+0);
                continue;
            }

            if(s.equals("(J)")) { //tu jeszcze zeby jakos dodawal, bo jakbym dal w kwali i race jokera to by dodal 2
                joker=true;
                break;
            }

            String[] parts2=s.split(" "); //oddzielenie pozycji i kierowcy
            parts2[0]=parts2[0].replace(".","");
            Bet bet = new Bet(Integer.parseInt(parts2[0]), parts2[1]);
            betsArray.add(bet); //dodanie betu do arraylisty
        }

        for (Bet bet: betsArray) {
            double eachpoints=0; //dla kazdego betu z osobna
            for (Driver driver : driversArrayList) {
                if(bet.getSurname().equals(driver.getName())) {
                    if(bet.getPosition()==driver.getPosition()) {
                        switch(bet.getPosition()){
                            case 1: points+=3; eachpoints+=3; break;
                            case 2: points+=2; eachpoints+=2; break;
                            case 3: points+=1; eachpoints+=1; break;
                        }
                        points+=2;
                        eachpoints+=2;
                    }
                    else if(bet.getPosition()==driver.getPosition()-1 || bet.getPosition()==driver.getPosition()+1){
                        points+=1;
                        eachpoints+=1;
                    }
                }
            }
            System.out.println(bet.getPosition()+" "+bet.getSurname()+" "+eachpoints);
        }

        points*=2; //bo to wyscig

        if(joker) {
            points*=2;
            chosen.setNumberOfUsedJokers(1);
        }

        chosen.setPoints(points);
        System.out.println(points);
    }

    //nie liczy 20. pozycji
    public void countQuali(JTextArea bets, ArrayList<Driver> driversArrayList, Participant chosen){
        boolean joker=false;
        String getBets = bets.getText(); //wziecie betow z jtextarea
        String[] parts = getBets.split("\n"); //podzial na pozycja+kierowca

        int jokers=0;
        double points=0;

        for (String string : parts) {
            String s=string;

            if(s.equals("(J)")) { //tu jeszcze zeby jakos dodawal, bo jakbym dal w kwali i race jokera to by dodal 2
                joker=true;
                break;
            }

            String[] parts2=s.split(" "); //oddzielenie pozycji i kierowcy
            parts2[0]=parts2[0].replace(".","");
            Bet bet = new Bet(Integer.parseInt(parts2[0]), parts2[1]);
            betsArray.add(bet); //dodanie betu do arraylisty
        }

        for (Bet bet: betsArray) {
            double eachpoints=0;
            for (Driver driver : driversArrayList) {
                if(bet.getSurname().equals(driver.getName())) {
                    if(bet.getPosition()==driver.getPosition()) {
                        switch(bet.getPosition()){
                            case 1: points+=3; eachpoints+=3; break;
                            case 2: points+=2; eachpoints+=2; break;
                            case 3: points+=1; eachpoints+=1; break;
                        }
                        points+=2;
                        eachpoints+=2;
                    }
                    else if(bet.getPosition()==driver.getPosition()-1 || bet.getPosition()==driver.getPosition()+1){
                        points+=1;
                        eachpoints+=1;
                    }
                    else points+=0;
                }
            }
            System.out.println(bet.getPosition()+" "+bet.getSurname()+" "+eachpoints);
        }

        if(joker) {
            points*=2;
        }

        chosen.setPoints(points);
        System.out.println(points);
    }
}
