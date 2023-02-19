package all.algorithms;

import java.awt.Choice;
import java.util.ArrayList;

import javax.swing.JTextArea;

import all.model.Bet;
import all.model.Driver;
import all.model.Participant;

public class CountPointsAlgorithm {
    ArrayList<Bet> betsArray = new ArrayList<>();

    public void count(JTextArea bets, ArrayList<Driver> driversArrayList, Choice qualiOrRace, Participant chosen, String fastestDriver){
    	boolean joker=false;
        String getBets = bets.getText(); //wziecie betow z jtextarea
        String[] parts = getBets.split("\n"); //podzial na pozycja+kierowca

        int jokers=0;
        double points=0;
        
        for (String string : parts) {
            String s=string;
            if(s.contains("NO: ")) {
            	if(s.contains(fastestDriver)) points+=1;
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
            for (Driver driver : driversArrayList) {
                if(bet.getSurname().equals(driver.getName())) {
                    if(bet.getPosition()==driver.getPosition()) {
                        points+=2;
                    }
                    else if(bet.getPosition()==driver.getPosition()-1 || bet.getPosition()==driver.getPosition()+1){
                        points+=1;
                    }
                }
            }
            System.out.println(bet.getPosition()+bet.getSurname());
        }
        
        if(qualiOrRace.getSelectedItem().equals("Wyscig")) {
        	points*=2;
        }
        
        if(joker) {
        	points*=2;
        	if(qualiOrRace.getSelectedItem().equals("Wyscig")) {
        		chosen.setNumberOfUsedJokers(1);
        	}
        }
        
        chosen.setPoints(points);
        System.out.println(points);
    }
}
