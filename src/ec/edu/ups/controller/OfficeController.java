/**
 * @(#)OfficeController.java	0.0.1, 12-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.City;
import ec.edu.ups.model.Office;
import ec.edu.ups.model.Phone;
import ec.edu.ups.model.Province;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

/**
 * @since 12-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class OfficeController {
    
    private CityController offCity;
    private ProvinceController offProvince;
    private PhoneController offPhone;
    
    private PreparedStatement pstat;
    private ResultSet rstat;

    public OfficeController() {
        offCity = new CityController();
        offProvince = new ProvinceController();
        offPhone = new PhoneController();
    }
    
    public void createOffice(ConnectionJava connection, int citId, Office office){
        
        String query = "INSERT INTO vrs_offices VALUES("
                + "secuencia,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?"
                + ");";
        try {
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, office.getOffMainSt());
            pstat.setString(2, office.getOffSideSt());
            pstat.setString(3, office.getOffNumber());
            pstat.setString(4, office.getOffCodPostal());
            pstat.setInt(5, citId);
            
            pstat.executeUpdate();
            
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
    }
    
    public boolean readOffice(ConnectionJava connection, Office office, 
            Province province, City city){
        
        List<Phone> phones;
        
        String query = "SELECT o.off_id, \n" 
                    + "o.off_main_st, o.off_side_st, o.off_number, o.off_cod_postal\n" 
                    + "FROM vrs_cities c, vrs_offices o \n" 
                    + "WHERE c.cit_id = ?\n"
                    + "AND o.off_id = ? ;";
        
        try {
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, city.getCitId());
            pstat.setInt(2, office.getOffId());
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
//                Province province = new Province(rstat.getInt(1), rstat.getString(2));
//                City city = new City(rstat.getInt(3), rstat.getString(4));
//                office = new Office(rstat.getInt(5), rstat.getString(6), 
//                rstat.getString(7), rstat.getString(8), rstat.getString(9));
                
                phones = new ArrayList<>();
                
                office.setOffId(rstat.getInt(1));
                office.setOffMainSt(rstat.getString(2));
                office.setOffSideSt(rstat.getString(3));
                office.setOffNumber(rstat.getString(4));
                office.setOffCodPostal(rstat.getString(5));
                
                city.setCitProvince(province);
                office.setOffCity(city);
                office.setOffPhones(phones);
                
            }
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean updateOffice(ConnectionJava connection, Office office){
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
    
    public boolean deleteOffice(ConnectionJava connection, int offId){
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
    
    public boolean getOffices(ConnectionJava connection, List<Office> offices, 
            int citId){
        
        String query = "SELECT o.off_id, o.off_main_st, o.off_side_st, "
                + "o.off_number, o.off_cod_postal\n" 
                +"FROM vrs_offices o\n" 
                + "WHERE o.cit_id = ?;";
        
        try {
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, citId);
            
            rstat = pstat.executeQuery();
            
            while (rstat.next()) { 
                
                Office office = new Office(rstat.getInt(1), rstat.getString(2), 
                        rstat.getString(3), rstat.getString(4), rstat.getString(5));
                
                offices.add(office);
            }
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
    @Override
    public String toString() {
        return "OfficeController{" + "conOffices=" + /*conOffice*/ + '}';
    }

    
    
}
