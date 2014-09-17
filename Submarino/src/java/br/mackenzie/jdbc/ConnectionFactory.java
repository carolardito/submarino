/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Ricardo
 */
public class ConnectionFactory {
    
    private static ConnectionFactory connectionFactory = null;
    
    private ConnectionFactory(){
    }
      
    public static ConnectionFactory getInstance(){
        if (connectionFactory == null)
            connectionFactory = new ConnectionFactory();        
        return connectionFactory;
    }
    
    public Connection getConnection() throws SQLException{
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Util.configuracao");
        Connection connection = null;
        try {
            Class.forName(resourceBundle.getString("driver"));
            connection = DriverManager.getConnection(resourceBundle.getString("url"),
                    resourceBundle.getString("usuario"),
                    resourceBundle.getString("senha"));
        }catch (Exception e){
            
        }
        return connection;
    }    
}
