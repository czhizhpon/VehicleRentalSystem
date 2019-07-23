/**
 * @(#)ConnectionJava.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.conectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class ConnectionJava {
    private ConnectionDataBase connection;
    private PreparedStatement pstat;
    private ResultSet rstat;
    private Statement stat;

    public ConnectionJava() {
        connection = new ConnectionDataBase();
    }
    
    public void startConnection(){
        connection.setUrl("jdbc:oracle:thin:@localhost:1521:orcl:");
        connection.setUsername("hr");
        connection.setPassword("hr_123");
        connection.coneection();

        if (connection.getConnection() == null) {
            throw new NullPointerException("Faild connection with DataBase");
        }
        
    }
    
    public Connection getConnection(){
        return this.connection.getConnection();
    }
    
    public void closeConnection(){
        connection.closeConnection();
    }
}