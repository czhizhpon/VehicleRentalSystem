/**
 * @(#)CityController.java	0.0.5, 22-Jul-2019 
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
 * @since   22-Jul-2019
 * @version 0.0.5
 * @author  Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */

public class CityController {
    
    private ProvinceController conProvince;
    
    private PreparedStatement pstat;
    private ResultSet rstat;

    public CityController() {
        conProvince = new ProvinceController();
    }
    
    public boolean createCity(ConnectionJava connection, City city, int proId){
        String query = "INSERT INTO VRS.VRS_CITIES VALUES(\n" 
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
    
    public boolean readCity(ConnectionJava connection, City city, 
            int citId){
        
        Province province;
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM VRS.VRS_CITIES \n" +
                        "WHERE it_id = ? ";
        
        try {
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, citId);
            
            rstat = pstat.executeQuery();
            
            while (rstat.next()) {
                
                city.setCitId(rstat.getInt(1));
                city.setCitName(rstat.getString(2));
                
                province = new Province();
                
                this.conProvince.readProvince(connection, province, 
                        rstat.getInt(3));
                
                city.setCitProvince(province);
                
            }
            
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        return true;
    }
    
    public boolean updateCity(ConnectionJava connection, City city){
        String query = "UPDATE VRS.VRS_CITIES SET "
                + "cit_name = ? "
                + "pro_id = ? "
                + "WHERE cit_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, city.getCitName());
            pstat.setInt(2, city.getCitProvince().getProId());
            pstat.setInt(3, city.getCitId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteCity(ConnectionJava connection, int citId){
        String query = "DELETE VRS.VRS_CITIES "
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
            Province province){
        
        City city;
        String query =  "SELECT cit_id, cit_name\n" +        
                        "FROM vrs.vrs_cities \n" +
                        "WHERE pro_id = ?";
        
        try {
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, province.getProId());
            rstat = pstat.executeQuery();
            
            while (rstat.next()) {
                
                city = new City(rstat.getInt(1), rstat.getString(2));
                city.setCitProvince(province);
                cities.add(city);
                
            }
            
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        return true;
    }
    
}
