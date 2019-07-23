/**
 * @(#)VehicleController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.VehCategory;
import ec.edu.ups.model.Vehicle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class VehicleController {
    
    private VehCategoryController vehCategoryController;
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createVehicle(ConnectionJava connection, Vehicle vehicle){
        
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
    
    public boolean readVehicle(ConnectionJava connection, Vehicle vehicle){
        
        VehCategory vehCategory;
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                vehCategory = new VehCategory();
                
                
                this.vehCategoryController.readVehCategory(connection, 
                        vehCategory, 5);
                vehicle.setVehCategory(vehCategory);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateVehicle(ConnectionJava connection, 
            Vehicle vehicle){
        
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
    
    public boolean deleteVehicle(ConnectionJava connection, int vehId){
        
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
    
    public boolean getVehicles(ConnectionJava connection, 
            List<Vehicle> vehicles){
        
        Vehicle vehicle;
        VehCategory vehCategory;
        String query = "";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                vehicle = new Vehicle();
                vehCategory = new VehCategory();
                
                
                
                this.vehCategoryController.readVehCategory(connection, 
                        vehCategory, 5);
                vehicle.setVehCategory(vehCategory);
                vehicles.add(vehicle);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
