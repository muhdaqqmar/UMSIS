
package UMSIS;

import java.awt.Color;
import static java.awt.Color.red;
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
 * @author emirh
 */
public class addLecturer extends javax.swing.JFrame {


    public addLecturer() {
        initComponents();
        DBConnection();
        table_load();
        courses();
        faculties();
        if(VerifyFirst()){
        btnedit.setEnabled(false);
        btndelete.setEnabled(false);
        
        }
    }
    
    Connection conn;
    PreparedStatement ps;
    DefaultTableModel df;
    ResultSet rs;
    
    
  public boolean VerifyFirst(){
    
    if(txtname.getText().isEmpty() || txtid.getText().equals("")|| txtdob.getText().equals("")|| 
       txtstatus.getText().equals("")|| txtdept.getSelectedItem().toString().equals("")
            || txtcourse.getSelectedItem().toString().equals("")){
    
     return true;
    
    }
    else 
        return false;
    
    }
 public void DBConnection(){
     
 
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addLecturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
     public void faculties()
    {       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
            ps = conn.prepareStatement("select * from faculty");
            rs = ps.executeQuery();
              
            txtdept.removeAllItems();
              
            while(rs.next()) {
                txtdept.addItem(rs.getString(2));
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void courses()
    {       
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UMSIS;create=true;user=app;password=app");
            ps = conn.prepareStatement("select * from course");
            rs = ps.executeQuery();
              
            txtcourse.removeAllItems();
              
            while(rs.next()) {
                txtcourse.addItem(rs.getString(2));
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registation.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
   
        public void table_load(){
        
        try {
            ps = conn.prepareStatement("SELECT * FROM LECTURER");
            ResultSet rs = ps.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            int c;
            c = rd.getColumnCount();
            df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
        
                Vector v2 = new Vector();
                
                for(int i =0;i<=c;i++){
                //ID,LECTNAME,DOB,COURSEASSIGNED,DEPARTMENT,STATUS
                v2.add(rs.getString("ID"));
                v2.add(rs.getString("LECTNAME"));
                v2.add(rs.getString("STATUS"));
                v2.add(rs.getString("DOB"));
                v2.add(rs.getString("COURSEASSIGNED"));
                v2.add(rs.getString("DEPARTMENT"));
                
                }
                df.addRow(v2);
        
        }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(addLecturer.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtstatus = new javax.swing.JTextField();
        txtdob = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        txtcourse = new javax.swing.JComboBox<>();
        txtdept = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LECTURER MANAGEMENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(502, 502, 502))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("EMPLOYEE ID:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("STATUS:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BOD:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("COURSE ASSIGNED:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DEPARTMENT:");

        btnAdd.setBackground(new java.awt.Color(0, 255, 255));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(255, 153, 51));
        btnedit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnedit.setForeground(new java.awt.Color(255, 255, 255));
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(255, 0, 51));
        btndelete.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(0, 0, 0));
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("CANCEL");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdob, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdept, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "LECTNAME", "STATUS", "DOB", "COURSEASSIGNED", "DEPARTMENT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addGap(0, 82, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
            if(verifySecond())
            
            {
            
            String tname = txtname.getText().toUpperCase();
            String id = txtid.getText().toUpperCase();
            String status = txtstatus.getText().toUpperCase();
            String dob = txtdob.getText().toUpperCase();
            String courseAssigned = txtcourse.getSelectedItem().toString();
            String depart = txtdept.getSelectedItem().toString();
             
      
            
           
        try {
            ps = conn.prepareStatement("INSERT INTO LECTURER(ID,LECTNAME,DOB,COURSEASSIGNED,DEPARTMENT,STATUS) VALUES(?,?,?,?,?,?)");
            ps.setInt(1,Integer.parseInt(id));
            ps.setString(2,tname);
             ps.setString(3, dob);  
            ps.setString(4, courseAssigned);
            ps.setString(5, depart);
            ps.setString(6, status);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"LECTURER ADDED!");
            
            txtname.setText("");
            txtid.setText("");
            txtstatus.setText("");
            txtdob.setText("");
            txtcourse.setSelectedIndex(-1);
            txtdept.setSelectedIndex(-1);
            txtname.requestFocus();
             table_load();
            
        } catch (SQLException ex) {
            Logger.getLogger(addLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        //ID,LECTNAME,DOB,COURSEASSIGNED,DEPARTMENT,STATUS
        
        df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow();
        jTable1.setSelectionBackground(Color.red);
        txtid.setText(df.getValueAt(selected,0).toString());
        txtname.setText(df.getValueAt(selected,1).toString());
        //int id = Integer.parseInt(df.getValueAt(selected, 2).toString());
        txtstatus.setText(df.getValueAt(selected,2).toString());
        txtdob.setText(df.getValueAt(selected,3).toString());
        txtcourse.setSelectedItem(df.getValueAt(selected,4).toString());
        txtdept.setSelectedItem(df.getValueAt(selected,5).toString());
        
        btnAdd.setEnabled(false);
        btnedit.setEnabled(true);
        btndelete.setEnabled(true);
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        
         df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow();
        
            String  id = df.getValueAt(selected, 0).toString();
            String tname = txtname.getText();
          //  String empid = txtid.getText();
            String status = txtstatus.getText();
            String dob = txtdob.getText();
            String courseAssigned = txtcourse.getSelectedItem().toString();
            String depart = txtdept.getSelectedItem().toString();
            
        try {
            ps = conn.prepareStatement("UPDATE LECTURER SET LECTNAME = ?,DOB = ?,COURSEASSIGNED = ?,DEPARTMENT = ?,STATUS = ? WHERE ID =?");
            
            
            ps.setString(1,tname);
             ps.setString(2, dob);  
            ps.setString(3, courseAssigned);
            ps.setString(4, depart);
            ps.setString(5, status);
            ps.setString(6,id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"LECTURER UPDATED!");
            
            txtname.setText("");
            txtid.setText("");
            txtstatus.setText("");
            txtdob.setText("");
            txtcourse.setSelectedIndex(-1);
            txtdept.setSelectedIndex(-1);
            txtname.requestFocus();
            
            btnAdd.setEnabled(true);
            btnedit.setEnabled(false);
            btndelete.setEnabled(false);
             table_load();
             
            
        } catch (SQLException ex) {
            Logger.getLogger(addLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        
                 df = (DefaultTableModel)jTable1.getModel();
                 int selected = jTable1.getSelectedRow();
                 int  id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        try {
            ps = conn.prepareStatement("DELETE FROM LECTURER WHERE ID = ?");
            
          
            ps.setInt(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"LECTURER DELETED!");
            
            txtname.setText("");
            txtid.setText("");
            txtstatus.setText("");
            txtdob.setText("");
            txtcourse.setSelectedIndex(-1);
            txtdept.setSelectedIndex(-1);
            txtname.requestFocus();
            
            btnAdd.setEnabled(true);
            btnedit.setEnabled(false);
            btndelete.setEnabled(false);
             table_load();
             
            
        } catch (SQLException ex) {
            Logger.getLogger(addLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        
        
        this.setVisible(false);
        
    }//GEN-LAST:event_btncancelActionPerformed


    
    public boolean verifySecond(){
    
        
    if(txtname.getText().isEmpty()){
     JOptionPane.showMessageDialog(this,"NAME CANNOT BE EMPTY!");
     
        return false;
    }
    else if(txtid.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"EMPLOYEE ID CANNOT BE EMPTY!");
        
        return false;
    }
    else if (txtstatus.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"STATUS CANNOT BE EMPTY!");
        
        return false;
    
    }
      else if (txtdob.getText().isEmpty()){
          JOptionPane.showMessageDialog(this,"DATE OF BIRTH CANNOT BE EMPTY!");
          
          return false;
    
    }
    
      else if (txtstatus.getText().isEmpty()){
          JOptionPane.showMessageDialog(this,"STATUS CANNOT BE EMPTY!");
          
          return false;
    
    }
    
      else if(txtcourse.getSelectedIndex()== -1)
      
      {
          JOptionPane.showMessageDialog(this,"PLEASE SELECT COURSE!");
          
          return false;
      }
    
      else if(txtdept.getSelectedIndex()== -1)
              
          {
              JOptionPane.showMessageDialog(this,"PLEASE SELECT DEPARTMENT!");
              
              return false;
              
          }
    
    return true;
          
      
    }
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
            java.util.logging.Logger.getLogger(addLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addLecturer().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtcourse;
    private javax.swing.JComboBox<String> txtdept;
    private javax.swing.JTextField txtdob;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtstatus;
    // End of variables declaration//GEN-END:variables
}
