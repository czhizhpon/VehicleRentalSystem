/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controller;

import ec.edu.ups.model.Province;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edd
 */
public class DataBaseController {
    
    //private SQLConection sql;
    private final Connection conn;
    private PreparedStatement pstat;
    
    public DataBaseController(OfficeController conOff){
        conn = new SQLConection().conectarMySQL();
    }
    
    public void insertProvinces(Province province){
        String query = "INSERT INTO vrs_province VALUES("
                + province.getProId()
                + province.getProName()
                + ");";
        runStatement(query);
    }
    
    public boolean runStatement(String query){
        try {
            pstat = conn.prepareStatement(query);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
}
