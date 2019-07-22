/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controller;

import ec.edu.ups.model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edd
 */
public class CityController {
    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rstat;
    private Statement stat;
    
    public List<City> getCities(int proId){
        List<City> cities = new ArrayList<>();
        conn = new SQLConection().conectarMySQL();
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM vrs_cities \n" +
                        "WHERE pro_id = " + proId + ";";
        runLoadStatement(query);
        try {
            while (rstat.next()) {                
                City city = new City(rstat.getInt(1), rstat.getString(2));
                cities.add(city);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return cities;
    }
    
    public City getCity(City city, int proId, int citId){
        conn = new SQLConection().conectarMySQL();
        String query = "SELECT cit_id, cit_name\n" +        
                        "FROM vrs_cities \n" +
                        "WHERE pro_id = " + proId + "\n" +
                        "AND cit_id = " + citId + ";";
        runLoadStatement(query);
        try {
            while (rstat.next()) {                
                city = new City(rstat.getInt(1), rstat.getString(2));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return city;
    }
    
    public boolean runInsertStatement(String query){
        try {
            pstat = conn.prepareStatement(query);
            pstat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);;
        }
        return true;
    }
    
    public void runLoadStatement(String query){
        try {
            stat = conn.createStatement();
            rstat = stat.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
}
