/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.SystemAdminWorkAreaJPanel;

import Business.Enterprise.*;
import Business.Network.Network;
import Business.WorkFlowSystem;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author yuta
 */

public class CreateEnterpriseJPanel extends javax.swing.JPanel {
    
     private JComboBox<Network> networkComboBox;
    private JComboBox<EnterpriseType> enterpriseTypeComboBox;
    private JTextField nameField;
    private JTextField adminUsernameField;
    private JTextField adminPasswordField; 
    private JButton submitButton;
    private JButton backButton;
    private JPanel userProcessContainer;
    private WorkFlowSystem system;
    private ManageEnterpriseJPanel parentPanel;

    // Constants for validation
    private static final int MIN_LENGTH = 5;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private static final String USERNAME_RULE = "<html>Username rules:<br/>• At least 5 characters<br/>• Must contain 1 special character (!@#$%^&*()_+-=[]{}|;:,.<>?)</html>";
    private static final String PASSWORD_RULE = "<html>Password rules:<br/>• At least 5 characters<br/>• Must contain 1 special character (!@#$%^&*()_+-=[]{}|;:,.<>?)</html>";

    public CreateEnterpriseJPanel(JPanel userProcessContainer, WorkFlowSystem system, ManageEnterpriseJPanel parentPanel) {
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.parentPanel = parentPanel;
        initComponents();
    }

    private boolean validateCredential(String credential) {
        if (credential.length() < MIN_LENGTH) {
            return false;
        }
        
        // Check for at least one special character
        boolean hasSpecialChar = false;
        for (char ch : credential.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(ch) != -1) {
                hasSpecialChar = true;
                break;
            }
        }
        return hasSpecialChar;
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.decode("#E8EEF1"));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.decode("#E8EEF1"));
        JLabel titleLabel = new JLabel("Create New Enterprise");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.decode("#E8EEF1"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Network Selection
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Network:"), gbc);
        
        networkComboBox = new JComboBox<>();
        for (Network network : system.getNetworkList()) {
            networkComboBox.addItem(network);
        }
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(networkComboBox, gbc);

        // Enterprise Type Selection
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Enterprise Type:"), gbc);
        
        enterpriseTypeComboBox = new JComboBox<>(EnterpriseType.values());
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(enterpriseTypeComboBox, gbc);

        // Enterprise Name Field
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Enterprise Name:"), gbc);
        
        nameField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(nameField, gbc);

        // Admin Username Field and Rules
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Admin Username:"), gbc);
        
        adminUsernameField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 3;
        formPanel.add(adminUsernameField, gbc);

        // Username Rules Label
        JLabel usernameRuleLabel = new JLabel(USERNAME_RULE);
        usernameRuleLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        usernameRuleLabel.setForeground(Color.decode("#7F8C8D"));
        gbc.gridx = 2; gbc.gridy = 3;
        formPanel.add(usernameRuleLabel, gbc);

        // Admin Password Field and Rules
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Admin Password:"), gbc);
        
        adminPasswordField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 4;
        formPanel.add(adminPasswordField, gbc);

        // Password Rules Label
        JLabel passwordRuleLabel = new JLabel(PASSWORD_RULE);
        passwordRuleLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        passwordRuleLabel.setForeground(Color.decode("#7F8C8D"));
        gbc.gridx = 2; gbc.gridy = 4;
        formPanel.add(passwordRuleLabel, gbc);

        // Center the form panel
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(Color.decode("#E8EEF1"));
        centerPanel.add(formPanel);
        add(centerPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(Color.decode("#E8EEF1"));

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.decode("#2980B9"));
        submitButton.setForeground(Color.WHITE);
        
        backButton = new JButton("Back");
        backButton.setBackground(Color.decode("#95A5A6"));
        backButton.setForeground(Color.WHITE);

        buttonPanel.add(submitButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String adminUsername = adminUsernameField.getText();
            String adminPassword = adminPasswordField.getText();
            Network selectedNetwork = (Network) networkComboBox.getSelectedItem();
            EnterpriseType selectedType = (EnterpriseType) enterpriseTypeComboBox.getSelectedItem();

            // Basic field validation
            if (name.isEmpty() || adminUsername.isEmpty() || adminPassword.isEmpty() || 
                selectedNetwork == null || selectedType == null) {
                JOptionPane.showMessageDialog(this, 
                    "Please fill in all fields", 
                    "Validation Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Username validation
            if (!validateCredential(adminUsername)) {
                JOptionPane.showMessageDialog(this,
                    "Username must be at least 5 characters and contain at least 1 special character",
                    "Invalid Username",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Password validation
            if (!validateCredential(adminPassword)) {
                JOptionPane.showMessageDialog(this,
                    "Password must be at least 5 characters and contain at least 1 special character",
                    "Invalid Password",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create new Enterprise
            Enterprise enterprise = null;
            switch (selectedType) {
                case TECH -> enterprise = new TechnologyProductEnterprise(name, adminUsername, adminPassword);
                case MANUFACTURING -> enterprise = new ManufacturingEnterprise(name, adminUsername, adminPassword);
                case DELIVERY -> enterprise = new DeliveryEnterprise(name, adminUsername, adminPassword);
                case RETAIL -> enterprise = new RetailEnterprise(name, adminUsername, adminPassword);
                case ADVERTISING -> enterprise = new AdvertisingEnterprise(name, adminUsername, adminPassword);
            }

            if (enterprise != null) {
                selectedNetwork.addEnterprise(enterprise);
                JOptionPane.showMessageDialog(this, 
                    "Enterprise created successfully!\n" +
                    "Admin Username: " + adminUsername + "\n" +
                    "Admin Password: " + adminPassword);

                // Go back to enterprise management panel
                backAction();
            }
        });

        backButton.addActionListener(e -> backAction());
    }

    private void backAction() {
    // Refresh the parent panel's table before going back
        if (parentPanel != null) {
            parentPanel.refreshTable();
        }
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }

    // Getters for testing
    public JComboBox<Network> getNetworkComboBox() {
        return networkComboBox;
    }

    public JComboBox<EnterpriseType> getEnterpriseTypeComboBox() {
        return enterpriseTypeComboBox;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getAdminUsernameField() {
        return adminUsernameField;
    }

    public JTextField getAdminPasswordField() {
        return adminPasswordField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}