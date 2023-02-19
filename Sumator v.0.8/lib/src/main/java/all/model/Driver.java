package all.model;

public class Driver {
    int position;
    int number;
    String name;
    String team;
    int drivenLaps;
    String lose;
    int points;

    public Driver(int position, int number, String name, String team, int drivenLaps, String lose, int points) {
        this.position = position;
        this.number = number;
        this.name = name;
        this.team = team;
        this.drivenLaps = drivenLaps;
        this.lose = lose;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getDrivenLaps() {
        return drivenLaps;
    }

    public void setDrivenLaps(int drivenLaps) {
        this.drivenLaps = drivenLaps;
    }

    public String getLose() {
        return lose;
    }

    public void setLose(String lose) {
        this.lose = lose;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
