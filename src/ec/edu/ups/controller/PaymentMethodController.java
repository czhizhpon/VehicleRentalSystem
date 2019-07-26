/**
 * @(#)PaymentMethodController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.model.PaymentMethod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class PaymentMethodController {
    
    private PreparedStatement pstat;
    private ResultSet rstat;
    
    public boolean createPaymentMethod(ConnectionJava connection, 
            PaymentMethod payMeth){
        
        String query = "INSERT INTO vrs.vrs_payment_methods VALUES ("
                + "pay_id_seq.NEXTVAL, ?, ?)";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, payMeth.getPayType());
            pstat.setInt(2, payMeth.getPayDiscountPct());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
    }
    
    public boolean readPaymentMethod(ConnectionJava connection, PaymentMethod payMeth, 
            int payId){
        String query = "SELECT * "
                + "FROM vrs.vrs_payment_methods "
                + "WHERE pay_id = ? ";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setInt(1, payId);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                payMeth.setPayId(rstat.getInt(1));
                payMeth.setPayType(rstat.getString(2));
                payMeth.setPayDiscountPct(rstat.getInt(3));
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
    }
    
    public boolean updatePaymentMethod(ConnectionJava connection, PaymentMethod payMeth){
        String query = "UPDATE vrs.vrs_payment_method SET "
                + "pri_name = ? "
                + "pri_discount_pct = ? "
                + "WHERE pay_id = ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, payMeth.getPayType());
            pstat.setInt(2, payMeth.getPayDiscountPct());
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
    }
    
    public boolean deletePaymentMethod(ConnectionJava connection, String payMeth){
        String query = "DELETE vrs.vrs_payment_method "
                + "WHERE pay_id LIKE ?";
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            pstat.setString(1, payMeth);
            
            pstat.executeUpdate();
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        
        //connection.closeConnection();
        return true;
    }
    
    public boolean getPaymentMethods(ConnectionJava connection, List<PaymentMethod>  payMeths){
        
        PaymentMethod payMeth;
        String query = "SELECT * "
                + "FROM vrs_brands ";
        
        
        try{
            pstat = connection.getConnection().prepareStatement(query);
            
            rstat = pstat.executeQuery();
            
            while(rstat.next()){
                payMeth = new PaymentMethod();
                
                payMeth.setPayId(rstat.getInt(1));
                payMeth.setPayType(rstat.getString(2));
                payMeth.setPayDiscountPct(rstat.getInt(3));
                
                payMeths.add(payMeth);
            }
            
        }catch(SQLException ex){
            throw new NullPointerException(ex.getSQLState());
        }
        //connection.closeConnection();
        return true;
        
    }
    
}
