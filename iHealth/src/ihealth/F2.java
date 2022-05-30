
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aiman Harith
 */
public class F2 extends javax.swing.JFrame {

    /**
     * Creates new form F2
     */
    public F2() {
        initComponents();
        display();
    }

    public void display() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihealth?useTimezone=true&serverTimezone=UTC", "root", "root");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM appointmentbookings");
            Object rowData[] = new Object[6];
            while (rs.next()) {
                rowData[0] = rs.getString("No");
                rowData[1] = rs.getString("Patient Name");
                rowData[2] = rs.getString("Patient Identity Card");
                rowData[3] = rs.getString("Appointment Date");
                rowData[4] = rs.getString("Appointment Start Time");
                rowData[5] = rs.getString("Appointment End Time");
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(rowData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "IC No", "Date", "Start Time", "End Time"
            }
        ));
        jTable1.setCellSelectionEnabled(true);
        jTable1.setDragEnabled(true);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Patient List");

        jButton5.setLabel("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jLabel1)
                .addContainerGap(417, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(8, 8, 8)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String fname = JOptionPane.showInputDialog("Enter The Name");
        String ic = JOptionPane.showInputDialog("Enter The IC");
        String date = JOptionPane.showInputDialog("Enter The Date");
        String starttime = JOptionPane.showInputDialog("Enter The Start Time");
        String endtime = JOptionPane.showInputDialog("Enter The End Time");

        // create a row with the given data
        Object rowData[] = new Object[6];
        rowData[0] = null;
        rowData[1] = fname;
        rowData[2] = ic;
        rowData[3] = date;
        rowData[4] = starttime;
        rowData[5] = endtime;

        // add row To the jtable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(rowData);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihealth?useTimezone=true&serverTimezone=UTC", "root", "root");

            String sql = "INSERT INTO appointmentbookings values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, null);
            pstmt.setString(2, fname);
            pstmt.setString(3, ic);
            pstmt.setString(4, date);
            pstmt.setString(5, starttime);
            pstmt.setString(6, endtime);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertion Successdul.");
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        
        String name = model.getValueAt(selectedRowIndex, 1).toString();
        String ic = model.getValueAt(selectedRowIndex, 2).toString();
        String date = model.getValueAt(selectedRowIndex, 3).toString();
        String starttime = model.getValueAt(selectedRowIndex, 4).toString();
        String endtime = model.getValueAt(selectedRowIndex, 5).toString();
        
        String Newfname = JOptionPane.showInputDialog(null, "Enter The New Name", name);
        String Newic = JOptionPane.showInputDialog(null, "Enter The New IC", ic);
        String Newdate = JOptionPane.showInputDialog(null, "Enter The New Date", date);
        String Newstarttime = JOptionPane.showInputDialog(null, "Enter The New Time", starttime);
        String Newendtime = JOptionPane.showInputDialog(null, "Enter The New Time", endtime);

        model.setValueAt(Newfname, selectedRowIndex, 1);
        model.setValueAt(Newic, selectedRowIndex, 2);
        model.setValueAt(Newdate, selectedRowIndex, 3);
        model.setValueAt(Newstarttime, selectedRowIndex, 4);
        model.setValueAt(Newendtime, selectedRowIndex, 4);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihealth?useTimezone=true&serverTimezone=UTC", "root", "root");
            System.out.println("con");
            String value = (jTable1.getModel().getValueAt(selectedRowIndex, 0).toString());
            String sql = "UPDATE appointmentbookings SET `Patient Name`=?, `Patient Identity Card`=?, `Appointment Date`=?, `Appointment Start Time`=?, `Appointment End Time`=? where No=" + value; 
             
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Newfname);
            pstmt.setString(2, Newic);
            pstmt.setString(3, Newdate);
            pstmt.setString(4, Newstarttime);
            pstmt.setString(5, Newendtime);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successdul.");
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // get selected row index
        try {
            int SelectedRowIndex = jTable1.getSelectedRow();
            String value = (jTable1.getModel().getValueAt(SelectedRowIndex, 0).toString());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihealth?useTimezone=true&serverTimezone=UTC", "root", "root");

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM appointmentbookings where No=" + value);
            pstmt.executeUpdate();
            model.removeRow(SelectedRowIndex);
            JOptionPane.showMessageDialog(rootPane, "Delete Successful !");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new F1().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}