/**
 * @(#)EmployeeController.java	0.0.1, 22-Jul-2019 
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
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class EmployeeController {
 
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createEmployee(ConnectionJava connection, Employee employee){
        
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
    
    public boolean readEmployee(ConnectionJava connection, Employee employee, 
            int empId){
        
        String query = "SELECT * "
                + "FROM vrs_users"
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
    
    public boolean deleteEmployee(ConnectionJava connection, int empId){
        
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
    
    public boolean getEmployees(ConnectionJava connection, 
            List<Employee> employees){
        
        Employee employee;
        String query = "";
        
        
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
