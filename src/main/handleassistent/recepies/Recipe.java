package recepies;

public class Recipe {
    private String title;
    private String[] ingridients;
    private String url;
    Recipe (String title, String[] ingridients, String url) {
        this.title = title;
        this.ingridients = ingridients;
        this.url = url;
    }
    public String getTitle() { return title; }
    public String[] getIngridients() { return ingridients; }
    public String getUrl() { return url; }

}
