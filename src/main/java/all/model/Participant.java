package all.model;

public class Participant {
    String name;
    String surname;
    double points;
    int numberOfUsedJokers;

    String sprintBets;
    String sprintShootoutBets;
    String qualiBets;
    String raceBets;

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

    public void setSurname(String surname) {
        this.surname = surname;
    }

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
