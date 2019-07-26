/**
 * @(#)PhoneController.java	0.0.5, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Phone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since   22-Jul-2019
 * @version 0.0.5
 * @author  Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class PhoneController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createUserPhone(ConnectionJava connection, Phone phone, 
            int useID){
        String query = "INSERT INTO VRS.VRS_PHONES(\n"
                + "pho_id_seq.NEXTVAL, ?, ?, ?, null)";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, phone.getPhoNumber());
            pstat.setString(2, phone.getPhoType());
            pstat.setInt(3, useID);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean createOfficePhone(ConnectionJava connection, Phone phone, 
            int offID){
        String query = "INSERT INTO VRS.VRS_PHONES(\n"
                + "pho_id_seq.NEXTVAL, ?, ?, null, ?)";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, phone.getPhoNumber());
            pstat.setString(2, phone.getPhoType());
            pstat.setInt(3, offID);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean readPhone(ConnectionJava connection, Phone phone, int phoId){
        String query = "SELECT * "
                + "FROM VRS.VRS_PHONES "
                + "WHERE pho_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, phoId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                phone.setPhoId(rstat.getInt(1));
                phone.setPhoNumber(rstat.getString(2));
                phone.setPhoType(rstat.getString(3));
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean updatePhone(ConnectionJava connection, Phone phone){
        String query = "UPDATE VRS.VRS_PHONES SET "
                + "pho_number = ? "
                + "pho_type = ? "
                + "WHERE pho_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, phone.getPhoNumber());
            pstat.setString(2, phone.getPhoType());
            pstat.setInt(3, phone.getPhoId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean deletePhone(ConnectionJava connection, int phoId){
        String query = "DELETE VRS.VRS_PHONES "
                + "WHERE pho_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, phoId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean getUserPhones(ConnectionJava connection, List<Phone> phones,
            int useId){
        
        Phone phone;
        String query = "SELECT * "
                + "FROM VRS.VRS_PHONES "
                + "WHERE use_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, useId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                phone = new Phone();
                
                phone.setPhoId(rstat.getInt(1));
                phone.setPhoNumber(rstat.getString(2));
                phone.setPhoType(rstat.getString(3));
                
                phones.add(phone);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean getOfficePhones(ConnectionJava connection, List<Phone> phones,
            int offID){
        
        Phone phone;
        String query = "SELECT * "
                + "FROM VRS.VRS_PHONES "
                + "WHERE off_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, offID);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                phone = new Phone();
                
                phone.setPhoId(rstat.getInt(1));
                phone.setPhoNumber(rstat.getString(2));
                phone.setPhoType(rstat.getString(3));
                
                phones.add(phone);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
}
