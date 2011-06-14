/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UDPServerPanel.java
 *
 * Created on May 12, 2011, 12:28:44 PM
 */
package com.wordpress.salaboy.sensor.ui;

import com.wordpress.salaboy.messaging.MessageConsumerWorker;
import com.wordpress.salaboy.messaging.MessageConsumerWorkerHandler;
import com.wordpress.salaboy.model.messages.patient.HeartBeatMessage;
import com.wordpress.salaboy.sensor.SensorDataParser;
import com.wordpress.salaboy.sensor.SensorMessageProducer;
import com.wordpress.salaboy.sensor.udp.AccSimIPhoneUDPAccelerometerSensorParser;
import com.wordpress.salaboy.sensor.udp.GDroidUDPAccelerometerSensorParser;
import com.wordpress.salaboy.sensor.udp.GenericUDPAccelerometerSensorParser;
import com.wordpress.salaboy.sensor.udp.UDPSensorServer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author esteban
 */
public class UDPServerPanel extends javax.swing.JPanel {

    private UDPSensorServer udpServer;
    
    private MessageConsumerWorker accelerometerListener;
    
    private SensorDataParser lastSensorDataParser;
    private SensorMessageProducer lastSensorMessageProducer;
    
    private boolean offlineMode;
    
    /** Creates new form UDPServerPanel */
    public UDPServerPanel(SensorMessageProducer sensorMessageProducer,boolean offlineMode) {
        udpServer = new UDPSensorServer(new GenericUDPAccelerometerSensorParser(), sensorMessageProducer );
        initComponents();
        this.setOfflineMode(offlineMode);
        this.setComponentPopupMenu(new JPopupMenu("Options"){
            {
                JButton clearButton = new JButton("Clear Messages");
                
                clearButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel newModel = new DefaultTableModel(new Object[]{"Value"}, 0);
                        tblUDPEvents.setModel(newModel);
                    }
                });
                
                add(new JLabel("Options"));
                add(clearButton);
            }
        });
        
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIPAddress = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnStartStopUDPListener = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        cboUDPDataParserImplementation = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUDPEvents = new javax.swing.JTable();

        setName("UDP Server"); // NOI18N

        jLabel1.setText("Address:");

        lblIPAddress.setFont(new java.awt.Font("Ubuntu", 1, 15));
        lblIPAddress.setText("multicast");

        jLabel3.setText("Port:");

        txtPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPortActionPerformed(evt);
            }
        });

        btnStartStopUDPListener.setText("Start");
        btnStartStopUDPListener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartStopUDPListenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStartStopUDPListener)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStartStopUDPListener))
                .addContainerGap())
        );

        jLabel4.setText("Parser:");

        cboUDPDataParserImplementation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Generic", "GDroid - Android", "AccSim - IPhone" }));
        cboUDPDataParserImplementation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboUDPDataParserImplementationItemStateChanged(evt);
            }
        });
        cboUDPDataParserImplementation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUDPDataParserImplementationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIPAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cboUDPDataParserImplementation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblIPAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cboUDPDataParserImplementation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblUDPEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUDPEvents);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPortActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtPortActionPerformed

    private void btnStartStopUDPListenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartStopUDPListenerActionPerformed
        if (udpServer.isRunning()) {
            this.stopAccelerometerListener();
            this.stopUDPServer();
            btnStartStopUDPListener.setText("Start");
        } else {
            try {
                int port = Integer.parseInt(txtPort.getText());
                this.startAccelerometerListener();
                this.startUDPServer(port);
                btnStartStopUDPListener.setText("Stop");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "'" + txtPort.getText() + "' is not a valid port value. Use an integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_btnStartStopUDPListenerActionPerformed

    private void cboUDPDataParserImplementationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboUDPDataParserImplementationItemStateChanged
        
    }//GEN-LAST:event_cboUDPDataParserImplementationItemStateChanged

    private void cboUDPDataParserImplementationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUDPDataParserImplementationActionPerformed
        if (offlineMode){
            return;
        }
        
        String parserName = (String) cboUDPDataParserImplementation.getSelectedItem();
        System.out.println(parserName + " selected");
        if (parserName.equals("Generic")){
            udpServer.setSensorDataParser(new GenericUDPAccelerometerSensorParser());
        } else if (parserName.equals("GDroid - Android")){
            udpServer.setSensorDataParser(new GDroidUDPAccelerometerSensorParser());
        } else if (parserName.equals("AccSim - IPhone")){
            udpServer.setSensorDataParser(new AccSimIPhoneUDPAccelerometerSensorParser());
        }
    }//GEN-LAST:event_cboUDPDataParserImplementationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnStartStopUDPListener;
    private javax.swing.JComboBox cboUDPDataParserImplementation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIPAddress;
    private javax.swing.JTable tblUDPEvents;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
    
    private void startUDPServer(int port) {
        try {
            udpServer.startService(null, port);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Starting UDP Server: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void stopUDPServer() {
        this.udpServer.stopService();
    }
    
    /**
     * starts the listener used to log the processed accelerometer values
     */
    private void startAccelerometerListener(){
        if (offlineMode){
            return;
        }
        //TODO: change HeartBeatMessage when we switch to a more generic message
        accelerometerListener = new MessageConsumerWorker("udpSensorLogger", new MessageConsumerWorkerHandler<HeartBeatMessage>() {

            @Override
            public void handleMessage(HeartBeatMessage message) {
                ((DefaultTableModel)tblUDPEvents.getModel()).insertRow(0,new Object[]{message.getHeartBeatValue()});
            }

        });
        
        accelerometerListener.start();
    }
    
    private void stopAccelerometerListener(){
        if (accelerometerListener != null){
            accelerometerListener.stopWorker();
        }
        
        accelerometerListener = null;
    }

    public void setOfflineMode(boolean offlineMode) {
        this.offlineMode = offlineMode;
        
        if (this.offlineMode){
            this.cboUDPDataParserImplementation.setEnabled(false);
            this.stopAccelerometerListener();
            
            lastSensorDataParser = udpServer.getSensorDataParser();
            udpServer.setSensorDataParser(new SensorDataParser() {

                @Override
                public double parseData(String data) {
                    ((DefaultTableModel)tblUDPEvents.getModel()).insertRow(0,new Object[]{data});
                    return 0;
                }

                @Override
                public boolean isValidData(String data) {
                    return true;
                }
            });
            
            lastSensorMessageProducer = udpServer.getSensorMessageProducer();
            udpServer.setSensorMessageProducer(new SensorMessageProducer(null){

                @Override
                public void informMessage(double heartBeat) throws Exception {
                    //Do nothing
                }
                
            });
            
        }else{
            this.startAccelerometerListener();
            udpServer.setSensorDataParser(lastSensorDataParser);
            udpServer.setSensorMessageProducer(lastSensorMessageProducer);
            this.cboUDPDataParserImplementation.setEnabled(true);
        }
    }
}