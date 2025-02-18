import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class booksDAO {

    public void addBook(String title, String author,String available) {

        String sql = "INSERT INTO books (title, author,available) VALUES (?,?,?)";

        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, available);

            stmt.executeUpdate();
            System.out.println("book added successfully!!");

        } catch (SQLException e) {
            System.out.println("failed to add book");
            e.printStackTrace();
        }
    }
    public void deleteBook(int books_id) {

        String sql = "DELETE FROM books WHERE books_id = ?";

        try{
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, books_id);

            stmt.executeUpdate();
            System.out.println("Book deleted");

        }catch(SQLException e){
            System.out.println("Failed to delete book");
            e.printStackTrace();
        }


    }

    public List<books> getAllBooks() {
        List<books> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
              books.add(new books(rs.getString("title"),
                      rs.getString("author"),
                      rs.getString("available")));
            }

        } catch (SQLException e) {
            System.out.println("failed to get books");
            e.printStackTrace();
        }

        return books;
    }
}
