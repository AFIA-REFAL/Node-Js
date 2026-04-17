
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployeeDelete {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24WH1A0577", "root", "12345");

            Statement statement = connection.createStatement();

            String deleteQuery = "DELETE FROM employee WHERE salary = 50000";
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println("Rows deleted: " + rowsDeleted);

            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getInt(3) + "\t" +
                    rs.getString(4)
                );
            }

            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}