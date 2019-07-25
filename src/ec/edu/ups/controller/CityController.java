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
import ec.edu.ups.model.Province;
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
    
    public boolean createCity(ConnectionJava connection, City city, int proId){
        String query = "INSERT INTO VRS_CITIES VALUES(\n" 
                + "cit_id_seq.NEXTVAL, ?, ?)";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, city.getCitName());
            pstat.setInt(2, proId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readCity(ConnectionJava connection, City city, Province province, 
            int citId){
        
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM vrs_cities \n" +
                        "WHERE pro_id =  ?\n" +
                        "AND cit_id = ?;";
        
        try {
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, province.getProId());
            pstat.setInt(2, citId);
            
            rstat = pstat.executeQuery();
            
            while (rstat.next()) {
                
                city.setCitId(rstat.getInt(1));
                city.setCitName(rstat.getString(2));
                
            }
            
            connection.closeConnection();
            
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        return true;
        
    }
    
    public boolean updateCity(ConnectionJava connection, City city){
        String query = "UPDATE vrs_cities SET"
                + "cit_name = ?"
                + "pro_name = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, city.getCitName());
            pstat.setInt(2, city.getCitProvince().getProId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteCity(ConnectionJava connection, int citId){
        String query = "DELETE vrs_cities "
                + "WHERE cit_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, citId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean getCities(ConnectionJava connection, List<City> cities, 
            int proId){
        City city;
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM vrs_cities \n" +
                        "WHERE pro_id = ?;";
        
        try {
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, proId);
            rstat = pstat.executeQuery();
            while (rstat.next()) {                
                city = new City(rstat.getInt(1), rstat.getString(2));
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
