/**
 * @(#)VehCategoryController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.VehCategory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class VehCategoryController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createVehCategory(ConnectionJava connection, 
            VehCategory vehCategory){
        
        String query = "INSERT INTO vrs.vrs_veh_categories VALUES( " 
                + "veh_cat_id_seq.NEXTVAL, ?, ?, ?);";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, vehCategory.getCatName());
            pstat.setDouble(2, vehCategory.getCatDayCost());
            pstat.setDouble(3, vehCategory.getCatDamageCost());
            pstat.setInt(4, vehCategory.getCatWarrantyPct());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readVehCategory(ConnectionJava connection, 
            VehCategory vehCategory, int catId){
        
        String query = "SELECT * "
                + "FROM vrs.vrs_veh_categories "
                + "WHERE cat_id = ? ";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, catId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                vehCategory.setCatId(rstat.getInt(1));
                vehCategory.setCatName(rstat.getString(2));
                vehCategory.setCatDayCost(rstat.getInt(3));
                vehCategory.setCatDamageCost(rstat.getInt(4));
                vehCategory.setCatWarrantyPct(rstat.getInt(5));
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateVehCategory(ConnectionJava connection, 
            VehCategory vehCategory){
        
        String query = "UPDATE vrs.vrs_cat_vehicles SET "
                + "cat_name = ? "
                + "cat_day_cost = ? "
                + "cat_damage_cost = ? "
                + "cat_warranty_pct = ? "
                + "WHERE cat_id = ? ";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, vehCategory.getCatName());
            pstat.setDouble(2, vehCategory.getCatDayCost());
            pstat.setDouble(3, vehCategory.getCatDamageCost());
            pstat.setInt(4, vehCategory.getCatWarrantyPct());
            pstat.setInt(5, vehCategory.getCatId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteVehCategory(ConnectionJava connection, 
            int catId){
        
        String query = "DELETE vrs.vrs_catVehicle "
                + "WHERE cat_id = ? ";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, catId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean getVehCategories(ConnectionJava connection, List<VehCategory> VehCategories){
        
        VehCategory vehCategory;
        String query = "SELECT * "
                + "FROM vrs.vrs_veh_categories ";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                vehCategory = new VehCategory();
                
                vehCategory.setCatId(rstat.getInt(1));
                vehCategory.setCatName(rstat.getString(2));
                vehCategory.setCatDayCost(rstat.getInt(3));
                vehCategory.setCatDamageCost(rstat.getInt(4));
                vehCategory.setCatWarrantyPct(rstat.getInt(5));
                
                VehCategories.add(vehCategory);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
