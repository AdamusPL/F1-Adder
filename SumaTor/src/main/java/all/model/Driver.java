package all.model;

public class Driver {
    private int position;
    private int number;
    private String name;
    private String team;
    private int drivenLaps;
    private String lose;
    private int points;
    private String time1;
    private String time2;
    private String time3;

    //Race
    public Driver(int position, int number, String name, String team, int drivenLaps, String lose, int points) {
        this.position = position;
        this.number = number;
        this.name = name;
        this.team = team;
        this.drivenLaps = drivenLaps;
        this.lose = lose;
        this.points = points;
    }

    //Q3
    public Driver(int position, int number, String name, String team, String time1, String time2,
                  String time3, int drivenLaps) {
        this.position = position;
        this.number = number;
        this.name = name;
        this.team = team;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.drivenLaps = drivenLaps;
    }

    //Q2
    public Driver(int position, int number, String name, String team, String time1, String time2,
                  int drivenLaps) {
        this.position = position;
        this.number = number;
        this.name = name;
        this.team = team;
        this.time1 = time1;
        this.time2 = time2;
        this.drivenLaps = drivenLaps;
    }

    //Q1
    public Driver(int position, int number, String name, String team, String time1, int drivenLaps) {
        this.position = position;
        this.number = number;
        this.name = name;
        this.team = team;
        this.time1 = time1;
        this.drivenLaps = drivenLaps;
    }

    //DNS
    public Driver(int position, int number, String name, String team, int drivenLaps) {
        this.position = position;
        this.number = number;
        this.name = name;
        this.team = team;
        this.drivenLaps = drivenLaps;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
