/**
 * @(#)EmployeeController.java	0.0.5, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since   22-Jul-2019
 * @version 0.0.5
 * @author  Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class EmployeeController {
 
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createEmployee(ConnectionJava connection, Employee employee){
        
        String query = "INSERT INTO VRS.VRS_USERS VALUES(\n"
                + "use_id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, null, ?, null)";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, employee.getUseUsername());
            pstat.setString(2, employee.getUsePassword());
            pstat.setString(3, employee.getUseDNI());
            pstat.setString(4, employee.getUseName());
            pstat.setString(5, employee.getUseLastNamel());
            pstat.setString(6, employee.getUseEmail());
            pstat.setDate(7, new java.sql.Date(employee.getUseBirthDay().getTime()));
            pstat.setString(8, employee.getUseAddress());
            pstat.setString(9, ""+employee.getUseType());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        return true;
    }
    
    public boolean readEmployee(ConnectionJava connection, Employee employee, 
            int empId){
        
        String query = "SELECT * "
                + "FROM VRS.VRS_USERS "
                + "WHERE use_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, empId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                employee.setUseId(rstat.getInt(1));
                employee.setUseUsername(rstat.getString(2));
                employee.setUsePassword(rstat.getString(3));
                employee.setUseDNI(rstat.getString(4));
                employee.setUseName(rstat.getString(5));
                employee.setUseLastNamel(rstat.getString(6));
                employee.setUseEmail(rstat.getString(7));
                employee.setUseBirthDay(rstat.getDate(8));
                employee.setUseAddress(rstat.getString(9));
                employee.setUseType(rstat.getString(11).charAt(0));
                
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        return true;
    }
    
    public boolean updateEmployee(ConnectionJava connection, Employee employee){
        
        String query = "UPDATE VRS.VRS_USERS SET "
                + "use_password = ? "
                + "use_name = ? "
                + "use_last_name = ? "
                + "use_email = ? "
                + "use_birth_day = ? "
                + "use_address = ? "
                + "use_type = ? "
                + "WHERE use_id = ?";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, employee.getUsePassword());
            pstat.setString(2, employee.getUseName());
            pstat.setString(3, employee.getUseLastNamel());
            pstat.setString(4, employee.getUseEmail());
            pstat.setDate(5, new java.sql.Date(employee.getUseBirthDay().getTime()));
            pstat.setString(6, employee.getUseAddress());
            pstat.setString(7, ""+employee.getUseType());
            pstat.setInt(8, employee.getUseId());
            
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteEmployee(ConnectionJava connection, int empId){
        
        String query = "DELETE VRS.VRS_USERS "
                + "WHERE use_id = ? ";
        
        try{
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, empId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        connection.closeConnection();
        return true;
    }
    
    //OJO, NARIZ JEJE
    public boolean getEmployees(ConnectionJava connection, 
            List<Employee> employees){
        
        Employee employee;
        String query = "SELECT * "
                + "FROM VRS.VRS_USERS "
                + "WHERE use_type = 'A' "
                + "OR  use_type = 'E' ";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                employee = new Employee();
                
                
                
                employees.add(employee);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
