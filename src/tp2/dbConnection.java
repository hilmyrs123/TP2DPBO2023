/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author HILMY
 */
public class dbConnection {
    private Statement stat = null;
    private Connection conn = null;
    
    public dbConnection(){
        String ConAddress = "jdbc:mysql://localhost/tp2";
        String user = "root";
        String pass = "";
        connect(ConAddress, user, pass);
    }
    
    private void connect(String ConAddress, String username, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(ConAddress, username, password);
            stat = conn.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet selectQuery(String sql){
        try{
            stat.executeQuery(sql);
            return stat.getResultSet();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    public int updateQuery(String sql){
        try{
           return stat.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return 0;
    }
    
    public Statement getStatement(){
        return stat;
    }
}
