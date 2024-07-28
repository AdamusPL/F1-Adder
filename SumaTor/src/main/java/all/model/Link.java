package all.model;

public class Link {
    public String getFullname() {
        return fullname;
    }

    private String fullname;
    private String name;

    public Link(String link, String fullname) {
        this.name = link;
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

}
