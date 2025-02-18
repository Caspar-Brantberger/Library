import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void addCustomer(String name, String email) {

        String sql = "INSERT INTO customers (name, email) VALUES (?,?)";

        try {
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);

            stmt.executeUpdate();
            System.out.println("customer added successfully!!");

        } catch (SQLException e) {
            System.out.println("failed to add customer");
            e.printStackTrace();
        }
    }
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";

        try{
            Connection conn = Database.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Customer deleted");

        }catch(SQLException e){
            System.out.println("Failed to delete Customer");
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customers";

        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")));

            }


        } catch (SQLException e) {
            System.out.println("failed to get customers");
            e.printStackTrace();
        }

        return customers;
    }
}
