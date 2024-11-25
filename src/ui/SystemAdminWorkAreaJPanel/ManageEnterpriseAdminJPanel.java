/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemAdminWorkAreaJPanel;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.AdminRole;
import Business.UserAccount.UserAccount;
import Business.WorkFlowSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yuanchanglee
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    private JTable enterpriseAdminTable;
    private JComboBox<Network> networkComboBox;
    private JComboBox<Enterprise> enterpriseComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JButton submitButton;

    private WorkFlowSystem system;
    
    /**
     * Creates new form ManageEnterpriseAdminJPanel
     */
    
    public ManageEnterpriseAdminJPanel(WorkFlowSystem system) {
        this.system = system;
        customizeComponents();
        populateTable();
        populateNetworkComboBox();
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
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseAdminTable.getModel();
        model.setRowCount(0);

        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName(); // 企業名稱
                    row[1] = network.getName(); // 網絡名稱
                    row[2] = userAccount.getUsername(); // 用戶名
                    model.addRow(row);
                }
            }
        }
    }


    private void populateNetworkComboBox() {
        networkComboBox.removeAllItems();
        for (Network network : system.getNetworkList()) {
            networkComboBox.addItem(network); // 添加 Network 物件
        }
    }

    private void populateEnterpriseComboBox(Network network) {
        enterpriseComboBox.removeAllItems();
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            enterpriseComboBox.addItem(enterprise); // 添加 Enterprise 物件
        }
    }


    private void customizeComponents() {
        // 設置主面板的佈局
        setLayout(new BorderLayout());
        setBackground(Color.decode("#E8EEF1")); // 柔和藍灰色背景

        // ======= 上部表格區域 =======
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.decode("#E8EEF1"));

        // 表格標題
        JLabel tableLabel = new JLabel("Enterprise Admin Table", SwingConstants.CENTER);
        tableLabel.setFont(new Font("Arial", Font.BOLD, 14));
        tablePanel.add(tableLabel, BorderLayout.NORTH);

        // 表格
        enterpriseAdminTable = new JTable(new DefaultTableModel(
                new Object[][]{}, // 空表格數據
                new String[]{"Enterprise Name", "Network", "Username"}
        ));
        enterpriseAdminTable.setRowHeight(10); // 調整表格行高
        enterpriseAdminTable.setPreferredScrollableViewportSize(new Dimension(300, 100)); // 限制表格顯示大小
        JScrollPane scrollPane = new JScrollPane(enterpriseAdminTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.NORTH);

        // ======= 下部表單區域 =======
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.decode("#E8EEF1"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // 縮小間距

        // ======= 表單字段 =======
        // Network
        JLabel networkLabel = new JLabel("Network:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(networkLabel, gbc);

        networkComboBox = new JComboBox<>();
        networkComboBox.setPreferredSize(new Dimension(120, 25)); // 減小寬高
        networkComboBox.addActionListener(e -> {
            Network selectedNetwork = (Network) networkComboBox.getSelectedItem(); // 直接取得 Network 物件
            if (selectedNetwork != null) {
                populateEnterpriseComboBox(selectedNetwork);
            }
        });

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(networkComboBox, gbc);

        // Enterprise
        JLabel enterpriseLabel = new JLabel("Enterprise:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(enterpriseLabel, gbc);

        enterpriseComboBox = new JComboBox<>();
        enterpriseComboBox.setPreferredSize(new Dimension(120, 25)); // 減小寬高
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(enterpriseComboBox, gbc);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(usernameLabel, gbc);

        usernameField = new JTextField(10); // 減小寬度
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(usernameField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(10); // 減小寬度
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(passwordField, gbc);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(nameLabel, gbc);

        nameField = new JTextField(10); // 減小寬度
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(nameField, gbc);

        // Submit Button
        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        submitButton.addActionListener(e -> submitEnterpriseAdmin());
        formPanel.add(submitButton, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    private void submitEnterpriseAdmin() {
        Network selectedNetwork = (Network) networkComboBox.getSelectedItem();
        Enterprise selectedEnterprise = (Enterprise) enterpriseComboBox.getSelectedItem();

        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String name = nameField.getText();

        if (selectedNetwork == null || selectedEnterprise == null || username.isEmpty() || password.isEmpty() || name.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        // 創建 Employee 和 UserAccount
        Employee employee = selectedEnterprise.getEmployeeDirectory().createEmployee(name);
        selectedEnterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
        populateTable();
        javax.swing.JOptionPane.showMessageDialog(this, "Enterprise Admin created successfully.");
    }


    public JTable getEnterpriseAdminTable() {
        return enterpriseAdminTable;
    }

    public JComboBox<Network> getNetworkComboBox() {
        return networkComboBox;
    }

    public JComboBox<Enterprise> getEnterpriseComboBox() {
        return enterpriseComboBox;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
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