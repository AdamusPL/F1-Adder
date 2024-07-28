package all.model;

public class Participant {
    private String name;
    private String surname;
    private double points;
    private int numberOfUsedJokers;

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
        this.surname = surname;
        this.points = points;
        this.numberOfUsedJokers = numberOfUsedJokers;
    }
}
