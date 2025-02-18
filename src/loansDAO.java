import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void returnBook(int customer_id, int book_id) {
        String sql = "UPDATE loans SET book_id=? WHERE customer_id=?";

        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, book_id);
            stmt.setInt(2, customer_id);

            stmt.executeUpdate();
            System.out.println("Book return successfully!!");

        } catch (SQLException e) {
            System.out.println("Failed to return book");
            e.printStackTrace();
        }

    }
    public List<loans> ListCurrrentLoans(){
        List<loans> loans = new ArrayList<>();
        String sql = "SELECT * FROM loans";

        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                loans.add(new loans(rs.getInt("loan_id"),
                        rs.getString("user_name"),
                        rs.getInt("book_id"),
                        rs.getDate("loan_date"),
                        rs.getDate("return_date")));
            }


            stmt.executeUpdate();
            System.out.println("List current loans!!");

        } catch (SQLException e) {
            System.out.println("failed to list current loans");
            e.printStackTrace();
        }
      return loans;
    }
}
