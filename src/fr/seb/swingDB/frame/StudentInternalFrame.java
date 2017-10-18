
package fr.seb.swingDB.frame;

import fr.seb.database.utils.DatabaseConnection;
import fr.seb.swingDB.dao.StudentDAO;
import fr.seb.swingDB.entity.Student;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class StudentInternalFrame extends javax.swing.JInternalFrame {

    private Student std ;
    private StudentDAO dao;
    private Connection cn;
    
    public StudentInternalFrame() throws SQLException {
        initComponents();
        
        setVisible(true);
        setEnabled(true);
        setLocation(50, 50);
        
        std = new Student();
        dao = new StudentDAO(DatabaseConnection.getInstance());
        
        jSexF.setActionCommand("F");
        jSexM.setActionCommand("M");
        
        initList();
    }

    private void initList() throws SQLException{
        
        DefaultListModel modelList = new DefaultListModel();
        
        List<Student> data = dao.findAll().getAll();
        
        for(Student s:data){
            modelList.addElement(s);
        }
        jList.setModel(modelList);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabelStudent = new javax.swing.JLabel();
        jPrenom = new javax.swing.JTextField();
        jNom = new javax.swing.JTextField();
        jAge = new javax.swing.JTextField();
        jSexF = new javax.swing.JRadioButton();
        jSexM = new javax.swing.JRadioButton();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelAge = new javax.swing.JLabel();
        jLabelSexe = new javax.swing.JLabel();
        jSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabelStudent.setText("ETUDIANT");
        jLabelStudent.setName("jLabelStudent"); // NOI18N

        buttonGroup.add(jSexF);
        jSexF.setText("F");

        buttonGroup.add(jSexM);
        jSexM.setText("M");

        jLabelPrenom.setText("Prenom");

        jLabelNom.setText("Nom");

        jLabelAge.setText("Age");

        jLabelSexe.setText("Sexe");

        jSave.setText("SAVE");
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrenom)
                    .addComponent(jLabelNom)
                    .addComponent(jLabelAge)
                    .addComponent(jLabelSexe))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSexF)
                                .addComponent(jLabelStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                            .addComponent(jSexM))
                        .addComponent(jPrenom)
                        .addComponent(jNom)
                        .addComponent(jAge))
                    .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrenom))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNom))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAge))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSexF)
                            .addComponent(jSexM)
                            .addComponent(jLabelSexe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jSave)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveActionPerformed
       
            
            
         try {
            std.setPrenom(jPrenom.getText());
            std.setNom(jNom.getText());
            
            std.setAge(checkNumValue(jAge.getText()));
            std.setSex(buttonGroup.getSelection().getActionCommand().charAt(0));
            
            System.out.println(std.getPrenom()+std.getNom()+std.getAge()+std.getSex());
            
            int s = dao.save(std);
            initList();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }//GEN-LAST:event_jSaveActionPerformed

    private int checkNumValue(String str){
        boolean ok = true;
        int rtn = 0;
      try  
      {  
        int val = Integer.parseInt(str);  
      }  
      catch(NumberFormatException e)  
      {  
        ok = false;  
      }  
      if (ok){
          rtn = (int)Integer.parseInt(str);
      } 
      return rtn;
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextField jAge;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelSexe;
    private javax.swing.JLabel jLabelStudent;
    private javax.swing.JList<String> jList;
    private javax.swing.JTextField jNom;
    private javax.swing.JTextField jPrenom;
    private javax.swing.JButton jSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jSexF;
    private javax.swing.JRadioButton jSexM;
    // End of variables declaration//GEN-END:variables
}
