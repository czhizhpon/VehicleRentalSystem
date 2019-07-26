/**
 * @(#)VehicleController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Model;
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
    
    private ModelController conModel;
    private VehCategoryController vehCategoryController;
    private OfficeController conOffice;
    
    private PreparedStatement pstat;
    private ResultSet rstat;

    public VehicleController() {
        conOffice = new OfficeController();
        conModel = new ModelController();
        vehCategoryController = new VehCategoryController();
    }

    public OfficeController getConOffice() {
        return conOffice;
    }

    public void setConOffice(OfficeController conOffice) {
        this.conOffice = conOffice;
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
    
    public boolean createVehicle(ConnectionJava connection, Vehicle vehicle,
            int offId, int modId, int catId, int proId){
        
        String query = "INSERT INTO VRS.VRS_VEHICLES VALUES(\n"
                + "veh_id_seq.NEXTVAL, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, vehicle.getVehPlate());
            pstat.setString(2, vehicle.getVehColor());
            pstat.setString(3, "" + vehicle.getVehStatus());
            pstat.setDouble(4, vehicle.getVehKilometraje());
            pstat.setString(5, vehicle.getVehInsurranceNumber());
            pstat.setDate(6, new java.sql.Date(vehicle.getVehInsurranceDate().
                    getTime()));
            pstat.setDate(7, new java.sql.Date(vehicle.getVehInsurranceExpires().
                    getTime()));
            pstat.setString(8, "" + vehicle.getVehOrigin());
            pstat.setInt(9, offId);
            pstat.setInt(10, modId);
            pstat.setInt(11, catId);
            pstat.setInt(12, proId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean readVehicle(ConnectionJava connection, Vehicle vehicle, 
            int vehId){
        
        VehCategory vehCategory;
        Model model;
        
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
                
                model = new Model();
                
                this.conModel.readModel(connection, model, rstat.getInt(11));
                
                vehCategory = new VehCategory();
                
                
                this.vehCategoryController.readVehCategory(connection, 
                        vehCategory, rstat.getInt(12));
                
                vehicle.setVehCategory(vehCategory);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean updateVehicle(ConnectionJava connection, 
            Vehicle vehicle, int offId){
        
        String query = "UPDATE vrs.vrs_vehicles SET "
                + "veh_color = ? "
                + "veh_status = ? "
                + "veh_kilometrage = ? "
                + "veh_insurance_number = ? "
                + "veh_insurance_date = ? "
                + "veh_insurance_expires = ? "
                + "veh_origen = ? "
                + "off_id = ? "
                + "mod_id = ? "
                + "cat_id = ? "
                + "WHERE veh_id = ?";
        
        try{
            //pstat = connection.getConnection().prepareStatement(query);
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, vehicle.getVehColor());
            pstat.setString(2, "" + vehicle.getVehStatus());
            pstat.setDouble(3, vehicle.getVehKilometraje());
            pstat.setString(4, vehicle.getVehInsurranceNumber());
            pstat.setDate(5, new java.sql.Date(vehicle.getVehInsurranceDate().
                    getTime()));
            pstat.setDate(6, new java.sql.Date(vehicle.getVehInsurranceExpires().
                    getTime()));
            pstat.setString(7, "" + vehicle.getVehOrigin());
            pstat.setInt(8, offId);
            pstat.setInt(9, vehicle.getVehModel().getModId());
            pstat.setInt(10, vehicle.getVehCategory().getCatId());
            
            pstat.setInt(11, vehicle.getVehId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean deleteVehicle(ConnectionJava connection, String vehPlate){
        
        String query = "DELETE vrs.vrs_models "
                + "WHERE veh_plate = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, vehPlate);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean getVehicles(ConnectionJava connection, 
            List<Vehicle> vehicles, Model model){
        
        Vehicle vehicle;
        VehCategory vehCategory;
        String query = "SELECT * "
                + "FROM vrs.vrs_vehicles "
                + "WHERE mod_id = ?";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, model.getModId());
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                vehicle = new Vehicle();
                vehCategory = new VehCategory();
                
                vehicle.setVehId(rstat.getInt(1));
                vehicle.setVehPlate(rstat.getString(2));
                vehicle.setVehColor(rstat.getString(3));
                vehicle.setVehStatus(rstat.getString(4).charAt(0));
                vehicle.setVehKilometraje(rstat.getDouble(5));
                vehicle.setVehInsurranceNumber(rstat.getString(6));
                vehicle.setVehInsurranceDate(rstat.getDate(7));
                vehicle.setVehInsurranceExpires(rstat.getDate(8));
                vehicle.setVehOrigin(rstat.getString(9).charAt(0));
                
                vehicle.setVehModel(model);
                
                this.vehCategoryController.readVehCategory(connection, 
                        vehCategory, rstat.getInt(12));
                
                vehicle.setVehCategory(vehCategory);
                
                vehicles.add(vehicle);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        
        //connection.closeConnection();
        return true;
        
    }
    
}
