/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Manufacturing.ManufacturingManager;


import ui.Tech.PurchaseManager.*;
import ui.Tech.ProductManager.*;
import Business.Organization.Organization;
import Business.Product.Product;
import Business.WorkRequest.DeliverWorkRequest;
import Business.WorkRequest.DevelopmentWorkRequest;
import Business.WorkRequest.PurchaseWorkRequest;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class CreateNewDeliveryWorkRequest extends javax.swing.JPanel {

    /**
     * Creates new form CreateNewWorkRequest
     */
    JPanel container;
    Organization CurrentOrganization;
    ArrayList<Organization> DeliveryManagerOrganizations;
    WorkRequest workRequest;
    public CreateNewDeliveryWorkRequest(JPanel container, Organization CurrentOrganization,ArrayList<Organization> DeliveryManagerOrganizations,WorkRequest request) {
        initComponents();
        this.container = container;
        this.CurrentOrganization=CurrentOrganization;
        this.workRequest =request;
        
        this.DeliveryManagerOrganizations=DeliveryManagerOrganizations;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Quantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtOrderName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lbShipFrom = new javax.swing.JLabel();
        txtShipFrom = new javax.swing.JTextField();
        lbShipTo = new javax.swing.JLabel();
        txtShipTo = new javax.swing.JTextField();
        Create = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(800, 500));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("Create  New Delivery WorkRequest");

        Quantity.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        Quantity.setText("Quantity");

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel12.setText("OrderName");

        lbShipFrom.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        lbShipFrom.setText("Ship From");

        lbShipTo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        lbShipTo.setText("Ship To");

        Create.setText("Create Order");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbShipTo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtShipTo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbShipFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrderName)
                                    .addComponent(txtShipFrom))))
                        .addGap(537, 537, 537))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Create, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbShipFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtShipFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbShipTo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtShipTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addComponent(Create)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
       container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length -1];
        ManufacturingManagerWorkArea  manufacturingManagerWorkArea = ( ManufacturingManagerWorkArea) component;
        manufacturingManagerWorkArea.populateRequestTable();

        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        // TODO add your handling code here:
         String OrderName = txtOrderName.getText();  // 
         String ShipFrom =txtShipFrom.getText();
         String ShipTo = txtShipTo.getText();
        // PurchaseRequest detail;
        String QuantityText = txtQuantity.getText();
       // input valid check
        if (OrderName.isEmpty()||ShipFrom.isEmpty()||ShipTo.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Error: Please fill in all required fields.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;}
        // Parsing Integer and Double
        try {
            int Quantity = Integer.parseInt(QuantityText);  
            if(Quantity >workRequest.getPurchaseWorkRequest().getTargetQuantity()){
                JOptionPane.showMessageDialog(this, "Error: input is greater than Real quantity.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(workRequest.getPurchaseWorkRequest().getVerified()==true){
                  for(Organization organization:DeliveryManagerOrganizations){
                      if(isWorkRequestExist(organization,workRequest)==true){
                        JOptionPane.showMessageDialog(this, "This WorkRequest is already existed in DeliverManager Organization!","Warning",JOptionPane.WARNING_MESSAGE);
                        return; 
                }
                else{ 
                   organization.getWorkQueue().addWorkRequest(workRequest);
                    workRequest.setDeliverWorkRequest(new DeliverWorkRequest(workRequest.getProduct(),OrderName,ShipFrom,ShipTo,Quantity));
                    JOptionPane.showMessageDialog(this,
                      "A DeliverWorkRequest is added to WorkReqeust!\nWorkReqeust is passed to DeliverManagerOrganization.");
                }
                  }

            }else{
                JOptionPane.showMessageDialog(this, "The PurchaseWorkRequest is not verified!","Error",JOptionPane.WARNING_MESSAGE);
            return;}
            /////////////////////////////////////////////////////////
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Invalid number format.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_CreateActionPerformed
private boolean isWorkRequestExist(Organization Organization,WorkRequest CurrentRequest) {
        for(WorkRequest request : Organization.getWorkQueue().getWorkRequests()){
            if(CurrentRequest==request){
                return true;
                }
            }
            return false;
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create;
    private javax.swing.JLabel Quantity;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbShipFrom;
    private javax.swing.JLabel lbShipTo;
    private javax.swing.JTextField txtOrderName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtShipFrom;
    private javax.swing.JTextField txtShipTo;
    // End of variables declaration//GEN-END:variables

  
}
