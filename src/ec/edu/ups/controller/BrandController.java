/**
 * @(#)BrandController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Brand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class BrandController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createBrand(ConnectionJava connection, Brand brand){
        String query = "INSERT INTO VRS.VRS_BRANDS VALUES(\n" 
                + "bra_id_seq.NEXTVAL,?)";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, brand.getBraName());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readBrand(ConnectionJava connection, Brand brand, int braId){
        String query = "SELECT * "
                + "FROM vrs.vrs_brands "
                + "WHERE bra_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, braId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                brand.setBraId(rstat.getInt(1));
                brand.setBraName(rstat.getString(2));
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateBrand(ConnectionJava connection, Brand brand){
        String query = "UPDATE vrs.vrs_brans SET "
                + "bra_name = ? "
                + "WHERE bra_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, brand.getBraName());
            pstat.setInt(2, brand.getBraId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteBrand(ConnectionJava connection, int braId){
        String query = "DELETE vrs.vrs_brands "
                + "WHERE bra_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, braId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        
        connection.closeConnection();
        return true;
    }
    
    public boolean getBrands(ConnectionJava connection, List<Brand>  brands){
        
        Brand brand;
        String query = "SELECT * "
                + "FROM vrs.vrs_brands";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                brand = new Brand();
                
                brand.setBraId(rstat.getInt(1));
                brand.setBraName(rstat.getString(2));
                
                brands.add(brand);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
