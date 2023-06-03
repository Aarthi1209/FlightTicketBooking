
package flight;

import java.sql.*;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/hotelmanagementsystem"; 
            c =DriverManager.getConnection("jdbc:mysql:///flight","root","Aarthipoornimaa51827");             
            s =c.createStatement();  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  