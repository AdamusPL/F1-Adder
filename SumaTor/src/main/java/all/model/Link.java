package all.model;

public class Link {
    public String getUrl() {
        return url;
    }

    public String getGpName(){
        return gpName;
    }

    private String url;
    private String gpName;

    public Link(String gpName, String url) {
        this.url = url;
        this.gpName = gpName;
    }
}