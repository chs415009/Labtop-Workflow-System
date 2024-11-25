/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemAdminWorkAreaJPanel;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.WorkFlowSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yuanchanglee
 */
public class ManageEnterpriseJPanel extends javax.swing.JPanel {

    private JTable enterpriseTable;
    private JComboBox<Network> networkComboBox;
    private JComboBox<Enterprise.EnterpriseType> enterpriseTypeComboBox;
    private JTextField nameField;
    private JButton submitButton;
    private JPanel userProcessContainer;
    private WorkFlowSystem system;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseJPanel(JPanel userProcessContainer, WorkFlowSystem system) {
        this.userProcessContainer = userProcessContainer;
        this.system = system;

        customizeComponents();
        populateTable();
        populateComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   private void customizeComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#E8EEF1")); // 柔和藍灰色背景

        // ======= 上部表格區域 =======
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.decode("#E8EEF1"));

        JLabel tableLabel = new JLabel("Enterprise Table", SwingConstants.CENTER);
        tableLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tablePanel.add(tableLabel, BorderLayout.NORTH);

        enterpriseTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Enterprise Name", "Network", "Type"}
        ));
        enterpriseTable.setRowHeight(18);
        enterpriseTable.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 80));
        JScrollPane scrollPane = new JScrollPane(enterpriseTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.NORTH);

        // ======= 下部表單區域 =======
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.decode("#E8EEF1"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Network
        JLabel networkLabel = new JLabel("Network:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(networkLabel, gbc);

        networkComboBox = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(networkComboBox, gbc);

        // Enterprise Type
        JLabel enterpriseTypeLabel = new JLabel("Enterprise Type:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(enterpriseTypeLabel, gbc);

        enterpriseTypeComboBox = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(enterpriseTypeComboBox, gbc);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(nameLabel, gbc);

        nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(nameField, gbc);

        // Submit Button
        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Action Listener for Submit Button
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            Network selectedNetwork = (Network) networkComboBox.getSelectedItem();
            Enterprise.EnterpriseType selectedType = (Enterprise.EnterpriseType) enterpriseTypeComboBox.getSelectedItem();

            if (name.isEmpty() || selectedNetwork == null || selectedType == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "All fields are required.");
                return;
            }

            // 創建新的 Enterprise
            selectedNetwork.getEnterpriseDirectory().createAndAddEnterprise(name, selectedType);
            populateTable();
            nameField.setText("");
        });

    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseTable.getModel();
        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                Object[] row = new Object[3];
                row[0] = enterprise.getName();
                row[1] = network.getName();
                row[2] = enterprise.getEnterpriseType().getValue();
                model.addRow(row);
            }
        }
    }

    private void populateComboBox() {
        networkComboBox.removeAllItems();
        enterpriseTypeComboBox.removeAllItems();

        // 填充 Network ComboBox
        for (Network network : system.getNetworkList()) {
            networkComboBox.addItem(network); // 添加 Network 物件
        }

        // 填充 Enterprise Type ComboBox
        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            enterpriseTypeComboBox.addItem(type); // 添加 EnterpriseType 物件
        }
    }



    public JTable getEnterpriseTable() {
        return enterpriseTable;
    }

    public JComboBox<Network> getNetworkComboBox() {
        return networkComboBox;
    }

    public JComboBox<Enterprise.EnterpriseType> getEnterpriseTypeComboBox() {
        return enterpriseTypeComboBox;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
