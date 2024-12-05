/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.SystemAdminWorkAreaJPanel;

import Business.Enterprise.*;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.*;
import Business.Role.Advertisement.*;
import Business.Role.Delivery.*;
import Business.Role.Manufacturing.*;
import Business.Role.Retail.*;
import Business.Role.Tech.*;
import Business.UserAccount.UserAccount;
import Business.WorkFlowSystem;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author yuta
 */

public class CreateEmployeeJPanel extends javax.swing.JPanel {
    
    private JComboBox<Network> networkComboBox;
    private JComboBox<Enterprise> enterpriseComboBox;
    private JComboBox<Role> roleComboBox;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton submitButton;
    private JButton backButton;

    private JPanel userProcessContainer;
    private WorkFlowSystem system;
    private ManageEnterpriseEmployeeJPanel parentPanel;
    
        // Constants for validation
    private static final int MIN_LENGTH = 5;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private static final String USERNAME_RULE = "<html>Username rules:<br/>• At least 5 characters<br/>• Must contain 1 special character (!@#$%^&*()_+-=[]{}|;:,.<>?)</html>";
    private static final String PASSWORD_RULE = "<html>Password rules:<br/>• At least 5 characters<br/>• Must contain 1 special character (!@#$%^&*()_+-=[]{}|;:,.<>?)</html>";

