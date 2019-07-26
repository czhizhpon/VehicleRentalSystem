/**
 * @(#)RentalController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Customer;
import ec.edu.ups.model.Rental;
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
public class RentalController {
    
    private VehicleController conVehicle;
    private CustomerController conCustomer;
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createRental(ConnectionJava connection, Rental rental){
        
        /*sequence, km ini, km fin, date ini, date fin, res_id, veh_id, use_id*/
        
        try{
            if (rental.getRenReservation() != null ){
                createRentalWithReservation(connection, rental);
            }else{
                createRentalWithoutReservation(connection, rental);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    private boolean createRentalWithReservation(ConnectionJava connection, 
            Rental rental) throws SQLException{
        
        String query = "INSERT INTO vrs_rentals VALUES(\n" 
                + "ren_id_seq.NEXTVAL, ?, ?, ?,\n" 
                + "?, ?, ?, ?\n)";
        
        
        pstat = connection.getConnection().prepareStatement(query);
        
        pstat.setDouble(1, rental.getRenKilometrajeIni());
        pstat.setDouble(2, rental.getRenKilometrajeFin());
        pstat.setDate(3, new java.sql.Date(rental.getRenDateIni().getTime()));
        pstat.setDate(4, new java.sql.Date(rental.getRenDateFin().getTime()));
        pstat.setInt(5, rental.getRenReservation().getResId());
        pstat.setInt(6, rental.getRenVehicle().getVehId());
        pstat.setInt(7, rental.getRenCustomer().getUseId());
        pstat.setDouble(8, rental.getRenWarranty());
        pstat.setString(9, "" + rental.getRenStatus());
        pstat.setInt(10, rental.getRenPayMeth().getPayId());
        
        pstat.executeUpdate();
        
        
        return true;
    }
    
    private boolean createRentalWithoutReservation(ConnectionJava connection, 
            Rental rental) throws SQLException{
        
        String query = "INSERT INTO vrs_rentals VALUES(\n" 
                + "ren_id_seq.NEXTVAL, ?, ?, ?,\n" 
                + "?, null, ?, ?\n)";
        
        
        pstat = connection.getConnection().prepareStatement(query);
        
        pstat.setDouble(1, rental.getRenKilometrajeIni());
        pstat.setDouble(2, rental.getRenKilometrajeFin());
        pstat.setDate(3, new java.sql.Date(rental.getRenDateIni().getTime()));
        pstat.setDate(4, new java.sql.Date(rental.getRenDateFin().getTime()));
        //pstat.setInt(5, rental.getRenReservation().getResId());
        pstat.setInt(6, rental.getRenVehicle().getVehId());
        pstat.setInt(7, rental.getRenCustomer().getUseId());
        pstat.setDouble(8, rental.getRenWarranty());
        pstat.setString(9, "" + rental.getRenStatus());
        pstat.setInt(10, rental.getRenPayMeth().getPayId());
        
        pstat.executeUpdate();
        
        
        return true;
    }
    
    public boolean readRental(ConnectionJava connection, Rental rental, 
            String useDNI){
        
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
//                rental.setRenCustomer(customer);
//                rental.setRenVehicle(vehicle);
//                rental.setRenReservation(reservation);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean updateRental(ConnectionJava connection, Rental rental){
        
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
    
    public boolean deleteRental(ConnectionJava connection, int renId){
        
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
    
    public boolean getCustomerRentals(ConnectionJava connection, 
            List<Rental> rentals, Customer customer){
        
        Rental rental;
        Vehicle vehicle;
        Reservation reservation;
        String query = "SELECT * "
                + "FROM vrs_rentals "
                + "WHERE use_id = ? "
                + "AND ren_status = ? ";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, customer.getUseId());
            pstat.setString(2, "D");
            
            rstat = pstat.executeQuery();
            
            /*res_id, veh_id, use_id*/
            while(rstat.next()){
                
                rental = new Rental();
                vehicle = new Vehicle();
                reservation = new Reservation();
                
                rental.setRenId(rstat.getInt(1));
                rental.setRenKilometrajeIni(rstat.getDouble(2));
                rental.setRenKilometrajeFin(rstat.getDouble(3));
                rental.setRenDateIni(rstat.getDate(4));
                rental.setRenDateFin(rstat.getDate(5));
                rental.setRenWarranty(rstat.getDouble(6));
                
                
                this.conVehicle.readVehicle(connection, vehicle, rstat.getInt(7));
                
                rental.setRenCustomer(customer);
                rental.setRenVehicle(vehicle);
                rental.setRenReservation(reservation);
                rentals.add(rental);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
        
    }
}
