/**
 * @(#)ProvinceController.java	0.0.1, 19-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */

package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Province;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

/**
 * @since 19-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class ProvinceController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    
    public boolean createProvince(ConnectionJava connection, Province province){
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateProvince(ConnectionJava connection, Province province){
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readProvince(ConnectionJava connection, Province province, 
            int proId){
        
        String query = "SELECT *\n" +
                        "FROM vrs_provinces \n;" + 
                        "WHERE pro_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, proId);
            
            rstat = pstat.executeQuery();
                    
        } catch (SQLException ex){
            
        }
        
        return true;
    }
    
    public boolean deleteProvince(ConnectionJava connection, Province province){
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    
    public boolean getProvinces(ConnectionJava connection, List<Province> provinces){
        provinces =  new ArrayList<>();
        
        String query = "SELECT *\n" +
                        "FROM vrs_provinces;";
        
        try {
            pstat = connection.getConnection().prepareStatement(query);
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                Province province = new Province(rstat.getInt(1), 
                        rstat.getString(2));
                provinces.add(province);
            }
            connection.closeConnection();
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        
        return true;
    }
}
