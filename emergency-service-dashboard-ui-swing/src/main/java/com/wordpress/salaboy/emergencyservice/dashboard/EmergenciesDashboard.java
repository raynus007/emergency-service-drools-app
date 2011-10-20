/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/*
 * EmergenciesDashboard.java
 *
 * Created on Apr 29, 2011, 9:49:25 PM
 */
package com.wordpress.salaboy.emergencyservice.dashboard;

import com.wordpress.salaboy.context.tracking.ContextTrackingProvider;
import com.wordpress.salaboy.context.tracking.ContextTrackingService;
import com.wordpress.salaboy.messaging.MessageConsumerWorker;
import com.wordpress.salaboy.messaging.MessageConsumerWorkerHandler;
import com.wordpress.salaboy.model.Emergency;
import com.wordpress.salaboy.model.Hospital;
import com.wordpress.salaboy.model.events.FireTruckDecreaseWaterLevelEvent;
import com.wordpress.salaboy.model.events.FireTruckOutOfWaterEvent;
import com.wordpress.salaboy.model.serviceclient.PersistenceService;
import com.wordpress.salaboy.model.serviceclient.PersistenceServiceProvider;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salaboy
 */
public class EmergenciesDashboard extends javax.swing.JFrame {

    private final PersistenceService persistenceService;
    private final ContextTrackingService trackingService;

    /** Creates new form EmergenciesDashboard */
    public EmergenciesDashboard() throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ContextTrackingImplementation", ContextTrackingProvider.ContextTrackingServiceType.IN_MEMORY);
        persistenceService = PersistenceServiceProvider.getPersistenceService();

        trackingService = ContextTrackingProvider.getTrackingService();
        initComponents();



    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        System.out.println(">>>>  Opening the DASHBOARD");
        emergenciesjTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        refreshjButton = new javax.swing.JButton();
        liveReportjButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hospitalsjTable = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Emergencies", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Collection<Emergency> emergencies = (Collection<Emergency>) persistenceService.getAllEmergencies();
        System.out.println(">>>>  Emergencies Count in the DASHBOARD:"+emergencies.size());
        Object[][] emergenciesArray = new Object[emergencies.size()][4];
        Iterator<Emergency> it = emergencies.iterator();
        int i = 0;
        while(it.hasNext()){
            Emergency emergency = it.next();
            emergenciesArray[i][0] = emergency.getId();
            emergenciesArray[i][1] = emergency.getCall().getId();
            emergenciesArray[i][2] = emergency.getType().toString();
            emergenciesArray[i][3] = emergency.getNroOfPeople();
            i++;
        }
        emergenciesjTable.setModel(new javax.swing.table.DefaultTableModel(
            emergenciesArray,
            new String [] {
                "Emergency ID", "Call ID", "Emergency Type", "People involved"
            }
        ));
        jScrollPane1.setViewportView(emergenciesjTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        liveReportjButton.setText("Emergency Live Report");
        liveReportjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liveReportjButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(refreshjButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(liveReportjButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 225, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(refreshjButton)
                .add(liveReportjButton))
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Emergencies", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hospitals", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View Hospital Status");

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(5, 5, 5)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButton2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(jButton1))
                .addContainerGap())
        );

        hospitalsjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(hospitalsjTable);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane2)
            .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hospitals", jPanel4);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 487, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 319, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        Object[][] vehicles = new Object[persistenceService.getAllHospitals().size()][2];         
        int i = 0;         
        for (Hospital hospital : persistenceService.getAllHospitals()) {             
                vehicles[i][0] = hospital.getId();             
                vehicles[i][1] = hospital.getName();             
                i++;         
        }         
        hospitalsjTable.setModel(new javax.swing.table.DefaultTableModel(vehicles,  
                new String[]{ "ID", "Hospital"  }));     
    }                                        
        // TODO add your handling code here:         Object[][] vehicles = new Object[persistenceService.getAllHospitals().size()][2];         int i = 0;         for (Hospital hospital : persistenceService.getAllHospitals()) {             vehicles[i][0] = hospital.getId();             vehicles[i][1] = hospital.getName();             i++;         }         hospitalsjTable.setModel(new javax.swing.table.DefaultTableModel(                 vehicles,                 new String[]{                     "ID", "Hospital"                 }));     }//GEN-LAST:event_jButton1ActionPerformed

        private void liveReportjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liveReportjButtonActionPerformed
        int[] selected = emergenciesjTable.getSelectedRows();
        List<String> selectedEmergencies = new ArrayList<String>(selected.length);
        for (int i = 0; i < selected.length; i++) {
            selectedEmergencies.add((String) emergenciesjTable.getModel().getValueAt(i, 0));
        }
        openLiveReportPanel(selectedEmergencies);
    }
        // TODO add your handling code here:         int[] selected = emergenciesjTable.getSelectedRows();          List<String> selectedEmergencies = new ArrayList<String>(selected.length);          for (int i = 0; i < selected.length; i++) {             selectedEmergencies.add((String) emergenciesjTable.getModel().getValueAt(i, 0));         }          openLiveReportPanel(selectedEmergencies);     }//GEN-LAST:event_liveReportjButtonActionPerformed

        private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
            // TODO add your handling code here:
            Collection<Emergency> emergencies = (Collection<Emergency>) persistenceService.getAllEmergencies();
            Object[][] emergenciesArray = new Object[emergencies.size()][4];
            Iterator<Emergency> it = emergencies.iterator();
            int i = 0;
            while (it.hasNext()) {
                Emergency emergency = it.next();
                System.out.println("Emergency -> " + emergency);
                emergenciesArray[i][0] = emergency.getId();
                emergenciesArray[i][1] = emergency.getCall().getId();
                emergenciesArray[i][2] = emergency.getType().toString();
                emergenciesArray[i][3] = emergency.getNroOfPeople();
                i++;
            }
            emergenciesjTable.setModel(new javax.swing.table.DefaultTableModel(
                    emergenciesArray,
                    new String[]{
                        "Emergency ID", "Call ID", "Emergency Type", "People involved"
                    }));
    }//GEN-LAST:event_refreshjButtonActionPerformed
   

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
        public void run() {
                try {
                    new EmergenciesDashboard().setVisible(true);
                

} catch (IOException ex) {
                    Logger.getLogger(EmergenciesDashboard.class  

.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable emergenciesjTable;
    private javax.swing.JTable hospitalsjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton liveReportjButton;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables

    private void openLiveReportPanel(final List<String> selectedEmergencies) {
        //
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new LiveEmergencyReport(selectedEmergencies.get(0)).setVisible(true);
                

} catch (IOException ex) {
                    Logger.getLogger(EmergenciesDashboard.class  

.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

   
}
