import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        String    url   = "jdbc:oracle:thin:@IP:1521:XE",
               username = "",
               password = "";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed "+ e.getMessage());
        }

    }

}
