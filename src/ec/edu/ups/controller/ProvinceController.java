/**
 * @(#)ProvinceController.java	0.0.5, 19-Jul-2019 
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
 * @since   19-Jul-2019
 * @version 0.0.5
 * @author  Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class ProvinceController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;

    public ProvinceController() {
        
    }
    
    public boolean createProvince(ConnectionJava connection, Province province){
        String query = "INSERT INTO VRS.VRS_PROVINCES VALUES(\n"
                + "pro_id_seq.NEXTVAL, ?)";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, province.getProName());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean updateProvince(ConnectionJava connection, Province province){
        String query = "UPDATE VRS.VRS_PROVINCES SET "
                + "pro_name = ? "
                + "WHERE bra_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, province.getProName());
            pstat.setInt(2, province.getProId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean readProvince(ConnectionJava connection, Province province, 
            int proId){
        
        String query =  "SELECT *\n" +
                        "FROM VRS.VRS_PROVINCES \n" + 
                        "WHERE pro_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, proId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                province.setProId(rstat.getInt(1));
                province.setProName(rstat.getString(2));
            }
            
        } catch (SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean readProvince(ConnectionJava connection, Province province, 
            String proName){
        
        String query =  "SELECT *\n" +
                        "FROM VRS.VRS_PROVINCES \n" + 
                        "WHERE pro_name = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, proName);
            
            rstat = pstat.executeQuery();
            while(rstat.next()){
                province.setProId(rstat.getInt(1));
                province.setProName(rstat.getString(2));
            }
            
            
        } catch (SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean deleteProvince(ConnectionJava connection, Province province){
        String query = "DELETE VRS.VRS_PROVINCES "
                + "WHERE pro_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    
    public boolean getProvinces(ConnectionJava connection, 
            List<Province> provinces){
        
        Province province;
        String query = "SELECT *\n" +
                       "FROM VRS.VRS_PROVINCES";
        
        try {
            
            pstat = connection.getConnection().prepareStatement(query);
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                province = new Province();
                
                province.setProId(rstat.getInt(1));
                province.setProName(rstat.getString(2));
                
                provinces.add(province);
                
            }
            
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
}
