/**
 * @(#)BillController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.BillDetail;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class BillController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createBillHead(ConnectionJava connection, BillHead billHead){
        try{
            /*Get sequence value*/
            int heaId;

            String query = "SELECT hea_id_seq.NEXTVAL \n"
                    + "FROM dual;";
            pstat = connection.getConnection().prepareStatement(query);
            rstat = pstat.executeQuery();
            
            heaId = rstat.getInt(1);
            
            /*sequence, subtotal, discount, vat, total, Date, status, customer*/
            query = "INSERT INTO vrs_bill_heads VALUES(\n" 
                    + "?, ?, ?, ?, ?,\n" 
                    + "?, ?, ?);";
        
        
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, heaId);
            pstat.setDouble(2, billHead.getHeaSubtotal());
            pstat.setDouble(3, billHead.getHeaVat());
            pstat.setDouble(4, billHead.getHeaDisc());
            pstat.setDouble(5, billHead.getHeaTotal());
            
            java.sql.Date sqlDate = new java.sql.Date(billHead.getHeaDate().getTime());
            pstat.setDate(6, sqlDate);
            pstat.setString(7, "" + billHead.getHeaStatus());
            pstat.setInt(8, billHead.getCustomer().getUseId());
            
            pstat.executeUpdate();
            
            
            /*sequence, duration, day_cost, extra_damage, extra_delay, subtotal, 
            head, vehicle*/
            query = "INSERT INTO vrs_bill_details VALUES(\n" 
                    + "det_id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?);";
            
            pstat = connection.getConnection().prepareStatement(query);
            
            for(BillDetail detail: billHead.getHeaDetails()){
                pstat.setInt(1, detail.getDetDuration());
                pstat.setDouble(2, detail.getDetDayCost());
                pstat.setDouble(3, detail.getDetExtraDamage());
                pstat.setDouble(4, detail.getDetExtraDelay());
                pstat.setDouble(5, detail.getDetSubtotal());
                pstat.setInt(6, heaId);
                pstat.setInt(7, detail.getDetRental().getRenVehicle().getVehId());
                
                pstat.executeUpdate();
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean readBillHead(ConnectionJava connection, BillHead billHead, 
            int bilId){
        
        String query = "";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
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
    
    public boolean updateBillHead(ConnectionJava connection, BillHead billHead){
        
        String query = "UPDATE vrs_bill_heads SET"
                + "hea_subtotal  = ? \n"
                + "hea_vat = ?\n"
                + "hea_disc = ? \n"
                + "hea_total = ? \n"
                + "hea_date = ? \n"
                + "hea_status = ? \n"
                + "WHERE hea_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setDouble(1, billHead.getHeaSubtotal());
            pstat.setDouble(2, billHead.getHeaVat());
            pstat.setDouble(3, billHead.getHeaDisc());
            pstat.setDouble(4, billHead.getHeaTotal());
            pstat.setDate(5, new java.sql.Date(billHead.getHeaDate().getTime()));
            pstat.setInt(6, billHead.getHeaId());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean deleteBillHead(ConnectionJava connection, int bilId){
        String query = "UPDATE vrs_bill_heads SET"
                + "hea_status = ? \n"
                + "WHERE hea_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, "A");
            pstat.setInt(2, bilId);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
    }
    
    public boolean getCustomerBillHeads(ConnectionJava connection, 
            List<BillHead> billHeads, Customer customer){
        
        BillHead billHead;
        String query = "SELECT * \n"
                + "FROM vrs_bill_heads h \n"
                + "WHERE h.use_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, customer.getUseId());
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                
                billHead = new BillHead();
                
                billHead.setHeaId(rstat.getInt(1));
                billHead.setHeaSubtotal(rstat.getDouble(2));
                billHead.setHeaVat(rstat.getDouble(3));
                billHead.setHeaDisc(rstat.getDouble(4));
                billHead.setHeaTotal(rstat.getDouble(5));
                billHead.setHeaDate(rstat.getDate(6));
                billHead.setCustomer(customer);
                
                billHeads.add(billHead);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        connection.closeConnection();
        return true;
        
    }
    
}
