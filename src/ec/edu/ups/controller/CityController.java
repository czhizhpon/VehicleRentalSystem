/**
 * @(#)CityController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */

package ec.edu.ups.controller;


import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */

public class CityController {
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createCity(){
        
        return true;
    }
    
    public boolean readCity(ConnectionJava connection, City city, int proId, int citId){
        
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM vrs_cities \n" +
                        "WHERE pro_id =  ?\n" +
                        "AND cit_id = ?;";
        
        try {
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, proId);
            pstat.setInt(2, citId);
            
            rstat = pstat.executeQuery();
            
            while (rstat.next()) {
                
                city.setCitId(rstat.getInt(1));
                city.setCitName(rstat.getString(2));
                
            }
            
            connection.closeConnection();
            
        } catch (SQLException ex) {
            
            System.out.println(ex);
            return false;
        }
        return true;
        
    }
    
    public boolean getCities(ConnectionJava connection, List<City> cities, int proId){
        cities = new ArrayList<>();
        
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM vrs_cities \n" +
                        "WHERE pro_id = ?;";
        
        try {
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, proId);
            rstat = pstat.executeQuery();
            while (rstat.next()) {                
                City city = new City(rstat.getInt(1), rstat.getString(2));
                cities.add(city);
            }
            connection.closeConnection();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
}
