/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Delivery.DeliveryManager;


import ui.Manufacturing.ManufacturingManager.*;
import ui.Tech.ProductManager.*;
import Business.Organization.Organization;
import Business.Product.Product;
import Business.WorkRequest.DeliverWorkRequest;
import Business.WorkRequest.DevelopmentWorkRequest;
import Business.WorkRequest.MarketingWorkRequest;
import Business.WorkRequest.PurchaseWorkRequest;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ViewWorkReqeustSummary extends javax.swing.JPanel {

    /**
     * Creates new form CreateNewWorkRequest
     */
    JPanel container;
    Organization CurrentOrganization;
    Organization RDOrganization;
    WorkRequest workRequest;
    DevelopmentWorkRequest developmentWorkReqeust;
    PurchaseWorkRequest purchaseWorkRequest;
    DeliverWorkRequest deliverWorkRequest;
    MarketingWorkRequest marketingWorkRequest;
    
    public ViewWorkReqeustSummary(JPanel container, WorkRequest workRequest) {
        initComponents();
        this.container = container;
        this.workRequest=workRequest;
        this.developmentWorkReqeust=workRequest.getDevelopmentWorkRequest();
        this.purchaseWorkRequest=workRequest.getPurchaseWorkRequest();
        this.deliverWorkRequest=workRequest.getDeliverWorkRequest();
        this.marketingWorkRequest=workRequest.getMarketingWorkRequest();
        populateDevWorkRequestTable();
        populatePurWorkRequestTable();
        populateDeliverWorkRequestTable();
        populateMarketingWorkRequestTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDevWorkRequest = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDelWorkRequest = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPurWorkRequest = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMktWorkRequest = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 0, 0));
        setPreferredSize(new java.awt.Dimension(800, 500));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setText("Development WorkRequest Summary");

        tblDevWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Dev Status", " Verified"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDevWorkRequest);

        tblDelWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "OrderName", "Shipping Status", "ShipFrom", "ShipTo", "Quantity", "ShippingPrice", "Signed", "Ship Comfirmed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDelWorkRequest);

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel14.setText("Purchase WorkRequest Summary");

        tblPurWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "OrderName", "Purchase Status", "UnitManufacturingPrice", "Order Signed", "TargetQuantity", "CurrentQuantity", "ProductionStatus", "Verified"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblPurWorkRequest);

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel15.setText("Delivery WorkRequest Summary");

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel16.setText("Marketing WorkRequest Summary");

        tblMktWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Plan Name", "Marketing Plan Status", "Budget", "Signed", "AdsExecution Status", "AdsPerformance", "Used Budget", "Verified"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblMktWorkRequest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
//        Component[] componentArray = container.getComponents();
//        Component component = componentArray[componentArray.length -1];
//        ProductManagerWorkArea  productManagerWorkArea = ( ProductManagerWorkArea) component;
//        productManagerWorkArea.populateRequestTable();
       
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblDelWorkRequest;
    private javax.swing.JTable tblDevWorkRequest;
    private javax.swing.JTable tblMktWorkRequest;
    private javax.swing.JTable tblPurWorkRequest;
    // End of variables declaration//GEN-END:variables

    private void populateDevWorkRequestTable() {
        
       DefaultTableModel model = (DefaultTableModel) tblDevWorkRequest.getModel();
        model.setRowCount(0);
            Object[] row = new Object[3];
            //if purchaseWorkRequest isn't created yet, reuturn
            if(developmentWorkReqeust==null){
                return;
            }
            else{ 
            row[0]=developmentWorkReqeust.getProduct();
            row[1]=developmentWorkReqeust.getdevStatus();
            row[2]=developmentWorkReqeust.getVerified();
          
            for(int i=0;i<2;i++){
                if(row[i]==null){// if data is null
                    switch(i){
                    case 2:
                        row[i] = false;
                        break;
                    default:
                        row[i]="N/A";
                                    }   
                }
            }
           model.addRow(row);
            }
    }
    private void populatePurWorkRequestTable() {
        
       DefaultTableModel model = (DefaultTableModel) tblPurWorkRequest.getModel();
        model.setRowCount(0);
            Object[] row = new Object[8];
            //if purchaseWorkRequest isn't created yet, reuturn
            if(purchaseWorkRequest==null){
                return;
            }
            else{ row[0]=purchaseWorkRequest.getOrderName();
            row[1]=purchaseWorkRequest.getPerchaseStatus();
            row[2]=purchaseWorkRequest.getProductPerPrice();
            row[3]=purchaseWorkRequest.getSigned();
            row[4]=purchaseWorkRequest.getTargetQuantity();
            row[5]=purchaseWorkRequest.getCurrentManufacturedQuantity();
            row[6]=purchaseWorkRequest.getProductionStatus();
            row[7]=purchaseWorkRequest.getVerified();
            for(int i=0;i<7;i++){
                if(row[i]==null){// if data is null
                    switch(i){
                        
                    case 3:
                        row[i] = false;
                        break;
                    case 7:
                        row[i]=false;
                        break;
                    default:
                        row[i]="N/A";
                                    }   
                }
            }
           model.addRow(row);
            }
    }
     private void populateDeliverWorkRequestTable() {
        
       DefaultTableModel model = (DefaultTableModel) tblDelWorkRequest.getModel();
        model.setRowCount(0);
            Object[] row = new Object[8];
            //if purchaseWorkRequest isn't created yet, reuturn
            if(deliverWorkRequest==null){
                return;
            }
            else{ row[0]=deliverWorkRequest.getOrderName();
            row[1]=deliverWorkRequest.getShippingStatus();
            row[2]=deliverWorkRequest.getShipFromAddress();
            row[3]=deliverWorkRequest.getShipToAddress();
            row[4]=deliverWorkRequest.getShippingQuantity();
            row[5]=deliverWorkRequest.getShippingPrice();
            row[6]=deliverWorkRequest.getSigned();
            row[7]=deliverWorkRequest.getShipConfirmed();
            for(int i=0;i<7;i++){
                if(row[i]==null){// if data is null
                    switch(i){
                    case 6:
                        row[i] = false;
                        break;
                    case 7:
                        row[i]=false;
                        break;
                    default:
                        row[i]="N/A";
                                    }   
                }
            }
           model.addRow(row);
            }
    }
      private void populateMarketingWorkRequestTable() {
        
       DefaultTableModel model = (DefaultTableModel) tblMktWorkRequest.getModel();
        model.setRowCount(0);
            Object[] row = new Object[8];
            //if purchaseWorkRequest isn't created yet, reuturn
            if(marketingWorkRequest==null){
                return;
            }
            else{ row[0]=marketingWorkRequest.getMarketingPlanName();
            row[1]=marketingWorkRequest.getMarketingPlanStatus();
            row[2]=marketingWorkRequest.getBudget();
            row[3]=marketingWorkRequest.getSigned();
            row[4]=marketingWorkRequest.getAdsExecutionStatus();
            row[5]=marketingWorkRequest.getAdsPerformance();
            row[6]=marketingWorkRequest.getUsedBudget();
            row[7]=marketingWorkRequest.getVerified();
            for(int i=0;i<7;i++){
                if(row[i]==null){// if data is null
                    switch(i){
                    case 3:
                        row[i] = false;
                        break;
                    case 7:
                        row[i]=false;
                        break;
                    default:
                        row[i]="N/A";
                                    }   
                }
            }
           model.addRow(row);
            }
    }
}
