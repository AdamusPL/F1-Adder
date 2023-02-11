package all.model;

import javax.swing.*;

public class Participant {
    String name;
    String surname;
    double points;
    int numberOfUsedJokers;

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setNumberOfUsedJokers(int numberOfUsedJokers) {
        this.numberOfUsedJokers = numberOfUsedJokers;
    }

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    public int getNumberOfUsedJokers() {
        return numberOfUsedJokers;
    }

    public Participant(String name, String surname, double points, int numberOfUsedJokers) {
        this.name = name;
        this.surname=surname;
        this.points = points;
        this.numberOfUsedJokers = numberOfUsedJokers;
    }
}
