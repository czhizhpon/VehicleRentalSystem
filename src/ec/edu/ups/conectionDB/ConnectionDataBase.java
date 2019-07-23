/**
 * @(#)ConnectionDataBase.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.conectionDB;

import java.sql.*;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class ConnectionDataBase {
    
    private String username;
    private String password;
    private String url;
    private Connection connection;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public void coneection(){
        try {
            this.setConnection(DriverManager.getConnection(this.getUrl(),
                    this.getUsername(), this.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //metodo para cerrar unaconexion a la base de datos
    public void closeConnection(){
        try {
            if (this.getConnection() != null && !this.getConnection().isClosed()) {
                this.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
