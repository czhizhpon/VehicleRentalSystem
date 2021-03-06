/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import ec.edu.ups.conectionDB.ConnectionJava;
import ec.edu.ups.controller.CustomerController;
import ec.edu.ups.controller.RentalController;
import ec.edu.ups.controller.ReservationController;
import ec.edu.ups.controller.VehicleController;
import ec.edu.ups.model.Customer;
import ec.edu.ups.model.Rental;
import ec.edu.ups.model.Reservation;
import ec.edu.ups.model.Vehicle;
import ec.edu.ups.services.Services;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edd
 */
public class RentalGUI extends javax.swing.JInternalFrame {
    
    private Services services;
    
    private CustomerController conUser;
    private RentalController conRental;
    private VehicleController conVehicle;
    private ReservationController conReservation;
    
    private ConnectionJava connection;
    
    private Customer customer;
    private Vehicle vehicle;
    private Reservation reservation;
    private Rental rental;
    
    private String days;
    

    /**
     * Creates new form RentalGUI
     */
    public RentalGUI() {
        
        initComponents();
        
        connection = new ConnectionJava();
        services = new Services();
        
        conUser = new CustomerController();
        conVehicle = new VehicleController();
        conRental = new RentalController();
        conReservation = new ReservationController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rentalPanel = new javax.swing.JPanel();
        vehiclePanel = new javax.swing.JPanel();
        plateLB = new javax.swing.JLabel();
        plateTxt = new javax.swing.JTextField();
        statusVehicleTxt = new javax.swing.JTextField();
        statusVehicleLB = new javax.swing.JLabel();
        kilometrageInitLB = new javax.swing.JLabel();
        kilometrageInitTxt = new javax.swing.JTextField();
        kilometrageEndLB = new javax.swing.JLabel();
        kilometrageEndTxt = new javax.swing.JTextField();
        dateInitLB = new javax.swing.JLabel();
        dateInitTxt = new javax.swing.JTextField();
        totalDaysLB = new javax.swing.JLabel();
        totalDaysTxt = new javax.swing.JTextField();
        searchVehicleBtn = new javax.swing.JButton();
        rentalBtn = new javax.swing.JButton();
        dniLB = new javax.swing.JLabel();
        dniTxt = new javax.swing.JTextField();
        searchCustomerBtn = new javax.swing.JButton();
        warrantyTxt = new javax.swing.JTextField();
        warrantyLB = new javax.swing.JLabel();
        vehicleDetailPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vehicleTable = new javax.swing.JTable();
        dayCostLB = new javax.swing.JLabel();
        dayCostTxt = new javax.swing.JTextField();
        damageLB = new javax.swing.JLabel();
        damageTxt = new javax.swing.JTextField();
        subtotalLB = new javax.swing.JLabel();
        subtotalTxt = new javax.swing.JTextField();
        aceptBtn = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alquiler");

        vehiclePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Vehículo"));

        plateLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        plateLB.setText("Placa:");

        statusVehicleTxt.setEditable(false);
        statusVehicleTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusVehicleTxtActionPerformed(evt);
            }
        });

        statusVehicleLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        statusVehicleLB.setText("Estado Vehículo: ");

        kilometrageInitLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        kilometrageInitLB.setText("Kilometrage Inicial:");

        kilometrageInitTxt.setEditable(false);

        kilometrageEndLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        kilometrageEndLB.setText("Kilometrage Final:");

        dateInitLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateInitLB.setText("Fecha Inicio:");

        dateInitTxt.setEditable(false);

        totalDaysLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalDaysLB.setText("Total Días:");

        searchVehicleBtn.setText("Buscar");
        searchVehicleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchVehicleBtnActionPerformed(evt);
            }
        });

        rentalBtn.setText("Alquilar");
        rentalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalBtnActionPerformed(evt);
            }
        });

        dniLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dniLB.setText("Cédula:");

        searchCustomerBtn.setText("Buscar");
        searchCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerBtnActionPerformed(evt);
            }
        });

        warrantyLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        warrantyLB.setText("Garantia:");

        javax.swing.GroupLayout vehiclePanelLayout = new javax.swing.GroupLayout(vehiclePanel);
        vehiclePanel.setLayout(vehiclePanelLayout);
        vehiclePanelLayout.setHorizontalGroup(
            vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehiclePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehiclePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rentalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(vehiclePanelLayout.createSequentialGroup()
                        .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(vehiclePanelLayout.createSequentialGroup()
                                .addComponent(dniLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchCustomerBtn))
                            .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(vehiclePanelLayout.createSequentialGroup()
                                    .addComponent(dateInitLB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateInitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vehiclePanelLayout.createSequentialGroup()
                                    .addComponent(totalDaysLB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vehiclePanelLayout.createSequentialGroup()
                                    .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(vehiclePanelLayout.createSequentialGroup()
                                            .addComponent(kilometrageEndLB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(kilometrageEndTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(vehiclePanelLayout.createSequentialGroup()
                                            .addComponent(plateLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(plateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehiclePanelLayout.createSequentialGroup()
                                            .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(statusVehicleLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(kilometrageInitLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(kilometrageInitTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(statusVehicleTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(searchVehicleBtn))))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(vehiclePanelLayout.createSequentialGroup()
                        .addComponent(warrantyLB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warrantyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        vehiclePanelLayout.setVerticalGroup(
            vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehiclePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniLB)
                    .addComponent(dniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCustomerBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plateLB)
                    .addComponent(plateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchVehicleBtn))
                .addGap(18, 18, 18)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusVehicleLB)
                    .addComponent(statusVehicleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kilometrageInitLB)
                    .addComponent(kilometrageInitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kilometrageEndLB)
                    .addComponent(kilometrageEndTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateInitLB)
                    .addComponent(dateInitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalDaysLB)
                    .addComponent(totalDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warrantyLB)
                    .addComponent(warrantyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rentalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        vehicleDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        vehicleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(vehicleTable);

        dayCostLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayCostLB.setText("Precio por Día:");

        dayCostTxt.setEditable(false);
        dayCostTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayCostTxtActionPerformed(evt);
            }
        });

        damageLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        damageLB.setText("% de Daño:");

        subtotalLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subtotalLB.setText("Subtotal:");

        subtotalTxt.setEditable(false);

        aceptBtn.setText("Aceptar");
        aceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vehicleDetailPanelLayout = new javax.swing.GroupLayout(vehicleDetailPanel);
        vehicleDetailPanel.setLayout(vehicleDetailPanelLayout);
        vehicleDetailPanelLayout.setHorizontalGroup(
            vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehicleDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(vehicleDetailPanelLayout.createSequentialGroup()
                        .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(subtotalLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(damageLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dayCostLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehicleDetailPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(subtotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vehicleDetailPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dayCostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(damageTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(aceptBtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        vehicleDetailPanelLayout.setVerticalGroup(
            vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehicleDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayCostLB)
                    .addComponent(dayCostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(damageLB)
                    .addComponent(damageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehicleDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotalLB))
                .addGap(18, 18, 18)
                .addComponent(aceptBtn)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rentalPanelLayout = new javax.swing.GroupLayout(rentalPanel);
        rentalPanel.setLayout(rentalPanelLayout);
        rentalPanelLayout.setHorizontalGroup(
            rentalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rentalPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(vehiclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(vehicleDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        rentalPanelLayout.setVerticalGroup(
            rentalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rentalPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(rentalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vehicleDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehiclePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rentalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rentalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statusVehicleTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusVehicleTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusVehicleTxtActionPerformed

    private void searchVehicleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchVehicleBtnActionPerformed
        
        DefaultTableModel tableModel = new DefaultTableModel();
        String [] colums = {"Id", "Placa", "Color", "Modelo", "Marca", "Categoría"}; 
        String [][] rows;
        
        try {
            
            vehicle = new Vehicle();
            
            conVehicle.readVehicle(connection, vehicle, plateTxt.getText());
            
            statusVehicleTxt.setText("" + vehicle.getVehStatus());
                    
            kilometrageInitTxt.setText("" + vehicle.getVehKilometraje());
            kilometrageEndTxt.setText("" + vehicle.getVehKilometraje());

            String date = "" + (new java.util.Date());
            dateInitTxt.setText(date);

            dayCostTxt.setText("" + vehicle.getVehCategory().getCatDayCost());
            damageTxt.setText("0");
            
            
            rows = new String[0][5];
            
            rows[0][0] = "" + vehicle.getVehId();
            rows[0][1] = vehicle.getVehPlate();
            rows[0][2] = vehicle.getVehColor();
            rows[0][3] = vehicle.getVehModel().getModName();
            rows[0][4] = vehicle.getVehModel().getModBrand().getBraName();
            rows[0][5] = vehicle.getVehCategory().getCatName();
            
            tableModel.setDataVector(rows, colums);
            this.vehicleTable.setModel(tableModel);
            
            switch(vehicle.getVehStatus()){
                case 'D':
                    JOptionPane.showMessageDialog(null, "Vehículo Disponible.");
                    
                    break;
                case 'A':
                    statusVehicleTxt.setText("" + vehicle.getVehStatus());
                    JOptionPane.showMessageDialog(null, "Vehículo Alquilado.");
                    
                    rental = new Rental();
                    
                    conRental.readRental(connection, rental, dniTxt.getText());
                    
                    if (rental.getRenCustomer().getUseDNI()== dniTxt.getText()) {
                        rentalBtn.setName("Devolver");
                    }
                    
                    break;
                case 'R':
                    statusVehicleTxt.setText("" + vehicle.getVehStatus());
                    JOptionPane.showMessageDialog(null, "Vehículo en Reparaciones.");
                    break;
                case 'S':
                    statusVehicleTxt.setText("" + vehicle.getVehStatus());
                    JOptionPane.showMessageDialog(null, "Vehículo Resrevado.");
                    
                    reservation = new Reservation();
                    
                    conReservation.readReservation(connection, reservation, 
                            dniTxt.getSelectedText(), plateTxt.getText());
                    
                    if (reservation.getResCustomer().getUseDNI()==dniTxt.getSelectedText()) {
                        rentalBtn.setName("Alquilar");
                        
                    }
                    
                    break;
                    
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Vehículo no encontrado." + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
     
    }//GEN-LAST:event_searchVehicleBtnActionPerformed

    private void aceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptBtnActionPerformed
        
        try{
            int totalDays = Integer.parseInt(totalDaysTxt.getText());
            double damage = Integer.parseInt(damageTxt.getText());
            double dayCost = Double.parseDouble(dayCostTxt.getText());
            double warranty = Double.parseDouble(warrantyTxt.getText());

            double costVehicle = vehicle.getVehModel().getModCost();

            damage = (damage/100)*costVehicle;

            subtotalTxt.setText("" + (totalDays*dayCost+warranty+damage));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Datos Invalidos o erroneos" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_aceptBtnActionPerformed

    private void searchCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerBtnActionPerformed
        
        
        try{
        customer = new Customer();
        conUser.readDniCustomer(connection, customer, dniTxt.getText());
        
        JOptionPane.showMessageDialog(null, "Cliente encontrado.");
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado."
                        + "\n" + ex);
        }
        
    }//GEN-LAST:event_searchCustomerBtnActionPerformed

    private void rentalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalBtnActionPerformed
        
        try{
            switch(evt.getActionCommand()){
                case "rental":

                    rental = new Rental();
                    rental.setRenCustomer(customer);
                    rental.setRenVehicle(vehicle);
                    
                    Calendar cal = Calendar.getInstance(); 
                    cal.setTime(new java.util.Date()); 
                    cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(totalDaysTxt.getText()));
                    
                    rental.setRenDateFin(cal.getTime());

                    rental.setRenDateIni(new java.util.Date());
                    //rental.setRenId();
                    
                    rental.setRenKilometrajeFin(vehicle.getVehKilometraje());
                    rental.setRenKilometrajeIni(vehicle.getVehKilometraje());
                    rental.setRenReservation(null);
                    rental.setRenWarranty(Double.parseDouble(warrantyTxt.getText()));

                    conRental.createRental(connection, rental);

                    break;

                case "return":

                    rental.setRenCustomer(customer);
                    rental.setRenVehicle(vehicle);

                    rental.setRenDateFin(rental.getRenDateFin());

                    rental.setRenDateIni(rental.getRenDateIni());
                    //rental.setRenId();
                    rental.setRenKilometrajeFin(vehicle.getVehKilometraje());
                    rental.setRenKilometrajeIni(vehicle.getVehKilometraje());
                    rental.setRenReservation(null);
                    rental.setRenWarranty(Double.parseDouble(warrantyTxt.getText()));

                    conRental.createRental(connection, rental);

                    break;
            }
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        
        
    }//GEN-LAST:event_rentalBtnActionPerformed

    private void dayCostTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayCostTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayCostTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptBtn;
    private javax.swing.JLabel damageLB;
    private javax.swing.JTextField damageTxt;
    private javax.swing.JLabel dateInitLB;
    private javax.swing.JTextField dateInitTxt;
    private javax.swing.JLabel dayCostLB;
    private javax.swing.JTextField dayCostTxt;
    private javax.swing.JLabel dniLB;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kilometrageEndLB;
    private javax.swing.JTextField kilometrageEndTxt;
    private javax.swing.JLabel kilometrageInitLB;
    private javax.swing.JTextField kilometrageInitTxt;
    private javax.swing.JLabel plateLB;
    private javax.swing.JTextField plateTxt;
    private javax.swing.JButton rentalBtn;
    private javax.swing.JPanel rentalPanel;
    private javax.swing.JButton searchCustomerBtn;
    private javax.swing.JButton searchVehicleBtn;
    private javax.swing.JLabel statusVehicleLB;
    private javax.swing.JTextField statusVehicleTxt;
    private javax.swing.JLabel subtotalLB;
    private javax.swing.JTextField subtotalTxt;
    private javax.swing.JLabel totalDaysLB;
    private javax.swing.JTextField totalDaysTxt;
    private javax.swing.JPanel vehicleDetailPanel;
    private javax.swing.JPanel vehiclePanel;
    private javax.swing.JTable vehicleTable;
    private javax.swing.JLabel warrantyLB;
    private javax.swing.JTextField warrantyTxt;
    // End of variables declaration//GEN-END:variables
}
