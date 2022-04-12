import java.sql.*;

public class EachColumnData {

    public static void main(String[] args) {


        String    url   = "jdbc:oracle:thin:@IP:1521:XE",
                username = "",
                password = "";

        try {


            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");



            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
//            String firstColumnName = rsmd.getColumnName(1);
//
//            System.out.println("columnCount = " + columnCount);
//            System.out.println("firstColumnName = " + firstColumnName);


//            for (int colIndex = 1; colIndex < columnCount; colIndex++) {
//
//                System.out.println("rsdm.getColumnName("+colIndex+") = "+rsmd.getColumnName(colIndex));
//
//            }

            
//            //print all data in one row logic
//            rs.next();
//            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
//
//                System.out.println("rsdm.getString("+colIndex+") = "+rs.getString(colIndex));
//
//            }
//
//            rs.next();
//            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
//
//                System.out.println("rsdm.getString("+colIndex+") = "+rs.getString(colIndex));
//
//            }



            //print all data in one row

            while (rs.next()){

                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {

                System.out.print(rs.getString(colIndex)+"\t");

                }

                System.out.println();

            }

        } catch (SQLException e) {
            System.out.println("Connection has failed "+ e.getMessage());
        }

    }

}
