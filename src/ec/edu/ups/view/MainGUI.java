/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.controller.CustomerController;
import ec.edu.ups.controller.EmployeeController;
import ec.edu.ups.controller.UserController;
import ec.edu.ups.model.Customer;
import ec.edu.ups.model.Employee;
import ec.edu.ups.model.User;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author edd
 */
public class MainGUI extends javax.swing.JFrame {

    private ConnectionJava connection;
    private CustomerController conCustomer;
    private EmployeeController conEmployee;
    private UserController conUser;
    
    
    /**
     * Creates new form MainGUI
     * @param user
     * @param connection
     */
    public MainGUI(User user, ConnectionJava connection) {
        initComponents();
        setSize(1100,900);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                connection.closeConnection();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        
        this.user = user;
        this.connection = connection;
        this.conCustomer = new CustomerController();
        this.conEmployee = new EmployeeController();
        this.conUser = new UserController();
        
        loadMenus();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MyDataGUI getMyDataGUI() {
        return myDataGUI;
    }

    public void setMyDataGUI(MyDataGUI myDataGUI) {
        this.myDataGUI = myDataGUI;
    }

    public BillGUI getBillGUI() {
        return billGUI;
    }

    public void setBillGUI(BillGUI billGUI) {
        this.billGUI = billGUI;
    }

    public CompanyGUI getCompanyGUI() {
        return companyGUI;
    }

    public void setCompanyGUI(CompanyGUI companyGUI) {
        this.companyGUI = companyGUI;
    }

    public MyBillGUI getMyBillGUI() {
        return myBillGUI;
    }

    public void setMyBillGUI(MyBillGUI myBillGUI) {
        this.myBillGUI = myBillGUI;
    }

    public OfficeManagementGUI getOfficeManagementGUI() {
        return officeManagementGUI;
    }

    public void setOfficeManagementGUI(OfficeManagementGUI officeManagementGUI) {
        this.officeManagementGUI = officeManagementGUI;
    }

    public RentalGUI getRentalGUI() {
        return rentalGUI;
    }

    public void setRentalGUI(RentalGUI rentalGUI) {
        this.rentalGUI = rentalGUI;
    }

    public ReservateGUI getReservateGUI() {
        return reservateGUI;
    }

    public void setReservateGUI(ReservateGUI reservateGUI) {
        this.reservateGUI = reservateGUI;
    }

    public UserManagementGUI getUserManagementGUI() {
        return userManagementGUI;
    }

    public void setUserManagementGUI(UserManagementGUI userManagementGUI) {
        this.userManagementGUI = userManagementGUI;
    }

    public VehicleManagementGUI getVehicleManagementGUI() {
        return vehicleManagementGUI;
    }

    public void setVehicleManagementGUI(VehicleManagementGUI vehicleManagementGUI) {
        this.vehicleManagementGUI = vehicleManagementGUI;
    }

    
    public JMenu getHelpJM() {
        return helpJM;
    }

    public void setHelpJM(JMenu helpJM) {
        this.helpJM = helpJM;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopMain = new javax.swing.JDesktopPane();
        mainBar = new javax.swing.JMenuBar();
        myDataJm = new javax.swing.JMenu();
        myDataJMI = new javax.swing.JMenuItem();
        logoutJMI = new javax.swing.JMenuItem();
        addJM = new javax.swing.JMenu();
        addOfficeJMI = new javax.swing.JMenuItem();
        addVehicleJMI = new javax.swing.JMenuItem();
        addCompanyJMI = new javax.swing.JMenuItem();
        createJM = new javax.swing.JMenu();
        creUserJMI = new javax.swing.JMenuItem();
        creVehicleJMI = new javax.swing.JMenuItem();
        creRentalJMI = new javax.swing.JMenuItem();
        creBillJMI = new javax.swing.JMenuItem();
        billJM = new javax.swing.JMenu();
        myBillsJMI = new javax.swing.JMenuItem();
        reservateJM = new javax.swing.JMenu();
        reservationJMI = new javax.swing.JMenuItem();
        helpJM = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alquiler de Vehículos");
        getContentPane().add(desktopMain, java.awt.BorderLayout.CENTER);

        myDataJm.setText("Mi Perfil");
        myDataJm.setName(""); // NOI18N

        myDataJMI.setText("Mis Datos");
        myDataJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myDataJMIActionPerformed(evt);
            }
        });
        myDataJm.add(myDataJMI);

        logoutJMI.setText("Cerrar Sesión");
        logoutJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJMIActionPerformed(evt);
            }
        });
        myDataJm.add(logoutJMI);

        mainBar.add(myDataJm);

        addJM.setText("Agregar");

        addOfficeJMI.setText("Gestionar Oficina");
        addOfficeJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOfficeJMIActionPerformed(evt);
            }
        });
        addJM.add(addOfficeJMI);

        addVehicleJMI.setText("Gestionar Vehículos");
        addVehicleJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVehicleJMIActionPerformed(evt);
            }
        });
        addJM.add(addVehicleJMI);

        addCompanyJMI.setText("Empresa");
        addCompanyJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompanyJMIActionPerformed(evt);
            }
        });
        addJM.add(addCompanyJMI);

        mainBar.add(addJM);

        createJM.setText("Crear");

        creUserJMI.setText("Usuario");
        creUserJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creUserJMIActionPerformed(evt);
            }
        });
        createJM.add(creUserJMI);

        creVehicleJMI.setText("Vehículo");
        creVehicleJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creVehicleJMIActionPerformed(evt);
            }
        });
        createJM.add(creVehicleJMI);

        creRentalJMI.setText("Alquiler");
        creRentalJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creRentalJMIActionPerformed(evt);
            }
        });
        createJM.add(creRentalJMI);

        creBillJMI.setText("Factura");
        creBillJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creBillJMIActionPerformed(evt);
            }
        });
        createJM.add(creBillJMI);

        mainBar.add(createJM);

        billJM.setText("Facturas");
        billJM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billJMActionPerformed(evt);
            }
        });

        myBillsJMI.setText("Mis Facturas");
        myBillsJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myBillsJMIActionPerformed(evt);
            }
        });
        billJM.add(myBillsJMI);

        mainBar.add(billJM);

        reservateJM.setText("Reservaciones");
        reservateJM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservateJMActionPerformed(evt);
            }
        });

        reservationJMI.setText("Reservar");
        reservationJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationJMIActionPerformed(evt);
            }
        });
        reservateJM.add(reservationJMI);

        mainBar.add(reservateJM);

        helpJM.setText("Ayuda");
        mainBar.add(helpJM);

        setJMenuBar(mainBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creUserJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creUserJMIActionPerformed
        try{
            if ( userManagementGUI == null) 
                userManagementGUI = new UserManagementGUI();
            if (userManagementGUI.isVisible()){
                userManagementGUI.setSelected(true);
            }else{
                this.desktopMain.add(userManagementGUI);
                userManagementGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_creUserJMIActionPerformed

    private void addOfficeJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOfficeJMIActionPerformed
        
        try{
            if (officeManagementGUI== null) 
                officeManagementGUI = new OfficeManagementGUI(this.connection, this);
            if (officeManagementGUI.isVisible()){
                officeManagementGUI.setSelected(true);
            }else{
                this.desktopMain.add(officeManagementGUI);
                officeManagementGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
        
    }//GEN-LAST:event_addOfficeJMIActionPerformed

    private void myDataJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myDataJMIActionPerformed
        // TODO add your handling code here:
        try {
            if (myDataGUI == null){
                
                if (this.user.getUseType()== 'A' || this.user.getUseType()== 'E') {
                    
                    Employee employee = new Employee();
                    
                    this.conEmployee.readEmployee(connection, employee, 
                            this.user.getUseId());
                    
                    myDataGUI = new MyDataGUI(connection, getWidth(), getHeight(), employee);
                    
                } else {
                    //this.user.getUseType() == 'C';
                    
                    Customer customer = new Customer();
                    
                    this.conCustomer.readCustomer(connection, customer, 
                            this.user.getUseId());
                    
                    myDataGUI = new MyDataGUI(connection, getWidth(), getHeight(), customer);
                }
            }
            
            if (myDataGUI.isVisible()){

                    myDataGUI.setSelected(true);

            }else{
                this.desktopMain.add(myDataGUI);
                myDataGUI.setVisible(true);
            }
        } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_myDataJMIActionPerformed
    /**
     * This method returns back to login and saves all the changes.
     * @param evt 
     */
    private void logoutJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJMIActionPerformed
        
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_logoutJMIActionPerformed

    private void addVehicleJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVehicleJMIActionPerformed
        
        try{
            if (vehicleManagementGUI == null)
                vehicleManagementGUI = new VehicleManagementGUI(this.connection, this);
            if (vehicleManagementGUI.isVisible()){
                vehicleManagementGUI.setSelected(true);
            }else{
                this.desktopMain.add(vehicleManagementGUI);
                vehicleManagementGUI.setVisible(true);
            }
            
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_addVehicleJMIActionPerformed

    private void addCompanyJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompanyJMIActionPerformed
        try{
            if (companyGUI == null) 
                companyGUI = new CompanyGUI();
            if (companyGUI.isVisible()){
                companyGUI.setSelected(true);
            }else{
                this.desktopMain.add(companyGUI);
                companyGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_addCompanyJMIActionPerformed

    private void creVehicleJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creVehicleJMIActionPerformed
        
        try{
            if (vehicleGUI == null) 
                vehicleGUI = new VehicleGUI(this.connection);
            if (vehicleGUI.isVisible()){
                vehicleGUI.setSelected(true);
            }else{
                this.desktopMain.add(vehicleGUI);
                vehicleGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
        
    }//GEN-LAST:event_creVehicleJMIActionPerformed

    private void creRentalJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creRentalJMIActionPerformed
        try{
            if (rentalGUI == null) 
                rentalGUI = new RentalGUI();
            if (rentalGUI.isVisible()){
                rentalGUI.setSelected(true);
            }else{
                this.desktopMain.add(rentalGUI);
                rentalGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_creRentalJMIActionPerformed

    private void creBillJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creBillJMIActionPerformed
        try{
            if (billGUI == null) 
                billGUI = new BillGUI();
            if (billGUI.isVisible()){
                billGUI.setSelected(true);
            }else{
                this.desktopMain.add(billGUI);
                billGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_creBillJMIActionPerformed

    private void billJMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billJMActionPerformed
        
    }//GEN-LAST:event_billJMActionPerformed

    private void reservateJMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservateJMActionPerformed
        
    }//GEN-LAST:event_reservateJMActionPerformed

    private void myBillsJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myBillsJMIActionPerformed
        try{
            if (myBillGUI == null) 
                myBillGUI = new MyBillGUI();
            if (myBillGUI.isVisible()){
                myBillGUI.setSelected(true);
            }else{
                this.desktopMain.add(myBillGUI);
                myBillGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_myBillsJMIActionPerformed

    private void reservationJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationJMIActionPerformed
        try{
            if (reservateGUI == null) 
                reservateGUI = new ReservateGUI();
            if (reservateGUI.isVisible()){
                reservateGUI.setSelected(true);
            }else{
                this.desktopMain.add(reservateGUI);
                reservateGUI.setVisible(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana");
        }
    }//GEN-LAST:event_reservationJMIActionPerformed

    private boolean loadMenus(){
        
        switch(getUser().getUseType()){
            case 'C':
                customerMenu();
                break;
            case 'A':
                adminMenu();
                break;
            case 'E':
                employeeMenu();
                break;
            default:
                dispose();
                return false;
            
            
        }
        return true;
    }
    
    private boolean customerMenu(){
        
        this.addJM.setVisible(false);
        this.createJM.setVisible(false);
        
        
        return true;
    }
    
    private boolean employeeMenu(){
        
        this.addJM.setVisible(false);
        this.creVehicleJMI.setVisible(false);
        this.billJM.setVisible(false);
        this.reservateJM.setVisible(false);
        //this.
        
        return true;
    }
    
    private boolean adminMenu(){
        this.billJM.setVisible(false);
        this.reservateJM.setVisible(false);
        
        return true;
    }
    
    public void aux(){
        desktopMain = new javax.swing.JDesktopPane();
        mainBar = new javax.swing.JMenuBar();
        myDataJm = new javax.swing.JMenu();
        myDataJMI = new javax.swing.JMenuItem();
        logoutJMI = new javax.swing.JMenuItem();
        addJM = new javax.swing.JMenu();
        addOfficeJMI = new javax.swing.JMenuItem();
        addVehicleJMI = new javax.swing.JMenuItem();
        addCompanyJMI = new javax.swing.JMenuItem();
        createJM = new javax.swing.JMenu();
        creUserJMI = new javax.swing.JMenuItem();
        creVehicleJMI = new javax.swing.JMenuItem();
        creRentalJMI = new javax.swing.JMenuItem();
        creBillJMI = new javax.swing.JMenuItem();
        helpJM = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(desktopMain, java.awt.BorderLayout.CENTER);

        myDataJm.setText("Mi Perfil");
        myDataJm.setName(""); // NOI18N

        myDataJMI.setText("Mis Datos");
        myDataJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myDataJMIActionPerformed(evt);
            }
        });
        myDataJm.add(myDataJMI);

        logoutJMI.setText("Cerrar Sesión");
        myDataJm.add(logoutJMI);

        mainBar.add(myDataJm);

        addJM.setText("Agregar");

        addOfficeJMI.setText("Gestionar Oficina");
        addOfficeJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOfficeJMIActionPerformed(evt);
            }
        });
        addJM.add(addOfficeJMI);

        addVehicleJMI.setText("Gestionar Vehículos");
        addJM.add(addVehicleJMI);

        addCompanyJMI.setText("Empresa");
        addJM.add(addCompanyJMI);

        mainBar.add(addJM);

        createJM.setText("Crear");

        creUserJMI.setText("Usuario");
        creUserJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creUserJMIActionPerformed(evt);
            }
        });
        createJM.add(creUserJMI);

        creVehicleJMI.setText("Vehículo");
        createJM.add(creVehicleJMI);

        creRentalJMI.setText("Alquiler");
        createJM.add(creRentalJMI);

        creBillJMI.setText("Factura");
        createJM.add(creBillJMI);

        mainBar.add(createJM);

        helpJM.setText("Ayuda");
        mainBar.add(helpJM);

        setJMenuBar(mainBar);
    }
    
    private MyDataGUI myDataGUI;
    private BillGUI billGUI;
    private CompanyGUI companyGUI;
    private MyBillGUI myBillGUI;
    private OfficeManagementGUI officeManagementGUI;
    private RentalGUI rentalGUI;
    private ReservateGUI reservateGUI;
    private UserManagementGUI userManagementGUI;
    private VehicleGUI vehicleGUI;
    private VehicleManagementGUI vehicleManagementGUI;
    private User user;
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCompanyJMI;
    private javax.swing.JMenu addJM;
    private javax.swing.JMenuItem addOfficeJMI;
    private javax.swing.JMenuItem addVehicleJMI;
    private javax.swing.JMenu billJM;
    private javax.swing.JMenuItem creBillJMI;
    private javax.swing.JMenuItem creRentalJMI;
    private javax.swing.JMenuItem creUserJMI;
    private javax.swing.JMenuItem creVehicleJMI;
    private javax.swing.JMenu createJM;
    private javax.swing.JDesktopPane desktopMain;
    private javax.swing.JMenu helpJM;
    private javax.swing.JMenuItem logoutJMI;
    private javax.swing.JMenuBar mainBar;
    private javax.swing.JMenuItem myBillsJMI;
    private javax.swing.JMenuItem myDataJMI;
    private javax.swing.JMenu myDataJm;
    private javax.swing.JMenu reservateJM;
    private javax.swing.JMenuItem reservationJMI;
    // End of variables declaration//GEN-END:variables
    
}

