package all.model;

public class Bet {
    private int position;
    private String surname;

    public Bet(int position, String surname) {
        this.position = position;
        this.surname = surname;
    }

    public int getPosition() {
        return position;
    }

    public String getSurname() {
        return surname;
    }


}
