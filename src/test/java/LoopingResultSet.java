import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args) {

        String    url   = "jdbc:oracle:thin:@IP:1521:XE",
                username = "",
                password = "";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");


            while (rs.next()){

                System.out.println(rs.getString(1)+" | "+rs.getString(2));

            }


            rs.beforeFirst();  //Otherwise, it won't work
            while (rs.next()){

                System.out.println("Row number is "+rs.getRow());
                System.out.println(rs.getString(1)+" | "+rs.getString(2));

            }


            // Getting Row Count --> move cursor to the last row and get the row number
            rs.last();
            System.out.println("Row count is "+ rs.getRow());


        } catch (SQLException e) {
            System.out.println("Connection has failed "+ e.getMessage());
        }

    }

}
