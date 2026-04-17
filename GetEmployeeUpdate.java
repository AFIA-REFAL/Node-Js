
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GetEmployeeUpdate {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24WH1A0577?serverTimezone=UTC", "root", "12345");

            Statement statement = connection.createStatement();
            String updateQuery = "UPDATE employee SET salary = 900000 WHERE empid = 3";
            int rowsAffected = statement.executeUpdate(updateQuery);
            System.out.println("Rows updated: " + rowsAffected);

            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" +
                                   rs.getString(2) + "\t" +
                                   rs.getString(3) + "\t" +
                                   rs.getString(4));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}