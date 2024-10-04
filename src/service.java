import java.sql.*;

public class service {
    public static void main(String[] args) {

        PreparedStatement pst = null;
        Statement st = null;
        Connector con = new Connector();
        String query = "select * from questions where subject='fec'";
        try {
            Connection c = con.connect();
            st = c.createStatement();
         ResultSet r =  st.executeQuery(query);
         while (r.next()){
             for (int i = 2 ; i <= 12 ; i++) {
                 System.out.println(r.getString(i));
             }
         }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
