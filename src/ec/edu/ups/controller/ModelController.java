/**
 * @(#)ModelController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Brand;
import ec.edu.ups.model.Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class ModelController {
 
    private BrandController modBrand;
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createModel(ConnectionJava connection, Model model, int braId){
        
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
    
    public boolean readModel(ConnectionJava connection, Model model, int modId, 
            Brand brand){
        
        
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                model.setModId(rstat.getInt(1));
                model.setModName(rstat.getString(2));
                model.setModCost(rstat.getDouble(3));
                model.setModBrand(brand);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateModel(ConnectionJava connection, Model model){
        
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
    
    public boolean deleteModel(ConnectionJava connection, int modId){
        
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
    
    public boolean getModels(ConnectionJava connection, List<Model> models, 
            Brand brand){
        
        Model model;
        String query = "SELECT *"
                + "FROM vrs_models"
                + "WHERE bra_id = ?";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, brand.getBraId());
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                model = new Model();
                brand = new Brand();
                
                model.setModId(rstat.getInt(1));
                model.setModName(rstat.getString(2));
                model.setModCost(rstat.getDouble(3));
                
                this.modBrand.readBrand(connection, brand, rstat.getInt(4));
                
                model.setModBrand(brand);
                
                models.add(model);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
