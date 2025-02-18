import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class loansDAO {


    public void LoanBook(int customer_id, int book_id) {
        String sql = "INSERT INTO loans (customer_id, book_id) VALUES (?,?)";
        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customer_id);
            stmt.setInt(2, book_id);


            stmt.executeUpdate();
            System.out.println("Book successfully loaned");

        } catch (SQLException e) {
            System.out.println("Failed to loan book");
            e.printStackTrace();
        }

    }
    public void returnBook(){
        String sql = "UPDATE loans SET book_id=? WHERE customer_id=?";

        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);


            stmt.executeUpdate();
            System.out.println("Book return successfully!!");

        } catch (SQLException e) {
            System.out.println("Failed to return book");
            e.printStackTrace();
        }

    }
    public void ListCurrrentLoans(){
        String sql = "SELECT * FROM loans";

        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);


            stmt.executeUpdate();
            System.out.println("List current loans!!");

        } catch (SQLException e) {
            System.out.println("failed to list current loans");
            e.printStackTrace();
        }

    }
}
