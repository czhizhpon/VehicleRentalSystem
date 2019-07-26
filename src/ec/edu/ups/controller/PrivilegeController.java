/**
 * @(#)PrivilegeController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Privilege;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class PrivilegeController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createPrivilege(ConnectionJava connection, 
            Privilege privilege){
        
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
    
    public boolean readPrivilege(ConnectionJava connection, Privilege privilege, 
            int priId){
        
        String query = "SELECT * "
                + "FROM vrs_privileges"
                + "WHERE pri_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, priId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                privilege.setPriId(rstat.getInt(1));
                privilege.setPriName(rstat.getString(2));
                privilege.setPriDiscountPct(rstat.getInt(3));
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean updatePrivilege(ConnectionJava connection, Privilege privilege){
        
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
    
    public boolean deletePrivilege(ConnectionJava connection, int priId){
        
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
    
    public boolean getPrivileges(ConnectionJava connection, 
            List<Privilege> privileges){
        
        Privilege privilege;
        String query = "";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                privilege = new Privilege();
                
                
                
                privileges.add(privilege);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
        
    }
}
