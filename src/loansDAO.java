import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class loansDAO {


    public void LoanBook(){
        String sql = "INSERT INTO loans (customer_id, book_id) VALUES (?,?)";
        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.executeUpdate();
            System.out.println("Book successfully loaned");

        } catch (SQLException e) {
            System.out.println("failed to loan book");
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
            System.out.println("failed to return book");
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
