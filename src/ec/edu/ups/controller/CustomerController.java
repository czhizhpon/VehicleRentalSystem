/**
 * @(#)CustomerController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Customer;
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
public class CustomerController {
    
    private PrivilegeController conPrivilge;
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createCustomer(ConnectionJava connection, Customer customer){
        
        /*sequence, username, password, dni, name, lastname, email, birthDay, 
        address, work_addres, type*/
        String query = "INSERT INTO VRS_USERS VALUES(\n" +
        "use_id_seq.NEXTVAL, 'karens', 'ba952731f97fb058035aa399b1cb3d5c', '0102040145',\n" +
        "'Karen', 'Lopez', 'karn@mail.com', TO_DATE('1993-01-22', 'YYYY-MM-DD'),\n" +
        "'Tadeo Torres, L. Cordero', 'Av. Hurtado de Mendoza, Illimani',\n" +
        "'C', 1, 2\n" +
        ");";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readDniCustomer(ConnectionJava connection, Customer customer, 
            String cusDni){
        
        String query = "SELECT *"
                + "FROM vrs_users u, vrs_privileges p"
                + "WHERE u.use_dni LIKE ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, cusDni);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                customer.setUseId(rstat.getInt(1));
                customer.setUseUsername(rstat.getString(2));
                customer.setUsePassword(rstat.getString(3));
                customer.setUseDNI(rstat.getString(4));
                customer.setUseName(rstat.getString(5));
                customer.setUseLastNamel(rstat.getString(6));
                customer.setUseEmail(rstat.getString(7));
                customer.setUseBirthDay(rstat.getDate(8));
                customer.setUseAddress(rstat.getString(9));
                customer.setUseWorkAdd(rstat.getString(10));
                customer.setUseType(rstat.getString(11).charAt(0));
                
                Privilege privilege = new Privilege();
                this.conPrivilge.readPrivilege(connection, privilege, 
                        rstat.getInt(12));
                customer.setUsePrivilege(privilege);
                
                /*Telefonos*/
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readUserCustomer(ConnectionJava connection, Customer customer, 
            String username){
        String query = "SELECT *"
                + "FROM vrs_users"
                + "WHERE use_username LIKE ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, username);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                ;
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateCustomer(ConnectionJava connection, Customer customer){
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
    
    public boolean deleteCustomer(ConnectionJava connection, Customer customer){
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
    
    public boolean getCustomers(ConnectionJava connection, List<Customer> customers){
        
        Customer customer;
        String query = "SELECT";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                customer = new Customer();
                
                
                
                customers.add(customer);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
