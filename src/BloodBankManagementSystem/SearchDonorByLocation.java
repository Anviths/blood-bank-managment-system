package BloodBankManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.commons.dbutils.DbUtils;

import ProjBack.ConnectionProvider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cherry
 */
public class SearchDonorByLocation extends javax.swing.JFrame {

    /**
     * Creates new form searchDonorByLocation
     */
    public SearchDonorByLocation() {
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        locationTable = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        printBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(270, 90));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara", 1, 30)); // NOI18N
        jLabel1.setText("Search Blood Donor by Location");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 11, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, 801, 10));

        jLabel2.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel2.setText("Address / City");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 77, -1, -1));

        location.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        location.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                locationKeyReleased(evt);
            }
        });
        getContentPane().add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 75, 170, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 112, 801, 10));

        locationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        locationTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(locationTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, 801, 302));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 441, 801, 10));

        printBtn.setBackground(new java.awt.Color(0, 153, 204));
        printBtn.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        getContentPane().add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 90, 40));

        closeBtn.setBackground(new java.awt.Color(255, 0, 51));
        closeBtn.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 90, 40));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/allformsbg.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        // TODO add your handling code here:
        try{
            locationTable.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_printBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_closeBtnActionPerformed

    private void locationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_locationKeyReleased
        // TODO add your handling code here:
        String loc = location.getText();
        try {
            Connection conn = ConnectionProvider.getCon();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("Select * from donor where city like '%"+loc+"%' or address like '%"+loc+"%'");
            //locationTable.setAutoResizeMode(locationTable.AUTO_RESIZE_OFF);
//            locationTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_locationKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchDonorByLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchDonorByLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchDonorByLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchDonorByLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchDonorByLocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField location;
    private javax.swing.JTable locationTable;
    private javax.swing.JButton printBtn;
    // End of variables declaration//GEN-END:variables
}
