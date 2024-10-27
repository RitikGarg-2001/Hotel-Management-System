package hotelmanagementproject;
import java.sql.*;  
public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:/// Hotal_Mangement_Project","root","Ritik@139045"); 
            s =c.createStatement();  
        }catch(Exception e){ 
            e.printStackTrace();
        }  
    }  
}