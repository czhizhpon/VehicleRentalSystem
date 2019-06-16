/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author edd
 */
public class RentalUI extends JFrame{
    
    
    
    public RentalUI(){
        initComponents();
    }
    
    public final void initComponents(){
        setTitle("Rental");
        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    public JPanel loadVehicle(){
        JPanel vehPanel = new JPanel(new GridBagLayout());
        
        
        
        return vehPanel;
    }
}