    public CreateEmployeeJPanel(JPanel userProcessContainer, WorkFlowSystem system, ManageEnterpriseEmployeeJPanel parentPanel) {
        this.userProcessContainer = userProcessContainer;  // Using userProcessContainer
        this.system = system;
        this.parentPanel = parentPanel;
        initComponents();
        populateNetworkComboBox();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.decode("#F5F7FA"));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.decode("#F5F7FA"));
        JLabel titleLabel = new JLabel("Create New Employee", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.decode("#2C3E50"));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.decode("#F5F7FA"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Initialize components
        networkComboBox = new JComboBox<>();
        enterpriseComboBox = new JComboBox<>();
        roleComboBox = new JComboBox<>();
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        // Add form fields
        addFormField(formPanel, "Network:", networkComboBox, gbc, 0);
        addFormField(formPanel, "Enterprise:", enterpriseComboBox, gbc, 1);
        addFormField(formPanel, "Role:", roleComboBox, gbc, 2);
        addFormField(formPanel, "Username:", usernameField, gbc, 3);
        addFormField(formPanel, "Password:", passwordField, gbc, 4);

        // Add ComboBox listeners
        networkComboBox.addActionListener(e -> {
            Network selectedNetwork = (Network) networkComboBox.getSelectedItem();
            if (selectedNetwork != null) {
                populateEnterpriseComboBox(selectedNetwork);
            }
        });

        enterpriseComboBox.addActionListener(e -> {
            Enterprise selectedEnterprise = (Enterprise) enterpriseComboBox.getSelectedItem();
            if (selectedEnterprise != null) {
                populateRoleComboBox(selectedEnterprise);
            }
        });

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(Color.decode("#F5F7FA"));

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.decode("#2980B9"));
        submitButton.setForeground(Color.WHITE);
        
        backButton = new JButton("Back");
        backButton.setBackground(Color.decode("#95A5A6"));
        backButton.setForeground(Color.WHITE);

        buttonPanel.add(submitButton);
        buttonPanel.add(backButton);

        // Add panels to main panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.decode("#F5F7FA"));
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        // Add button listeners
        submitButton.addActionListener(e -> submitEmployee());
        backButton.addActionListener(e -> backAction());
        
        JLabel usernameRuleLabel = new JLabel(USERNAME_RULE);
        usernameRuleLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        usernameRuleLabel.setForeground(Color.decode("#7F8C8D"));
        gbc.gridx = 2; gbc.gridy = 3;
        formPanel.add(usernameRuleLabel, gbc);

        // After password field
        // Password Rules Label
        JLabel passwordRuleLabel = new JLabel(PASSWORD_RULE);
        passwordRuleLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        passwordRuleLabel.setForeground(Color.decode("#7F8C8D"));
        gbc.gridx = 2; gbc.gridy = 4;
        formPanel.add(passwordRuleLabel, gbc);
    }

    private void populateNetworkComboBox() {
        networkComboBox.removeAllItems();
        for (Network network : system.getNetworkList()) {
            networkComboBox.addItem(network);
        }
    }

    private void populateEnterpriseComboBox(Network network) {
        enterpriseComboBox.removeAllItems();
        for (Enterprise enterprise : network.getEnterpriseList()) {
            enterpriseComboBox.addItem(enterprise);
        }
    }

    private void populateRoleComboBox(Enterprise enterprise) {
        roleComboBox.removeAllItems();

        if (enterprise != null) {
            switch (enterprise.getType()) {
                case TECH:
                    roleComboBox.addItem(new ProductManagerRole());
                    roleComboBox.addItem(new RDRole());
                    roleComboBox.addItem(new PurchasingManagerRole());
                    roleComboBox.addItem(new MarketingManagerRole());
                    break;

                case MANUFACTURING:
                    roleComboBox.addItem(new ManufacturingManagerRole());
                    roleComboBox.addItem(new ManufacturingWorkerRole());
                    break;

                case DELIVERY:
                    roleComboBox.addItem(new DeliveryManagerRole());
                    roleComboBox.addItem(new DeliveryRole());
                    break;

                case RETAIL:
                    roleComboBox.addItem(new RetailManagerRole());
                    break;

                case ADVERTISING:
                    roleComboBox.addItem(new AdvertisingManagerRole());
                    roleComboBox.addItem(new DigitalAdsStrategistRole());
                    break;
            }
        }
    }

    private void submitEmployee() {
        // Get selected items from combo boxes
        Network selectedNetwork = (Network) networkComboBox.getSelectedItem();
        Enterprise selectedEnterprise = (Enterprise) enterpriseComboBox.getSelectedItem();
        Role selectedRole = (Role) roleComboBox.getSelectedItem();

        // Get input values
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate inputs
        if (selectedNetwork == null || selectedEnterprise == null || selectedRole == null) {
            JOptionPane.showMessageDialog(this, 
                "Please select network, enterprise, and role",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all fields",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // After checking for empty fields, add:
        // Username validation
        if (!validateCredential(username)) {
            JOptionPane.showMessageDialog(this,
                "Username must be at least 5 characters and contain at least 1 special character",
                "Invalid Username",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Password validation
        if (!validateCredential(password)) {
            JOptionPane.showMessageDialog(this,
                "Password must be at least 5 characters and contain at least 1 special character",
                "Invalid Password",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if username already exists in the system
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseList()) {
                for (UserAccount account : enterprise.getEmployerList()) {
                    if (account.getUsername().equals(username)) {
                        JOptionPane.showMessageDialog(this,
                            "Username already exists. Please choose a different username.",
                            "Username Error",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        }

        try {
            // Create new UserAccount
            UserAccount userAccount = new UserAccount(username, password, selectedRole);
            Organization organization = selectedEnterprise.findOrganizationForRole(selectedRole);

            if (organization == null) {
                JOptionPane.showMessageDialog(this,
                    "No matching organization found for this role.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add the user account to both enterprise and organization
            selectedEnterprise.addUserAccount(userAccount);
            organization.addUserAccount(userAccount);

            // Clear the form
            clearFields();

            JOptionPane.showMessageDialog(this,
                "Employee account created successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

            // Return to the previous panel
            backAction();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error creating account: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        roleComboBox.setSelectedIndex(-1);
    }

    private void backAction() {
        parentPanel.refreshTable();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
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

    private void addFormField(JPanel panel, String labelText, JComponent component, 
                            GridBagConstraints gbc, int gridy) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 12));

        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(component, gbc);
    }

    // Getters for testing
    public JComboBox<Network> getNetworkComboBox() {
        return networkComboBox;
    }

    public JComboBox<Enterprise> getEnterpriseComboBox() {
        return enterpriseComboBox;
    }

    public JComboBox<Role> getRoleComboBox() {
        return roleComboBox;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}