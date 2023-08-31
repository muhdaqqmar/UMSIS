/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMSIS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nazzim
 */
public class updateStudents extends javax.swing.JFrame {

    /**
     * Creates new form updateStudents
     */
    Connection con;
    Connection con1;
    PreparedStatement insert;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    ResultSet rs;
    
    public updateStudents() {
        initComponents();
        students();
        courses();
        faculties();
        chooseStudent();
    }
    
    public void courses()
    {       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
            pst2 = con.prepareStatement("select * from faculty");
            rs = pst2.executeQuery();
              
            txtfacultyid.removeAllItems();
              
            while(rs.next()) {
                txtfacultyid.addItem(rs.getString(1));
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void faculties()
    {       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
            pst1 = con.prepareStatement("select * from course");
            rs = pst1.executeQuery();
              
            txtcourseid.removeAllItems();
              
            while(rs.next()) {
                txtcourseid.addItem(rs.getString(1));
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void students()
    {       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
            pst3 = con.prepareStatement("select * from student");
            rs = pst3.executeQuery();
              
            txtstudentid.removeAllItems();
              
            while(rs.next()) {
                txtstudentid.addItem(rs.getString(1));
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    private void chooseStudent() {
        try {
            //Declare driver and connection string
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
            
            insert = con1.prepareStatement("select * from student");
            ResultSet rs = insert.executeQuery();
            
            int studentidDB = 0;
            int studentid = Integer.parseInt(txtstudentid.getSelectedItem().toString());
            String studentname = "";
            String studentaddress = "";
            String dateofbirth = "";
            String semester = "";
            String courseid = "";
            String facultyid = "";
            
            while(rs.next()) {
                studentidDB = Integer.parseInt(rs.getString("studentid"));
                if(studentid == studentidDB) {
                    studentname = rs.getString("studentname");
                    studentaddress = rs.getString("studentaddress");
                    dateofbirth = rs.getString("dateofbirth");
                    semester = rs.getString("semester");
                    courseid = rs.getString("courseid");
                    facultyid = rs.getString("facultyid");
                }
            }    
            txtstudentname.setText(studentname);
            txtstudentaddress.setText(studentaddress);
            txtstudentbirthday.setText(dateofbirth);
            txtsemester.setText(semester);
            txtcourseid.setSelectedItem(courseid);
            txtfacultyid.setSelectedItem(facultyid);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateStudents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateStudents.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtstudentaddress = new javax.swing.JTextArea();
        txtstudentname = new javax.swing.JTextField();
        txtstudentbirthday = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsemester = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcourseid = new javax.swing.JComboBox<>();
        txtfacultyid = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtstudentid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("UPDATE STUDENT");

        jLabel2.setText("STUDENT ID:");

        jLabel3.setText("NAME:");

        jLabel4.setText("ADDRESS:");

        jLabel5.setText("BIRTHDAY:");

        txtstudentaddress.setColumns(20);
        txtstudentaddress.setRows(5);
        jScrollPane1.setViewportView(txtstudentaddress);

        jLabel6.setText("SEMESTER:");

        jLabel7.setText("COURSE ID:");

        jLabel8.setText("FACULTY ID:");

        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CANCEL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtstudentid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtstudentidMouseClicked(evt);
            }
        });
        txtstudentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstudentidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtsemester)
                        .addComponent(txtstudentbirthday)
                        .addComponent(txtstudentname)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                    .addComponent(txtstudentid, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtcourseid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtfacultyid, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtstudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtstudentname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtstudentbirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtsemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtcourseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfacultyid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtstudentname.setText("");
        txtstudentaddress.setText("");
        txtstudentbirthday.setText("");
        txtsemester.setText("");
        txtcourseid.setSelectedIndex(-1);
        txtfacultyid.setSelectedIndex(-1);
        txtstudentname.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        try {
            int studentid = Integer.parseInt(txtstudentid.getSelectedItem().toString());
            String studentname = txtstudentname.getText();
            String studentaddress = txtstudentaddress.getText();
            String dateofbirth = txtstudentbirthday.getText();
            String semester = txtsemester.getText();
            String courseid = txtcourseid.getSelectedItem().toString();
            String facultyid = txtfacultyid.getSelectedItem().toString();
            chooseStudent();
             
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
                
            pst = con.prepareStatement("update student set studentname=?,studentaddress=?,semester=?,dateofbirth=?,courseid=?,facultyid=? where studentid=?");
            pst.setString(1, studentname);
            pst.setString(2, studentaddress);
            pst.setString(3, semester);
            pst.setString(4, dateofbirth);
            pst.setString(5, courseid);
            pst.setString(6, facultyid);
            pst.setInt(7, studentid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student Updated!");
            
            txtstudentname.setText("");
            txtstudentaddress.setText("");
            txtstudentbirthday.setText("");
            txtsemester.setText("");
            txtcourseid.setSelectedIndex(-1);
            txtfacultyid.setSelectedIndex(-1);
            txtstudentname.requestFocus();
            
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtstudentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstudentidActionPerformed
        // TODO add your handling code here:
        chooseStudent();
    }//GEN-LAST:event_txtstudentidActionPerformed

    private void txtstudentidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtstudentidMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtstudentidMouseClicked

    /**/
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
            java.util.logging.Logger.getLogger(updateStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> txtcourseid;
    private javax.swing.JComboBox<String> txtfacultyid;
    private javax.swing.JTextField txtsemester;
    private javax.swing.JTextArea txtstudentaddress;
    private javax.swing.JTextField txtstudentbirthday;
    private javax.swing.JComboBox<String> txtstudentid;
    private javax.swing.JTextField txtstudentname;
    // End of variables declaration//GEN-END:variables
}