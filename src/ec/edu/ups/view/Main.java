/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import ec.edu.ups.controller.OfficeController;
import ec.edu.ups.model.City;
import ec.edu.ups.model.Province;
import ec.edu.ups.model.Office;
import java.util.Scanner;
import javax.swing.UIManager;

/**
 *
 * @author edd
 */
public class Main {
    
    public static void main(String [] args){
        
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
//        
//        
//        OfficeController o = new OfficeController();
//        
//        Office of = o.loadOffice(1, 1, 2);
//        
//        System.out.println("Calle principal:" + of.getOffMainSt());
//        System.out.println("Calle Secundaria:" + of.getOffSideSt());
//        System.out.println("Postal:" + of.getOffCodPostal());
//        System.out.println("Ciudad:" + of.getOffCity().getCitName());
//        System.out.println("Provincia:" + of.getOffCity().getCitProvince().getProName());
        
    }
    
}
