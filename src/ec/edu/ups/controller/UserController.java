/**
 * @(#)UserController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Employee;
import ec.edu.ups.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class UserController {
    
    private CustomerController conCus;
    private EmployeeController conEmp;
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createUser(ConnectionJava connection, User user){
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
    
    public boolean readUser(ConnectionJava connection, User user, String username){
        String query = "SELECT  * "
                + "FROM vrs.vrs_users "
                + "WHERE use_username LIKE ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, username);
            
            rstat = pstat.executeQuery();
            
            
            while(rstat.next()){
                user.setUseId(rstat.getInt(1));
                user.setUseUsername(rstat.getString(2));
                user.setUsePassword(rstat.getString(3));
                user.setUseDNI(rstat.getString(4));
                user.setUseName(rstat.getString(5));
                user.setUseLastNamel(rstat.getString(6));
                user.setUseEmail(rstat.getString(7));
                user.setUseBirthDay(rstat.getDate(8));
                user.setUseAddress(rstat.getString(9));

                user.setUseType(rstat.getString(11).charAt(0));
                
//                switch(rstat.getString(11)){
//                    case "A":
//                        break;
//                    case "E":
//                        break;
//                    case "C":
//                        break;
//                }
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        
        return true;
    }
    
    public boolean readEmployee(ConnectionJava connection, Employee employee, 
            int useId){
        
        try{
            this.conEmp.readEmployee(connection, employee, useId);
        }catch(NullPointerException e){
            
        }
        return true;
    }
    
    public boolean update(ConnectionJava connection){
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
    
    public boolean delete(ConnectionJava connection, String useDni){
        String query = "UPDATE vrs.vrs_users SET "
                + "use_status = 'I' "
                + "WHERE use_username LIKE ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, useDni);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.toString());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean getUsers(ConnectionJava connection, List<User> users){
        
        User user;
        String query = "";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                user = new User();
                
                
                
                users.add(user);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
