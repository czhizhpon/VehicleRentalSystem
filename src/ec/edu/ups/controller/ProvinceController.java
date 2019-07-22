/**
 * @(#)ProvinceController.java	0.0.1, 19-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */

package ec.edu.ups.controller;

import ec.edu.ups.model.Province;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

/**
 * @since 19-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class ProvinceController {
    
    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rstat;
    private Statement stat;
    
    public List<Province> getProvinces(){
        List<Province> provinces =  new ArrayList<>();
        conn = new SQLConection().conectarMySQL();
        
        String query = "SELECT *\n" +
                        "FROM vrs_provinces;";
        
        runLoadStatement(query);
        try {
            while(rstat.next()){
                Province province = new Province(rstat.getInt(1), 
                        rstat.getString(2));
                provinces.add(province);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return provinces;
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
