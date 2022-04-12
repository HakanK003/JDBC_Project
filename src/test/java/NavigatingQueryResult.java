import java.sql.*;

public class NavigatingQueryResult {

    public static void main(String[] args) {

        String    url   = "jdbc:oracle:thin:@IP:1521:XE",
                username = "",
                password = "";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            //Statement doesn't allow going previous

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            rs.next();
            System.out.println("Region ID on first row is "+ rs.getString(1));
            System.out.println("Region ID on first row is "+ rs.getString("REGION_ID"));
            System.out.println("Region ID on first row is "+ rs.getString(2));
            System.out.println("Region ID on first row is "+ rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("Region ID on second row is "+ rs.getString(1));
            System.out.println("Region ID on second row is "+ rs.getString("REGION_ID"));
            System.out.println("Region ID on second row is "+ rs.getString(2));
            System.out.println("Region ID on second row is "+ rs.getString("REGION_NAME"));

            // if there are no next line, and we still try to get data we get exception


        } catch (SQLException e) {
            System.out.println("Connection has failed "+ e.getMessage());
        }


    }

}
