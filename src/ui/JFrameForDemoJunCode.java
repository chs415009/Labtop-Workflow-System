/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import Business.Enterprise.*;
import Business.Organization.Organization;
import Business.Organization.Tech.*;
import Jun.ui.Tech.ProductManager.ProductManagerWorkArea;
import Jun.ui.Tech.RD.RDWorkArea;
import java.awt.CardLayout;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class JFrameForDemoJunCode extends javax.swing.JFrame {

    /**
     * Creates new form JFrameForDemoJunCode
     */// 
    
    //這個架構沒做任何userAccount跟role 只有建立Organiation然後把workRequest存進去
    Enterprise techproductE = new TechnologyProductEnterprise("Tech Corp");
    Organization ProductManagerOrganization = new ProductManagementOrganization(techproductE);
    Organization RDOrganization = new ResearchAndDevelopmentOrganization(techproductE);
   
    ArrayList<Organization> Organizations ;
    public JFrameForDemoJunCode() {
        initComponents();
        this.setSize(1000, 700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnLoginPM = new javax.swing.JButton();
        LoginAsRD = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(100);

        btnLoginPM.setText("LoginAsPM");
        btnLoginPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginPMActionPerformed(evt);
            }
        });

        LoginAsRD.setText("LoginAsRD");
        LoginAsRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginAsRDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoginPM)
                    .addComponent(LoginAsRD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnLoginPM)
                .addGap(45, 45, 45)
                .addComponent(LoginAsRD)
                .addContainerGap(474, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        container.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(container);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginPMActionPerformed
        // TODO add your handling code here:
        Organization LoginOrganization;
        LoginOrganization = ProductManagerOrganization;
        ProductManagerWorkArea pmwa = new ProductManagerWorkArea(container,ProductManagerOrganization,RDOrganization);
        container.add("ProductManagerWorkArea", pmwa);
        CardLayout layout=(CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnLoginPMActionPerformed

    private void LoginAsRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginAsRDActionPerformed
        // TODO add your handling code here:
        Organization LoginOrganization;
        LoginOrganization = RDOrganization;
        RDWorkArea rdwa = new RDWorkArea(container,RDOrganization);
        container.add("ProductManagerWorkArea", rdwa);
        CardLayout layout=(CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_LoginAsRDActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameForDemoJunCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameForDemoJunCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameForDemoJunCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameForDemoJunCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameForDemoJunCode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginAsRD;
    private javax.swing.JButton btnLoginPM;
    private javax.swing.JPanel container;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}