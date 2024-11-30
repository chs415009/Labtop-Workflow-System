/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Delivery.DeliveryWorkerRole;

import Business.WorkRequest.DeliverWorkRequest;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yuanchanglee
 */
public class DeliveryWorkerWorkArea extends javax.swing.JPanel {

    private JPanel container; // 父級容器
    private javax.swing.table.DefaultTableModel model;
    
    /**
     * Creates new form DeliveryWorkerWorkArea
     */
    public DeliveryWorkerWorkArea(JPanel container) {
        initComponents();
        this.container = container;
        populateTable();
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
        btnViewDetails = new javax.swing.JButton();

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setText("Delivery Worker Role WorkArea");

        tblWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "WorkRequest", "Product", "OrderName", "Current Status", "ShipFrom", "ShipTo", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkRequest);

        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
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
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnViewDetails)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnViewDetails)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void populateTable() {
        model = (javax.swing.table.DefaultTableModel) tblWorkRequest.getModel();
        model.setRowCount(0); // 清空表格

        // 示例假數據（你應該從實際的工作流中獲取）
        for (WorkRequest request : getDeliveryWorkRequests()) {
            DeliverWorkRequest deliverRequest = request.getDeliverWorkRequest();
            if (deliverRequest != null) {
                Object[] row = new Object[7];
                row[0] = request; // WorkRequest Object
                row[1] = request.getProduct().getName(); // Product Name
                row[2] = deliverRequest.getOrderName(); // Order Name
                row[3] = deliverRequest.getShippingStatus(); // Current Status
                row[4] = deliverRequest.getShipFromAddress(); // Ship From
                row[5] = deliverRequest.getShipToAddress(); // Ship To
                row[6] = deliverRequest.getShippingQuantity(); // Quantity
                model.addRow(row);
            }
        }
    }
    
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        // 登出並返回主頁面
        JOptionPane.showMessageDialog(this, "You have been successfully logged out.");
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblWorkRequest.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a WorkRequest first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest request = (WorkRequest) tblWorkRequest.getValueAt(selectedRowIndex, 0);

        if (request.getDeliverWorkRequest() != null) {
            DeliverWorkRequest deliverRequest = request.getDeliverWorkRequest();
            ShippingStatusUpdatePanel updatePanel = new ShippingStatusUpdatePanel(container, deliverRequest);
            container.add("DeliveryStatusUpdatePanel", updatePanel);
            CardLayout layout = (CardLayout) container.getLayout();
            layout.next(container);
        } else {
            JOptionPane.showMessageDialog(this, "This WorkRequest does not contain a Delivery Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWorkRequest;
    // End of variables declaration//GEN-END:variables
}
