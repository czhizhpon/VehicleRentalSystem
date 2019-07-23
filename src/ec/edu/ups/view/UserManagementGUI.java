/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import javax.swing.JInternalFrame;

/**
 *
 * @author edd
 */
public class UserManagementGUI extends JInternalFrame {

    /**
     * Creates new form UserGUI
     */
    public UserManagementGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usersBtnGroup = new javax.swing.ButtonGroup();
        userPanel = new javax.swing.JPanel();
        dniLB = new javax.swing.JLabel();
        nameLB = new javax.swing.JLabel();
        lastNameLB = new javax.swing.JLabel();
        directionLB = new javax.swing.JLabel();
        directionWLB = new javax.swing.JLabel();
        birthdayLB = new javax.swing.JLabel();
        usernameLB = new javax.swing.JLabel();
        emailLB = new javax.swing.JLabel();
        privilegeLB = new javax.swing.JLabel();
        directionWTxt = new javax.swing.JTextField();
        directionTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        dniTxt = new javax.swing.JTextField();
        usernameTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        dayCB = new javax.swing.JComboBox<>();
        slashLB1 = new javax.swing.JLabel();
        monthCB = new javax.swing.JComboBox<>();
        slashLB2 = new javax.swing.JLabel();
        yearCB = new javax.swing.JComboBox<>();
        createUserBtn = new javax.swing.JButton();
        searchUserBtn = new javax.swing.JButton();
        editUserBtn = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();
        privilegeCB = new javax.swing.JComboBox<>();
        phonePanel = new javax.swing.JPanel();
        phoneLb = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        typePhoneCB = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        phonesTable = new javax.swing.JTable();
        createPhoneBtn = new javax.swing.JButton();
        deletePhoneBtn = new javax.swing.JButton();
        updatePhoneBtn = new javax.swing.JButton();
        generateBtn = new javax.swing.JButton();
        iconLB = new javax.swing.JLabel();
        userBoxPanel = new javax.swing.JPanel();
        adminBtn = new javax.swing.JRadioButton();
        employeeBtn = new javax.swing.JRadioButton();
        customerBtn = new javax.swing.JRadioButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("User");

        userPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        dniLB.setText("Cédula:");

        nameLB.setText("Nombre:");

        lastNameLB.setText("Apellido:");

        directionLB.setText("Dirección:");

        directionWLB.setText("D. Trabajo:");

        birthdayLB.setText("Fecha Nacimiento:");

        usernameLB.setText("Nombre de Usuario:");

        emailLB.setText("Email:");

        privilegeLB.setText("Privilegio:");

        directionWTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directionWTxtActionPerformed(evt);
            }
        });

        directionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directionTxtActionPerformed(evt);
            }
        });

        lastNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTxtActionPerformed(evt);
            }
        });

        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });

        dniTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniTxtActionPerformed(evt);
            }
        });

        usernameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTxtActionPerformed(evt);
            }
        });

        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        dayCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dayCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayCBActionPerformed(evt);
            }
        });

        slashLB1.setText("/");

        monthCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        monthCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCBActionPerformed(evt);
            }
        });

        slashLB2.setText("/");

        yearCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCBActionPerformed(evt);
            }
        });

        createUserBtn.setText("Crear");

        searchUserBtn.setText("Buscar");
        searchUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserBtnActionPerformed(evt);
            }
        });

        editUserBtn.setText("Editar");
        editUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserBtnActionPerformed(evt);
            }
        });

        deleteUserBtn.setText("Eliminar");
        deleteUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserBtnActionPerformed(evt);
            }
        });

        privilegeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        phonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Teléfonos"));

        phoneLb.setText("Número:");

        phoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTxtActionPerformed(evt);
            }
        });

        typePhoneCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        phonesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(phonesTable);

        createPhoneBtn.setText("Crear");

        deletePhoneBtn.setText("Eliminar");
        deletePhoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePhoneBtnActionPerformed(evt);
            }
        });

        updatePhoneBtn.setText("Editar");
        updatePhoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePhoneBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout phonePanelLayout = new javax.swing.GroupLayout(phonePanel);
        phonePanel.setLayout(phonePanelLayout);
        phonePanelLayout.setHorizontalGroup(
            phonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(phonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phonePanelLayout.createSequentialGroup()
                        .addComponent(createPhoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updatePhoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deletePhoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(phonePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(phonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(phonePanelLayout.createSequentialGroup()
                                .addComponent(phoneLb)
                                .addGap(18, 18, 18)
                                .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(typePhoneCB, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        phonePanelLayout.setVerticalGroup(
            phonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phonePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(phonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLb, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(typePhoneCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(phonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createPhoneBtn)
                    .addComponent(updatePhoneBtn)
                    .addComponent(deletePhoneBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(phonePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        generateBtn.setText("Generar Contraseña");

        iconLB.setText("Icono");

        usersBtnGroup.add(adminBtn);
        adminBtn.setText("Administrador");
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });

        usersBtnGroup.add(employeeBtn);
        employeeBtn.setText("Empleado");

        usersBtnGroup.add(customerBtn);
        customerBtn.setText("Cliente");

        javax.swing.GroupLayout userBoxPanelLayout = new javax.swing.GroupLayout(userBoxPanel);
        userBoxPanel.setLayout(userBoxPanelLayout);
        userBoxPanelLayout.setHorizontalGroup(
            userBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBoxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminBtn)
                .addGap(18, 18, 18)
                .addComponent(employeeBtn)
                .addGap(18, 18, 18)
                .addComponent(customerBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userBoxPanelLayout.setVerticalGroup(
            userBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userBoxPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(userBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminBtn)
                    .addComponent(employeeBtn)
                    .addComponent(customerBtn))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(directionWLB)
                            .addComponent(birthdayLB)
                            .addComponent(directionLB)
                            .addComponent(lastNameLB)
                            .addComponent(nameLB)
                            .addComponent(dniLB))
                        .addGap(21, 21, 21)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(createUserBtn)
                                .addGap(18, 18, 18)
                                .addComponent(searchUserBtn)
                                .addGap(18, 18, 18)
                                .addComponent(editUserBtn)
                                .addGap(18, 18, 18)
                                .addComponent(deleteUserBtn)
                                .addGap(92, 92, 92))
                            .addGroup(userPanelLayout.createSequentialGroup()
                                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(userPanelLayout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(directionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(directionWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(userPanelLayout.createSequentialGroup()
                                                .addComponent(dayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(slashLB1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(monthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(slashLB2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(userBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(userPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLB)
                                    .addComponent(emailLB)
                                    .addComponent(privilegeLB))
                                .addGap(18, 18, 18)
                                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(usernameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(privilegeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                                        .addComponent(generateBtn)
                                        .addGap(96, 96, 96))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                                        .addComponent(iconLB, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)))))))
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(userBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dniLB)
                            .addComponent(usernameLB)
                            .addComponent(dniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLB)
                            .addComponent(nameLB)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                        .addComponent(iconLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLB)
                    .addComponent(privilegeLB)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(privilegeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateBtn))
                .addGap(23, 23, 23)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(directionLB)
                            .addComponent(directionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(directionWLB)
                            .addComponent(directionWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthdayLB)
                            .addComponent(dayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slashLB1)
                            .addComponent(monthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slashLB2)
                            .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createUserBtn)
                            .addComponent(searchUserBtn)
                            .addComponent(editUserBtn)
                            .addComponent(deleteUserBtn)))
                    .addComponent(phonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(userPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminBtnActionPerformed

    private void updatePhoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePhoneBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatePhoneBtnActionPerformed

    private void deletePhoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePhoneBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletePhoneBtnActionPerformed

    private void phoneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTxtActionPerformed

    private void deleteUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteUserBtnActionPerformed

    private void editUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editUserBtnActionPerformed

    private void searchUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchUserBtnActionPerformed

    private void yearCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearCBActionPerformed

    private void monthCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthCBActionPerformed

    private void dayCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayCBActionPerformed

    private void dniTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniTxtActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtActionPerformed

    private void lastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTxtActionPerformed

    private void directionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_directionTxtActionPerformed

    private void directionWTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directionWTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_directionWTxtActionPerformed

    private void usernameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTxtActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminBtn;
    private javax.swing.JLabel birthdayLB;
    private javax.swing.JButton createPhoneBtn;
    private javax.swing.JButton createUserBtn;
    private javax.swing.JRadioButton customerBtn;
    private javax.swing.JComboBox<String> dayCB;
    private javax.swing.JButton deletePhoneBtn;
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JLabel directionLB;
    private javax.swing.JTextField directionTxt;
    private javax.swing.JLabel directionWLB;
    private javax.swing.JTextField directionWTxt;
    private javax.swing.JLabel dniLB;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JButton editUserBtn;
    private javax.swing.JLabel emailLB;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JRadioButton employeeBtn;
    private javax.swing.JButton generateBtn;
    private javax.swing.JLabel iconLB;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastNameLB;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JComboBox<String> monthCB;
    private javax.swing.JLabel nameLB;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel phoneLb;
    private javax.swing.JPanel phonePanel;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JTable phonesTable;
    private javax.swing.JComboBox<String> privilegeCB;
    private javax.swing.JLabel privilegeLB;
    private javax.swing.JButton searchUserBtn;
    private javax.swing.JLabel slashLB1;
    private javax.swing.JLabel slashLB2;
    private javax.swing.JComboBox typePhoneCB;
    private javax.swing.JButton updatePhoneBtn;
    private javax.swing.JPanel userBoxPanel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JLabel usernameLB;
    private javax.swing.JTextField usernameTxt;
    private javax.swing.ButtonGroup usersBtnGroup;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables
}
