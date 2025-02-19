public class books {

    private int books_id;

    private String title;

   private String author;

    private String available;


    public books(int books_id,String title, String author, String available) {
        this.books_id = books_id;
        this.title = title;
        this.author = author;
        this.available = available;
    }



    public int getBooks_id() {
        return books_id;
    }
    public void setBooks_id(int books_id) {
        this.books_id = books_id;
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
                "books_id " + books_id +
                ", title " + title +
                ", author " + author +
                ", available='" + available;
    }
}
