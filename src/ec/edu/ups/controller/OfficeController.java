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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public CityController getOffCity() {
        return offCity;
    }

    public void setOffCity(CityController offCity) {
        this.offCity = offCity;
    }

    public ProvinceController getOffProvince() {
        return offProvince;
    }

    public void setOffProvince(ProvinceController offProvince) {
        this.offProvince = offProvince;
    }

    public PhoneController getOffPhone() {
        return offPhone;
    }

    public void setOffPhone(PhoneController offPhone) {
        this.offPhone = offPhone;
    }
    
    public boolean createOffice(ConnectionJava connection, Office office){
        
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
            pstat.setInt(5, office.getOffCity().getCitId());
            
            pstat.executeUpdate();
            
            for(Phone p:office.getOffPhones()){
                this.offPhone.createOfficePhone(connection, p, office.getOffId());
            }
            
            
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
       // connection.closeConnection();
       return true;
    }
    
    public boolean readOffice(ConnectionJava connection, Office office, 
            int offId){
        
        List<Phone> phones = new ArrayList<>();
        City city;
        
        String query = "SELECT * "
                + "FROM vrs.vrs_offices "
                + "WHERE off_id = ? ";
        
        try {
            
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, offId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                city = new City();
                
                office.setOffId(rstat.getInt(1));
                office.setOffMainSt(rstat.getString(2));
                office.setOffSideSt(rstat.getString(3));
                office.setOffNumber(rstat.getString(4));
                office.setOffCodPostal(rstat.getString(5));
                
                this.offCity.readCity(connection, city, rstat.getInt(6));
                
                office.setOffCity(city);
                
                this.offPhone.getOfficePhones(connection, phones, office.getOffId());
                office.setOffPhones(phones);
                
            }
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
    }
    
    public boolean updateOffice(ConnectionJava connection, Office office){
        String query = "UPDATE vrs.vrs_offices SET "
                + "off_main_st = ? "
                + "off_side_st = ? "
                + "off_number = ? "
                + "off_cod_postal = ? "
                + "cit_id = ? "
                + "WHERE off_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, office.getOffMainSt());
            pstat.setString(2, office.getOffSideSt());
            pstat.setString(3, office.getOffNumber());
            pstat.setString(4, office.getOffCodPostal());
            pstat.setInt(5, office.getOffCity().getCitId());
            pstat.setInt(6, office.getOffId());
            
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
    }
    
    public boolean deleteOffice(ConnectionJava connection, int offId){
        String query = "DELETE vrs.vrs_offices "
                + "WHERE off_id = ? ";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, offId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
    }
    
    public boolean getOffices(ConnectionJava connection, List<Office> offices, 
            City city){
        Office office;
        List<Phone> phones = new ArrayList<>();
        String query = "SELECT * "
                + "FROM vrs.vrs_offices "
                + "WHERE cit_id = ?";
        
        try {
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, city.getCitId());
            
            rstat = pstat.executeQuery();
            
            while (rstat.next()) { 
                
                office = new Office();
                
                office.setOffId(rstat.getInt(1));
                office.setOffMainSt(rstat.getString(2));
                office.setOffSideSt(rstat.getString(3));
                office.setOffNumber(rstat.getString(4));
                office.setOffCodPostal(rstat.getString(5));
                
                this.offCity.readCity(connection, city, rstat.getInt(6));
                
                office.setOffCity(city);
                
                this.offPhone.getOfficePhones(connection, phones, office.getOffId());
                office.setOffPhones(phones);
                offices.add(office);
            }
        } catch (SQLException ex) {
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
        
    }
    
    @Override
    public String toString() {
        return "OfficeController{" + "conOffices=" + /*conOffice*/ + '}';
    }

    
    
}
