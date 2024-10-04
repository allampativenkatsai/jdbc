
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        String url = "jdbc:mysql://localhost:3306/student";
        String username="root";
        String psd = "sai123";
        Scanner s = new Scanner(System.in);
        int stdid;
        String name;
        int phno;
        String email;
        PreparedStatement stmt=null;
        Connection con=null;
        int n ;
    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver loaded");
       con = DriverManager.getConnection(url,username,psd);
        System.out.println("connection  established");
        String q = "insert into std (`stdid`,`name`,`phno`,`email`) values (?,?,?,?)";
        stmt = con.prepareStatement(q);
        System.out.println("enter the value of  n");
      //  n= s.nextInt();
       con.setAutoCommit(false);
        /* for (int i = 0 ; i < n ; i++) {
            System.out.println("enter the value of id ");
            stdid = s.nextInt();
            System.out.println("enter the value of name");
            name = s.next();
            System.out.println("enter the value of phno ");
            phno = s.nextInt();
            System.out.println("enter the value of email");
            email = s.next();
            stmt.setInt(1, stdid);
            stmt.setString(2, name);
            stmt.setInt(3, phno);
            stmt.setString(4, email);
             stmt.execute();
        }*/
       //stmt.executeBatch();1
        String q1 = "update std set phno=? where stdid=?";
         stmt = con.prepareStatement(q1);
        stdid= s.nextInt();
        phno = s.nextInt();
       stmt.setInt(1,phno);
       stmt.setInt(2,stdid);
               stmt.execute();
        String q2 = "update std set phno=? where stdid=?";
        stmt = con.prepareStatement(q2);
        stdid= s.nextInt();
        phno = s.nextInt();
        stmt.setInt(1,phno);
        stmt.setInt(2,stdid);
        stmt.execute();
        Statement h = con.createStatement();
        h.execute(q2);

        con.commit();
      /*  System.out.println("which should delete");
        stdid= s.nextInt();
        String query = "delete from std where stdid=?";
        PreparedStatement h = con.prepareStatement(query);
        h.setInt(1,stdid);
        h.execute();*/

    }catch (ClassNotFoundException  e){
        System.out.println("driver not loaded");
    }catch (SQLException e ){
        System.out.println("connection not established");
    }
    try{
       stmt.close();
       con.close();
    } catch (SQLException e) {
        System.out.println("connection not established");
    }

    }
}