import java.sql.*;

public class Transactions {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username="root";
        String psd = "sai123";
        Connection con = null;
        Statement stmt=null;
        ResultSet res=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");
            con = DriverManager.getConnection(url,username,psd);
            String q = "select * from std where stdid=11 and name='sai'";
            stmt = con.createStatement();
            res= stmt.executeQuery(q);
            res.next();
            System.out.println(res.getInt(3)+"    "+res.getString(2));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
