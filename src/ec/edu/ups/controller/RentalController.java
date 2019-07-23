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
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createRental(ConnectionJava connection, Rental rental, 
            int vehId, int cusId, int resId){
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
    
    public boolean readRental(ConnectionJava connection, Rental rental, Vehicle 
            vehicle, Customer customer, Reservation reservation){
        
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                rental.setRenCustomer(customer);
                rental.setRenVehicle(vehicle);
                rental.setRenReservation(reservation);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
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
        connection.closeConnection();
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
        connection.closeConnection();
        return true;
    }
    
    public boolean getCustomerRentals(ConnectionJava connection, 
            List<Rental> rentals, Customer customer){
        
        Rental rental;
        Vehicle vehicle;
        Reservation reservation;
        String query = "";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                rental = new Rental();
                vehicle = new Vehicle();
                reservation = new Reservation();
                
                
                
                rental.setRenCustomer(customer);
                rental.setRenVehicle(vehicle);
                rental.setRenReservation(reservation);
                rentals.add(rental);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
}
