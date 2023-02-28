package all.model;

public class Link {
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    String fullname;
    String name;
    public Link(String link, String fullname) {
        this.name=link;
        this.fullname=fullname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
