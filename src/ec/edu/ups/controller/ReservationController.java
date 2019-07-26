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
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createReservation(ConnectionJava connection, 
            Reservation reservation){
        
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
    
    public boolean readReservation(ConnectionJava connection, 
            Reservation reservation, Customer customer, Vehicle vehicle){
        
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                
                
                reservation.setResCustomer(customer);
                reservation.setResVehicle(vehicle);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean updateReservation(ConnectionJava connection, 
            Reservation reservation){
        
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
    
    public boolean deleteReservation(ConnectionJava connection, int resId){
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
        
        //connection.closeConnection();
        return true;
        
    }
    
}
