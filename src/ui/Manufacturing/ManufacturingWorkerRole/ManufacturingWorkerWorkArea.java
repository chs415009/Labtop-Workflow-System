/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Manufacturing.ManufacturingWorkerRole;


import ui.Manufacturing.ManufacturingManager.*;
import ui.Tech.PurchaseManager.*;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseType;
import Business.Network.Network;
import ui.Tech.RD.*;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkFlowSystem;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ui.MainJFrame;
import ui.Tech.ProductManager.ViewDevWorkRequest;

/**
 *
 * @author User
 */
public class ManufacturingWorkerWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ProductManagerWorkArea
     */
    JPanel container;
    Organization CurrentOrganization;
   // ArrayList<Organization>  ProductionLineOrganizations;
    UserAccount  UserAccount;
    Network network;
    MainJFrame mainFrame;
    public ManufacturingWorkerWorkArea(JPanel container,UserAccount UserAccount,Network network,MainJFrame mainFrame) {
        initComponents();
        this.container = container;
        this.CurrentOrganization=UserAccount.getOrganization();
        this.network=network;
        this.mainFrame=mainFrame;
       // this.ProductionLineOrganizations = findProductionLineOrganizationInsystem();
       populateRequestTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPurDetail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequest = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(800, 500));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 153, 0));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("Manufacturing Worker Role WorkArea");

        btnPurDetail.setText("Report Production Progress");
        btnPurDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurDetailActionPerformed(evt);
            }
        });

        tblWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "WorkRequest", "Product", "Status", "Purchase Status", "Target Quantity", "Current Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkRequest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPurDetail)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPurDetail)
                .addContainerGap(179, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        mainFrame.showLoginPanel();
        javax.swing.JOptionPane.showMessageDialog(this, "You have been successfully logged out.");
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnPurDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurDetailActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblWorkRequest.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a WorkRequest first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest) tblWorkRequest.getValueAt(selectedRowIndex, 0);

         ReportProductionWorkRequest reportProductionWorkRequest = new  ReportProductionWorkRequest(container, CurrentOrganization,request);
        container.add("ReportProductionWorkRequest", reportProductionWorkRequest);
        CardLayout layout=(CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnPurDetailActionPerformed

    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblWorkRequest.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request :CurrentOrganization.getWorkQueue().getWorkRequests()){
            Object[] row = new Object[6];
            row[0] = request ;
            row[1] = request.getProduct();
            row[2] = request.getStatus();
            ////////////// Make sure the WorkRequest is correct! (Dev, purchase, Deliver, Marketing)
            if(request.getPurchaseWorkRequest()==null){
             row[3] = "Not Started Yet";
            }else{
            row[3] = request.getPurchaseWorkRequest().getPerchaseStatus();
            row[4] = request.getPurchaseWorkRequest().getTargetQuantity();
            row[5] = request.getPurchaseWorkRequest().getCurrentManufacturedQuantity();
            }
            model.addRow(row);
        }
    }
//     private  ArrayList<Organization> findProductionLineOrganizationInsystem() {
//        //遍歷所有network中的enterPrise 直到找到type 符合
//        //再搜尋當中Organiation 名稱符合的
//       ArrayList<Organization> Organizations = new ArrayList<>();
//           for(Enterprise enterprise : network.getEnterpriseList()){
//               if(enterprise.getType()==EnterpriseType.MANUFACTURING){
//                   for(Organization organization : enterprise.getOrganizationDirectory()){
//                       if(organization.getName()=="Production Line"){
//                          Organizations.add(organization);
//                       }
//                   }
//               }
//           }
//       
//        return Organizations;// return null if doesn't found
//    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPurDetail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWorkRequest;
    // End of variables declaration//GEN-END:variables

   
}
