import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class loansDAO {


    public void LoanBook(int customer_id, int book_id, String user_name) {
        String sql = "INSERT INTO loans (customer_id, book_id,user_name) VALUES (?,?,?)";
        try {
            Connection conn = Database.getConnection();

            String checksql = "SELECT COUNT(*) FROM loans WHERE book_id=?";
            PreparedStatement ps = conn.prepareStatement(checksql);
            ps.setInt(1,book_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean isLoaned = rs.getInt(1) > 0;

            if (isLoaned) {
                System.out.println("Book is already loaned");
            } else {

                String Checkavailabity = "SELECT available FROM books WHERE books_id=?";
                PreparedStatement ps1 = conn.prepareStatement(Checkavailabity);
                ps1.setInt(1,book_id);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next() && rs1.getString("available").equalsIgnoreCase("No")) {
                    System.out.println("Book is not available");
                    return;
                }
                    String updatesql = "UPDATE books SET available=? WHERE books_id=?";
                    PreparedStatement ps2 = conn.prepareStatement(updatesql);
                    ps2.setString(1,"No");
                    ps2.setInt(2,book_id);
                    int update = ps2.executeUpdate();
                    if (update > 0) {
                        System.out.println("Book availablity updated");
                    }

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, customer_id);
                stmt.setInt(2, book_id);
                stmt.setString(3, user_name);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Book is successfully loaned");
                } else {
                    System.out.println("Error");
                }
            }

        } catch (SQLException e) {
            System.out.println("Failed to loan book");
            e.printStackTrace();
        }

    }
    public void returnBook(int customer_id, int book_id) {
       String sql = "DELETE FROM loans WHERE customer_id=? AND book_id=?";

        try {
            Connection conn = Database.getConnection();


            String updatesql = "UPDATE books SET available=? WHERE books_id=?";
            PreparedStatement ps = conn.prepareStatement(updatesql);
            ps.setInt(2,book_id);
            ps.setString(1,"Yes");
            int update = ps.executeUpdate();
            if (update > 0) {
                System.out.println("Book is available");
            }

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, customer_id);
            stmt.setInt(2, book_id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book successfully returned");
            } else {
                System.out.println("Failed to return book: No matching record found");
            }
        } catch (SQLException e) {
            System.out.println("Failed to return book");
            e.printStackTrace();
        }

    }
    public List<loans> ListCurrrentLoans(int customerid){
        List<loans> loans = new ArrayList<>();

        String sql = "SELECT * FROM loans WHERE customer_id=?";

        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customerid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                loans.add(new loans(rs.getInt("loan_id"),
                        rs.getString("user_name"),
                        rs.getInt("book_id"),
                        rs.getDate("loan_date"),
                        rs.getDate("return_date")));
            }


        } catch (SQLException e) {
            System.out.println("failed to list current loans");
            e.printStackTrace();
        }
      return loans;
    }
}
