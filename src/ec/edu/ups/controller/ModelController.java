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
 
    private BrandController conBrand;
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    

    public ModelController() {
        conBrand = new BrandController();
    }

    public BrandController getConBrand() {
        return conBrand;
    }

    public void setConBrand(BrandController conBrand) {
        this.conBrand = conBrand;
    }
    
    public boolean createModel(ConnectionJava connection, Model model, 
            int braId){
        
        String query = "INSERT INTO VRS.VRS_MODELS VALUES(\n"
                + "mod_id_seq.NEXTVAL, ?, ?, ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, model.getModName());
            pstat.setDouble(2, model.getModCost());
            pstat.setInt(3, braId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readModel(ConnectionJava connection, Model model, int modId){
        Brand brand;
        
        String query = "SELECT * "
                + "FROM vrs.vrs_models "
                + "WHERE mod_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, modId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                model.setModId(rstat.getInt(1));
                model.setModName(rstat.getString(2));
                model.setModCost(rstat.getDouble(3));
                
                brand = new Brand();
                
                this.conBrand.readBrand(connection, brand, rstat.getInt(4));
                
                model.setModBrand(brand);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateModel(ConnectionJava connection, Model model){
        
        String query = "UPDATE vrs.vrs_models SET "
                + "mod_name = ? "
                + "mod_price = ? "
                + "bra_id = ? "
                + "WHERE mod_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, model.getModName());
            pstat.setDouble(2, model.getModCost());
            pstat.setInt(3, model.getModBrand().getBraId());
            pstat.setInt(4, model.getModId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteModel(ConnectionJava connection, int modId){
        
        String query = "DELETE vrs.vrs_models "
                + "WHERE mod_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, modId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean getModels(ConnectionJava connection, List<Model> models, 
            Brand brand){
        
        Model model;
        String query = "SELECT * "
                + "FROM vrs.vrs_models "
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
                
                this.conBrand.readBrand(connection, brand, rstat.getInt(4));
                
                model.setModBrand(brand);
                
                models.add(model);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
