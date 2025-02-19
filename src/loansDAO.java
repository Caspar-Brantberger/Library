import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class loansDAO {

books b1 = new books(1,"",null,null);
Customer c1 = new Customer(1,"","");

    public void LoanBook(int customer_id, int book_id, String user_name) {
        String sql = "INSERT INTO loans (customer_id, book_id,user_name) VALUES (?,?,?)";
        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customer_id);
            stmt.setInt(2, book_id);
            stmt.setString(3,user_name);


             if (b1.getBooks_id() == book_id) {
                 System.out.println("Book is already loaned");
             }else{
                 stmt.executeUpdate();
                 System.out.println("Book successfully loaned");
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
