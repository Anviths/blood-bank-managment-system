/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjBack;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Cherry
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BloodBank", "postgres", "root");
            return connection;
        }       
        catch(Exception e) {
            return null;
        }
    }
            
}
