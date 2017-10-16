
package fr.seb.swingDB.frame;

import fr.seb.database.utils.DatabaseConnection;
import fr.seb.database.utils.DatabaseTools;
import fr.seb.swingDB.entity.User;
import java.awt.Color;
import java.sql.*;
import swingdb.AppContext;


public class LoginFrame extends javax.swing.JFrame {

    
    public LoginFrame() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(Color.CYAN);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelIdentifiant = new javax.swing.JLabel();
        jLogin = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jConnection = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jLabelIdentifiant.setText("Identifiant");

        jLogin.setText("jmpourchel@hotmail.com");
        jLogin.setBorder(null);
        jLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLoginFocusGained(evt);
            }
        });

        jLabelPassword.setBackground(new java.awt.Color(0, 153, 153));
        jLabelPassword.setText("Password");

        jPassword.setText("123");
        jPassword.setBorder(null);

        jConnection.setText("Connexion");
        jConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConnectionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Kartika", 1, 24)); // NOI18N
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLogin)
                            .addComponent(jLabelIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jLabelIdentifiant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConnectionActionPerformed
        //recupérer la saisie
        String login = jLogin.getText();
        String password = String.valueOf (jPassword.getPassword());
        
        //validation de la donnée
        boolean val = false;
        if (login.equals("") ||  login.length()<3 || login.indexOf("@")<1){
            jLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new Color(255, 20, 20), new Color(255, 20, 20)));
            
        }else{
            jLogin.setBackground (Color.WHITE);
            val = true;
        }
        if (password.equals("") || password.length()<3  ){
            jPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder(new Color(255, 20, 20), new Color(255, 20, 20)));
            
        }
        else{
            jPassword.setBackground (Color.WHITE);
            val = true;
        }
        
        
        if(val==true){
            //connection    DatabaseConnection.getInstance()
            try {
                Connection cn = DatabaseConnection.getInstance();
                String sql = "SELECT * FROM utilisateurs WHERE email = ? AND mot_de_passe = ?";
                
                PreparedStatement state = cn.prepareStatement(sql);
                state.setString(1,login);
                state.setString(2,DatabaseTools.sha1Encode(password));
                
               
                ResultSet rst = state.executeQuery();
                
                if(rst.next()){
                    String message = "informations correctes"; 
                    jLabel2.setText(message);
                    
                    User user = new User(); 
                    
                    //hydratation de l'objet
                    user.setId(rst.getInt("id"))
                        .setName(rst.getString("nom"))
                        .setFirstName(rst.getString("prenom"))
                        .setRole(rst.getString("role"));
                    
                    //stockage de user dans ApContext pour utilisation globale
                    //accessible partout dans l'appli
                    AppContext.setCurrentUser(user);
                    
                    //ouverture fenetre mainframe
                    MainFrame app = new MainFrame();
                    app.setVisible(true);
                    app.setLocationRelativeTo(null);
                    
                    //fermer login frame
                    this.dispose();
                        
                }else{
                    String message = "informations incorrectes"; 
                    jLabel2.setText(message);
                }
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
  
        }
    }//GEN-LAST:event_jConnectionActionPerformed

    private void jLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLoginFocusGained
        jLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new Color(200, 200, 200), new Color(200, 200, 200)));
    }//GEN-LAST:event_jLoginFocusGained

    
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jConnection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIdentifiant;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JTextField jLogin;
    private javax.swing.JPasswordField jPassword;
    // End of variables declaration//GEN-END:variables
}
