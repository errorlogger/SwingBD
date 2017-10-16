
package fr.seb.swingDB.frame;

import fr.seb.database.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class AuthorInternalFrame extends javax.swing.JInternalFrame {

    private Connection cn;
    public AuthorInternalFrame() {
        initComponents();
        initTable();
        jAdd.setEnabled(false);
        jDelete.setEnabled(false);
        jUpdate.setEnabled(false);
    }

    public void initTable(){
        //recuperatio du model de la table
        
        DefaultTableModel modelTable = (DefaultTableModel) AuthorTable.getModel();
        modelTable.setRowCount(0);
        //modelTable.setColumnCount(0);
        
        //recupeation desz donnees depuis la base
        String sql = "SELECT * FROM auteurs";
        try {
            
            cn = DatabaseConnection.getInstance();
            Statement state = cn.createStatement();
            ResultSet rst = state.executeQuery(sql);
            
            //creation d'n tableau d'objet (heteroclites) qui vont représenter une ligne de la table
            Object[] tableRow;
            
            //boucle sur le resultSet
            while(rst.next()){
                //constitution du tableau de données
                tableRow = new Object[3];
                tableRow[0] = rst.getObject("id");
                tableRow[1] = rst.getObject("prenom");
                tableRow[2] = rst.getObject("nom");
                
                //ajout des données dans un nouvelle ligne du model mettant à jour la jtable d'origine
                modelTable.addRow(tableRow);
            }
            rst.close();
            state.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(AuthorInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        AuthorTable = new javax.swing.JTable();
        idField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jAdd = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jUpdate = new javax.swing.JButton();
        Message = new javax.swing.JLabel();
        jRAZ = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion des Auteurs");

        AuthorTable.setAutoCreateRowSorter(true);
        AuthorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Prenom", "Nom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AuthorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AuthorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AuthorTable);
        AuthorTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (AuthorTable.getColumnModel().getColumnCount() > 0) {
            AuthorTable.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        idField.setEditable(false);
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Prenom");

        jLabel3.setText("Nom");

        firstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstNameFieldKeyPressed(evt);
            }
        });

        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameFieldKeyPressed(evt);
            }
        });

        jAdd.setText("Add");
        jAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddActionPerformed(evt);
            }
        });

        jDelete.setText("Delete");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jUpdate.setText("Update");
        jUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateActionPerformed(evt);
            }
        });

        jRAZ.setText("RAZ");
        jRAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRAZActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(firstNameField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRAZ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDelete))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRAZ)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void AuthorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AuthorTableMouseClicked
        //ligne sélectionnée
        int selectedRow = AuthorTable.getSelectedRow();
        
        selectedRow = AuthorTable.convertRowIndexToModel(selectedRow);
        //recup du model
        TableModel model = AuthorTable.getModel();
        //récup des données de la ligne
        String id = model.getValueAt(selectedRow, 0).toString();
        String prenom = model.getValueAt(selectedRow, 1).toString();
        String nom = model.getValueAt(selectedRow, 2).toString();
        //String nom = String.valueOf(model.getValueAt(selectedRow, 2)); si les données sont 'NULL'
        
        //isert des données dans les textfields
        idField.setText(id);
        firstNameField.setText(prenom);
        nameField.setText(nom);
        jDelete.setEnabled(true);
        
        
        if (!nameField.getText().equals("")){
            jAdd.setEnabled(true);
            jUpdate.setEnabled(true);
        }else{
            jAdd.setEnabled(false);
            jUpdate.setEnabled(false);
        }
        Message.setText("");
    }//GEN-LAST:event_AuthorTableMouseClicked

    private void jAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddActionPerformed
        
            String sql = "INSERT INTO auteurs (prenom,nom) VALUES(?,?)";

            try {
                PreparedStatement state = cn.prepareStatement(sql);
                state.setString(1, firstNameField.getText());
                state.setString(2, nameField.getText());

                int ok = state.executeUpdate();

                if (ok > 0) {
                    Message.setText("ajout OK!");
                } else {
                    Message.setText("ajout KO!");
                }
                state.close();
                initTable();

            } catch (SQLException ex) {
                Logger.getLogger(AuthorInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jAddActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
         String sql ="DELETE FROM auteurs WHERE id = ?";
        try {
            PreparedStatement state = cn.prepareStatement(sql);
            state.setString(1,idField.getText());
            
            
            int ok = state.executeUpdate();
            
            if (ok>0)Message.setText("Suppression OK!");
            else Message.setText("Supression KO!");
            state.close();
            initTable();
            
        } catch (SQLException ex) {
            Logger.getLogger(AuthorInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDeleteActionPerformed

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyPressed
        if (nameField.getText().equals("")) {
            
            jAdd.setEnabled(false);
            jUpdate.setEnabled(false);
            jDelete.setEnabled(false);
        }else{
            jAdd.setEnabled(true);
            jUpdate.setEnabled(true);
            jDelete.setEnabled(true);
            Message.setText("");
        }
    }//GEN-LAST:event_nameFieldKeyPressed

    private void jUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateActionPerformed
            String sql ="UPDATE auteurs SET prenom = ?, nom = ? WHERE id =?";
        try {
            PreparedStatement state = cn.prepareStatement(sql);
            state.setString(1,firstNameField.getText());
            state.setString(2,nameField.getText());
            state.setString(3,idField.getText());
            
            
            int ok = state.executeUpdate();
            
            if (ok>0)Message.setText("Modification OK!");
            else Message.setText("Modification KO!");
            state.close();
            initTable();
            
        } catch (SQLException ex) {
            Logger.getLogger(AuthorInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jUpdateActionPerformed

    private void firstNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameFieldKeyPressed
        if ( nameField.getText().length()==0) {
            
            jAdd.setEnabled(false);
        }else{
            jAdd.setEnabled(true);
            jUpdate.setEnabled(true);
            Message.setText("");
        }
    }//GEN-LAST:event_firstNameFieldKeyPressed

    private void jRAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRAZActionPerformed
        idField.setText("");
        nameField.setText("");
        firstNameField.setText("");
        jAdd.setEnabled(false);
        jUpdate.setEnabled(false);
        jDelete.setEnabled(false);
    }//GEN-LAST:event_jRAZActionPerformed

                                  

                                           

                        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AuthorTable;
    private javax.swing.JLabel Message;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jAdd;
    private javax.swing.JButton jDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jRAZ;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jUpdate;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
