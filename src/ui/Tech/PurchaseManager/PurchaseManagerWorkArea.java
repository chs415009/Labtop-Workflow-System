/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Tech.PurchaseManager;


import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseType;
import Business.Network.Network;
import ui.Tech.RD.*;
import Business.Organization.Organization;
import Business.Product.Product;
import Business.UserAccount.UserAccount;
import Business.WorkFlowSystem;
import Business.WorkRequest.DevelopmentWorkRequest;
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
public class PurchaseManagerWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ProductManagerWorkArea
     */
    JPanel container;
    Organization CurrentOrganization;
    ArrayList<Organization> ManufacturingManagerOrganizations;
    UserAccount  UserAccount;
    Network network;
    MainJFrame mainFrame;
    public PurchaseManagerWorkArea(JPanel container,UserAccount UserAccount,Network network,MainJFrame mainFrame) {
        initComponents();
        this.container = container;
        this.CurrentOrganization=UserAccount.getOrganization();
        this.network = network;
        this.mainFrame=mainFrame;
        this. ManufacturingManagerOrganizations = findManufacturingManagerOrganizationInsystem();
        //populateDemoWorkRequest();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequest = new javax.swing.JTable();
        btnCreatePurWorkRequest = new javax.swing.JButton();
        btnPurProgress = new javax.swing.JButton();
        btnWorkSummary = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));
        setPreferredSize(new java.awt.Dimension(800, 500));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("Purchaser Manager Role WorkArea");

        tblWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "WorkRequest", "Product", "Status", "Purchase Status", "Order Signed", "Verified"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
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

        btnCreatePurWorkRequest.setText("Start a new Purchase WorkReqeust");
        btnCreatePurWorkRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePurWorkRequestActionPerformed(evt);
            }
        });

        btnPurProgress.setText("View Purchase Progress");
        btnPurProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurProgressActionPerformed(evt);
            }
        });

        btnWorkSummary.setText("View WorkReqeust Summary");
        btnWorkSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkSummaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreatePurWorkRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPurProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btnWorkSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreatePurWorkRequest)
                    .addComponent(btnPurProgress)
                    .addComponent(btnWorkSummary))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreatePurWorkRequest, btnPurProgress, btnWorkSummary});

    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        mainFrame.showLoginPanel();
        javax.swing.JOptionPane.showMessageDialog(this, "You have been successfully logged out.");
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCreatePurWorkRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePurWorkRequestActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblWorkRequest.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Pls select a WorkRequest first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest) tblWorkRequest.getValueAt(selectedRowIndex, 0); 
        
        CreateNewPurchaseWorkRequest cnpwr = new CreateNewPurchaseWorkRequest(container, CurrentOrganization,ManufacturingManagerOrganizations,request);
        container.add("CreateNewPurchaseWorkRequest", cnpwr);
        CardLayout layout=(CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnCreatePurWorkRequestActionPerformed

    private void btnPurProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurProgressActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblWorkRequest.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a WorkRequest first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        WorkRequest request = (WorkRequest) tblWorkRequest.getValueAt(selectedRowIndex, 0);
        if(request.getPurchaseWorkRequest()==null){
            JOptionPane.showMessageDialog(this, "The selected WorkRequest doesn't have a PurchaseWorkReqeust yet.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ViewPurchaseWorkRequest viewPurchaseWorkRequest = new ViewPurchaseWorkRequest(container, CurrentOrganization,request);
        container.add("ViewPurchaseWorkRequest", viewPurchaseWorkRequest);
        CardLayout layout=(CardLayout)container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnPurProgressActionPerformed

    private void btnWorkSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkSummaryActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblWorkRequest.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a WorkRequest first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest) tblWorkRequest.getValueAt(selectedRowIndex, 0);

        ui.Manufacturing.ManufacturingManager.ViewWorkReqeustSummary viewWorkReqeustSummary = new ui.Manufacturing.ManufacturingManager.ViewWorkReqeustSummary(container, request);
        container.add("ViewWorkReqeustSummary", viewWorkReqeustSummary);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnWorkSummaryActionPerformed
    private void populateDemoWorkRequest() {
        
        Product demoProduct = new Product("demoProduct","demoDescription",10,15.3,16,256);
        WorkRequest demoRequest = new WorkRequest("demo",demoProduct);
        demoRequest.setDevelopmentWorkRequest(new DevelopmentWorkRequest(demoProduct));
        demoRequest.getDevelopmentWorkRequest().setVerified(true);
        CurrentOrganization.getWorkQueue().addWorkRequest(demoRequest);
    }
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
            row[4] = request.getPurchaseWorkRequest().getSigned();
            row[5] = request.getPurchaseWorkRequest().getVerified();
            }
            model.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePurWorkRequest;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPurProgress;
    private javax.swing.JButton btnWorkSummary;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWorkRequest;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Organization> findManufacturingManagerOrganizationInsystem() {
        //遍歷所有network中的enterPrise 直到找到type 符合
        //再搜尋當中Organiation 名稱符合的
         ArrayList<Organization> Organizations = new ArrayList<>();
           for(Enterprise enterprise : network.getEnterpriseList()){
               if(enterprise.getType()==EnterpriseType.MANUFACTURING){
                   for(Organization organization : enterprise.getOrganizationDirectory()){
                       if(organization.getName()=="Manufacturing Management"){
                           Organizations.add(organization);
                       }
                   }
               }
           }
       
        return  Organizations;// return null if doesn't found
    }
}
