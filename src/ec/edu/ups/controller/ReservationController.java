/**
 * @(#)ReservationController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Customer;
import ec.edu.ups.model.Reservation;
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
public class ReservationController {
    
    private VehicleController conVehicel;
    private CustomerController conCustomer;
    
    private PreparedStatement pstat;
    private ResultSet rstat;

    public VehicleController getConVehicel() {
        return conVehicel;
    }

    public void setConVehicel(VehicleController conVehicel) {
        this.conVehicel = conVehicel;
    }

    public CustomerController getConCustomer() {
        return conCustomer;
    }

    public void setConCustomer(CustomerController conCustomer) {
        this.conCustomer = conCustomer;
    }
    
    public boolean createReservation(ConnectionJava connection, 
            Reservation reservation){
        
        String query = "INSERT INTO vrs.vrs_reservations VALUES(" 
                + "res_id_seq.NEXTVAL, ?, ?, ?, ?);";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setDate(1, new java.sql.Date(reservation.getResDateIni().
                    getTime()));
            pstat.setInt(2, reservation.getResVehicle().getVehId());
            pstat.setInt(3, reservation.getResCustomer().getUseId());
            pstat.setDate(4, new java.sql.Date(reservation.getResDateFin().
                    getTime()));
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readReservation(ConnectionJava connection, 
            Reservation reservation, String cusDni, String plate){
        
        Customer customer;
        Vehicle vehicle;
        String query = "SELECT r.res_id, r.res_date, r.veh_id, "
                + "r.use_id, r.res_date_fin" 
                + "FROM vrs.vrs_reservations r, vrs.vrs_users u, vrs.vrs_vehicles v" 
                + "WHERE r.res_id NOT IN "
                + "(SELECT res_id " 
                + "FROM vrs.vrs_rentals " 
                + "WHERE res_id IS NOT NULL)"
                + "AND r.use_id = u.use_id"
                + "AND u.use_dni LIKE ?"
                + "AND r.veh_id LIKE ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, cusDni);
            pstat.setString(2, plate);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                reservation.setResId(rstat.getInt(1));
                reservation.setResDateIni(rstat.getDate(2));
                reservation.setResDateFin(rstat.getDate(5));
                
                customer = new Customer();
                vehicle = new Vehicle();
                
                this.conCustomer.readCustomer(connection, customer, rstat.getInt(4));
                this.conVehicel.readVehicle(connection, vehicle, rstat.getInt(3));
                
                reservation.setResCustomer(customer);
                reservation.setResVehicle(vehicle);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateReservation(ConnectionJava connection, 
            Reservation reservation){
        
        String query = "UPDATE vrs.vrs_reservations SET "
                + ""
                + "WHERE res_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteReservation(ConnectionJava connection, int resId){
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
    
    public boolean getCustomerReservations(ConnectionJava connection, 
            List<Reservation> reservations, Customer customer){
        
        Reservation reservation;
        Vehicle vehicle;
        String query = "";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                reservation = new Reservation();
                vehicle = new Vehicle();
                
                
                
                reservation.setResCustomer(customer);
                reservation.setResVehicle(vehicle);
                
                reservations.add(reservation);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
