package all;

import javax.swing.*;

public class Participant {
    String name;
    double points;
    int numberOfUsedJokers;
    JTextField pointsField;
    JTextField jokersField;

    public Participant(String name, double points, int numberOfUsedJokers, JTextField pointsField, JTextField jokersField) {
        this.name = name;
        this.points = points;
        this.numberOfUsedJokers = numberOfUsedJokers;
        this.pointsField = pointsField;
        this.jokersField = jokersField;
    }
}
