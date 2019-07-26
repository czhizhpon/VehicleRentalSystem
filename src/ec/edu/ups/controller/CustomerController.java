/**
 * @(#)CustomerController.java	0.0.5, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Customer;
import ec.edu.ups.model.Phone;
import ec.edu.ups.model.Privilege;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @since   22-Jul-2019
 * @version 0.0.5
 * @author  Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class CustomerController {
    
    private PrivilegeController conPrivilge;
    private PhoneController conPhone;
    
    private PreparedStatement pstat;
    private ResultSet rstat;

    public CustomerController() {
        conPrivilge = new PrivilegeController();
        conPhone = new PhoneController();
    }
    
    public boolean createCustomer(ConnectionJava connection, Customer customer){
        
        
        String query = "SELECT use_id_seq.NEXTVAL"
                + "FROM dual";
        
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            int cusId = rstat.getInt(1);
            
            /*sequence, username, password, dni, name, lastname, email, birthDay, 
            address, work_addres, type*/
            query = "INSERT INTO VRS.VRS_USERS VALUES(\n"
                    + "use_id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, customer.getUseUsername());
            pstat.setString(2, customer.getUsePassword());
            pstat.setString(3, customer.getUseDNI());
            pstat.setString(4, customer.getUseName());
            pstat.setString(5, customer.getUseLastNamel());
            pstat.setString(6, customer.getUseEmail());
            pstat.setDate(7, new java.sql.Date(customer.getUseBirthDay().getTime()));
            pstat.setString(8, customer.getUseAddress());
            pstat.setString(8, customer.getUseWorkAdd());
            pstat.setString(9, ""+customer.getUseType());
            pstat.setInt(10, customer.getUsePrivilege().getPriId());
            
            pstat.executeUpdate();
            
            
            for(Phone p:customer.getUsePhones()){
                this.conPhone.createUserPhone(connection, p, cusId);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean readDniCustomer(ConnectionJava connection, Customer customer, 
            String cusDni){
        
        /*
        Privilege privilege;
        List<Phone> phones;
        */
        
        String query = "SELECT * "
                + "FROM VRS.VRS_USER u, VRS.VRS_PRIVILEGES p "
                + "WHERE u.use_dni LIKE ?";
        
        readCustomer(connection, customer, query, cusDni);
        
        /*
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
                
                privilege = new Privilege();
                this.conPrivilge.readPrivilege(connection, privilege, 
                        rstat.getInt(12));
                
                customer.setUsePrivilege(privilege);
        
                phones = new ArrayList<>();
                this.conPhone.getUserPhones(connection, phones, 
                        customer.getUseId());
                
                customer.setUsePhones(phones);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        */
        
        return true;
    }
    
    public boolean readUserCustomer(ConnectionJava connection, Customer customer, 
            String username){
        
        String query = "SELECT *"
                + "FROM vrs_users"
                + "WHERE use_username LIKE ?";
        
        readCustomer(connection, customer, query, username);
        
        /*
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
        */
        return true;
    }
    
    public boolean readCustomer(ConnectionJava connection, Customer customer, 
            String query, String identifier){
        
        Privilege privilege;
        List<Phone> phones;
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, identifier);
            
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
                
                privilege = new Privilege();
                this.conPrivilge.readPrivilege(connection, privilege, 
                        rstat.getInt(12));
                
                customer.setUsePrivilege(privilege);
                
                /*Telefonos*/
                phones = new ArrayList<>();
                this.conPhone.getUserPhones(connection, phones, 
                        customer.getUseId());
                
                customer.setUsePhones(phones);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean readCustomer(ConnectionJava connection, Customer customer, 
            int cusId){
        
        Privilege privilege;
        List<Phone> phones;
        
        String query = "SELECT * "
                + "FROM vrs.vrs_users "
                + "WHERE use_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, cusId);
            
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
                
                privilege = new Privilege();
                this.conPrivilge.readPrivilege(connection, privilege, 
                        rstat.getInt(12));
                
                customer.setUsePrivilege(privilege);
                
                /*Telefonos*/
                phones = new ArrayList<>();
                this.conPhone.getUserPhones(connection, phones, 
                        customer.getUseId());
                
                customer.setUsePhones(phones);
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        
        return true;
    }
    
    public boolean updateCustomer(ConnectionJava connection, Customer customer){
        
        String query = "UPDATE VRS.VRS_USERS SET "
                + "use_password = ?, "
                + "use_name = ?, "
                + "use_last_name = ?, "
                + "use_email = ?, "
                + "use_birth_day = ?, "
                + "use_address = ?, "
                + "use_work_add = ?, "
                + "pri_id = ? "
                + "WHERE use_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, customer.getUsePassword());
            pstat.setString(2, customer.getUseName());
            pstat.setString(3, customer.getUseLastNamel());
            pstat.setString(4, customer.getUseEmail());
            pstat.setDate(5, new java.sql.Date(customer.getUseBirthDay().getTime()));
            pstat.setString(6, customer.getUseAddress());
            pstat.setString(7, customer.getUseWorkAdd());
            pstat.setInt(8, customer.getUsePrivilege().getPriId());
            pstat.setInt(9, customer.getUseId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean deleteCustomer(ConnectionJava connection, Customer customer, 
            int cusID){
        
        String query = "DELETE VRS.VRS_USERS "
                + "WHERE use_id = ? ";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, cusID);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
    }
    
    
    // OJO
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
        //connection.closeConnection();
        return true;
        
    }
    
}
