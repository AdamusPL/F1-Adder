package all.algorithms;

import java.util.ArrayList;

import all.model.Bet;
import all.model.Driver;
import all.model.Participant;

public class CountPointsAlgorithm {
    private ArrayList<Bet> betsArray;
    private double points;
    private boolean joker;
    private String bets;
    private ArrayList<Driver> drivers;
    private Participant chosen;
    private String fastestDriver;

    public CountPointsAlgorithm(String bets, ArrayList<Driver> drivers, Participant chosen, String fastestDriver) {
        this.betsArray = new ArrayList<>();
        this.points = 0;
        this.bets = bets;
        this.drivers = drivers;
        this.chosen = chosen;
        this.fastestDriver = fastestDriver;
    }

    public CountPointsAlgorithm(String bets, ArrayList<Driver> drivers, Participant chosen) {
        this.betsArray = new ArrayList<>();
        this.points = 0;
        this.bets = bets;
        this.drivers = drivers;
        this.chosen = chosen;
    }


    public void countPointsFromRace() {
        parseBets();

        points += getPoints();

        points *= 2; //because it's race

        if (joker) {
            points *= 2;
            chosen.setNumberOfUsedJokers(1);
        }

        chosen.setPoints(points);
        System.out.println("Sum of points: " + points);
        System.out.println();
    }

    private boolean jokerCheck(String s) {
        if (s.equals("(J)")) {
            joker = true;
            return true;
        }

        String[] parts2 = s.split(" "); //divide position and driver
        parts2[0] = parts2[0].replace(".", "");
        Bet bet = new Bet(Integer.parseInt(parts2[0]), parts2[1]);
        betsArray.add(bet); //add bet to arraylist
        return false;
    }

    public void countPointsFromQualifying() {
        parseBets();

        points += getPoints();

        if (joker) {
            points *= 2;
        }

        chosen.setPoints(points);
        System.out.println(points);
    }

    public void countPointsFromSprint() {
        parseBets();

        points = getPoints();

        if (joker) {
            points *= 2;
            chosen.setNumberOfUsedJokers(1);
        }

        chosen.setPoints(points);
        System.out.println("Sum of points: " + points);
        System.out.println();
    }

    public void countPointsFromSprintShootout() {
        parseBets();

        points = getPoints();

        points *= 0.5; //because it's sprint shootout

        if (joker) {
            points *= 2;
        }

        chosen.setPoints(points);
        System.out.println(points);
    }

    private void parseBets() {
        joker = false;

        String[] parts = bets.split("\r\n"); //divide on position+driver

        String replace = "";

        for (int i = 0; i < parts[0].length(); i++) {
            if (i >= 1) {
                replace += parts[0].charAt(i);
            }
        }

        parts[0] = replace;

        for (String string : parts) {
            String s = string;
            if (s.contains("NO: ")) {
                System.out.println(chosen.getName() + ": ");
                if (s.contains(fastestDriver)) {
                    System.out.println(s + " " + 1);
                    points += 1;
                } else System.out.println(s + " " + 0);
                continue;
            }

            if (jokerCheck(s)) break;
        }
    }

    private double getPoints() {
        for (Bet bet : betsArray) {
            double participantPoints = 0; //for every bet separately
            for (Driver driver : drivers) {
                if (bet.getSurname().equals(driver.getName())) {
                    if (bet.getPosition() == driver.getPosition()) {
                        switch (bet.getPosition()) {
                            case 1:
                                points += 3;
                                participantPoints += 3;
                                break;
                            case 2:
                                points += 2;
                                participantPoints += 2;
                                break;
                            case 3:
                                points += 1;
                                participantPoints += 1;
                                break;
                        }
                        points += 2;
                        participantPoints += 2;
                    } else if (bet.getPosition() == driver.getPosition() - 1 || bet.getPosition() == driver.getPosition() + 1) {
                        points += 1;
                        participantPoints += 1;
                    }
                }
            }
            System.out.println(bet.getPosition() + " " + bet.getSurname() + " " + participantPoints);
        }
        return points;
    }

}