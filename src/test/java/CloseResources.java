import java.sql.*;

public class CloseResources {

    public static void main(String[] args) {

        String    url   = "jdbc:oracle:thin:@IP:1521:XE",
                username = "",
                password = "";


        // try with resources --> only work with auto closable resource (comes from auto closable interface)
        try(
                Connection com = DriverManager.getConnection(url, username, password);
                Statement stmt = com.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS")
            ){

            rs.next();
            System.out.println(rs.getString(2));

        }catch (SQLException e){

            System.out.println("Exception occurred "+ e.getMessage());

        }

//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = DriverManager.getConnection(url, username, password);
//            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
//
//            System.out.println("All Successful");
//
//        } catch (SQLException e) {
//
//            System.out.println("Exception has occurred "+ e.getMessage());
//
//        }finally {
//
//            try {
//
//                if (rs!=null) rs.close();
//                if (stmt!=null) stmt.close();
//                if (con!=null) con.close();
//
//            } catch (SQLException e) {
//
//                System.out.println("Exception while closing "+e.getMessage());
//
//            }
//     }




    }

}
