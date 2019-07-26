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
    
    private BrandController conBrand;
    private ModelController conModel;
    private VehCategoryController vehCategoryController;
    
    private PreparedStatement pstat;
    private ResultSet rstat;

    public BrandController getConBrand() {
        return conBrand;
    }

    public void setConBrand(BrandController conBrand) {
        this.conBrand = conBrand;
    }

    public ModelController getConModel() {
        return conModel;
    }

    public void setConModel(ModelController conModel) {
        this.conModel = conModel;
    }

    public VehCategoryController getVehCategoryController() {
        return vehCategoryController;
    }

    public void setVehCategoryController(VehCategoryController vehCategoryController) {
        this.vehCategoryController = vehCategoryController;
    }
    
    public boolean createVehicle(ConnectionJava connection, Vehicle vehicle){
        
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean readVehicle(ConnectionJava connection, Vehicle vehicle, 
            int vehId){
        
        VehCategory vehCategory;
        String query = "SELECT veh_id, veh_plate, veh_color, veh_status, veh_kilometrage,"
                + "veh_insurance_number, veh_insurrance_date, veh_insurrance_expires,"
                + "veh_origin, cat_id"
                + "FROM vrs_vehicle"
                + "WHERE veh_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, vehId);
            
            rstat = pstat.executeQuery();
            
            /*offId, modId, catId, proId*/
            while(rstat.next()){
                
                vehicle.setVehId(rstat.getInt(1));
                vehicle.setVehPlate(rstat.getString(2));
                vehicle.setVehColor(rstat.getString(3));
                vehicle.setVehStatus(rstat.getString(4).charAt(0));
                vehicle.setVehKilometraje(rstat.getDouble(5));
                vehicle.setVehInsurranceNumber(rstat.getString(6));
                vehicle.setVehInsurranceDate(rstat.getDate(7));
                vehicle.setVehInsurranceExpires(rstat.getDate(8));
                vehicle.setVehOrigin(rstat.getString(9).charAt(0));
                
                vehCategory = new VehCategory();
                
                
                this.vehCategoryController.readVehCategory(connection, 
                        vehCategory, rstat.getInt(10));
                vehicle.setVehCategory(vehCategory);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
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
        
        //connection.closeConnection();
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
        
        //connection.closeConnection();
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
        
        //connection.closeConnection();
        return true;
        
    }
    
}
