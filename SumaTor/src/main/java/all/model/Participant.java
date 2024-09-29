package all.model;

public class Participant {
    private String name;
    private String surname;
    private double points;
    private int numberOfUsedJokers;

    private String sprintBets;
    private String sprintShootoutBets;
    private String qualiBets;

    public String getSurname() {
        return surname;
    }

    public String getSprintBets() {
        return sprintBets;
    }

    public String getSprintShootoutBets() {
        return sprintShootoutBets;
    }

    public String getQualiBets() {
        return qualiBets;
    }

    public String getRaceBets() {
        return raceBets;
    }

    private String raceBets;

    public void setSprintBets(String sprintBets) {
        this.sprintBets = sprintBets;
    }

    public void setSprintShootoutBets(String sprintShootoutBets) {
        this.sprintShootoutBets = sprintShootoutBets;
    }

    public void setQualiBets(String qualiBets) {
        this.qualiBets = qualiBets;
    }

    public void setRaceBets(String raceBets) {
        this.raceBets = raceBets;
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
