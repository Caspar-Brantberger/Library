public class books {

    private String title;

   private String author;

    private String available;


    public books(String title, String author, String available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAvailable() {
        return available;
    }
    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return
                "title: " + title +
                ", author='" + author +
                ", available='" + available;
    }
}
