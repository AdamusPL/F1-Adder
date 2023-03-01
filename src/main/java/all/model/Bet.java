package all.model;

public class Bet {
    int position;
    String surname;

    public Bet(int position, String surname) {
        this.position=position;
        this.surname=surname;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



}
