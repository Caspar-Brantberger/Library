import java.util.Date;

public class loans {

    private int loan_id;

    private String user_name;

    private int book_id;

    private Date loan_date;

    private Date return_date;

    public loans(int loan_id, String user_name, int book_id, Date loan_date, Date return_date) {
        this.loan_id = loan_id;
        this.user_name = user_name;
        this.book_id = book_id;
        this.loan_date = loan_date;
        this.return_date = return_date;
    }
    public int getLoan_id() {
        return loan_id;
    }
    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public Date getLoan_date() {
        return loan_date;
    }
    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }
    public Date getReturn_date() {
        return return_date;
    }
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return
                "loan_id " + loan_id +
                ", user_name " + user_name +
                ", book_id " + book_id +
                ", loan_date " + loan_date +
                ", return_date " + return_date;
    }
}
