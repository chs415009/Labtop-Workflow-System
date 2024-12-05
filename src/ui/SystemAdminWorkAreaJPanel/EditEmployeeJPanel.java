/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.SystemAdminWorkAreaJPanel;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkFlowSystem;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author yuta
 */
public class EditEmployeeJPanel extends javax.swing.JPanel {
    
    private static final int MIN_LENGTH = 5;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private static final String USERNAME_RULE = "<html>Username rules:<br/>• At least 5 characters<br/>• Must contain 1 special character (!@#$%^&*()_+-=[]{}|;:,.<>?)</html>";
    private static final String PASSWORD_RULE = "<html>Password rules:<br/>• At least 5 characters<br/>• Must contain 1 special character (!@#$%^&*()_+-=[]{}|;:,.<>?)</html>";
    
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton submitButton;
    private JButton backButton;
    private JLabel currentInfoLabel;

    private JPanel userProcessContainer;
    private WorkFlowSystem system;
    private ManageEnterpriseEmployeeJPanel parentPanel;
    private UserAccount employee;
    private Enterprise enterprise;

    public EditEmployeeJPanel(JPanel userProcessContainer, WorkFlowSystem system, 
                            ManageEnterpriseEmployeeJPanel parentPanel,
                            UserAccount employee, Enterprise enterprise) {
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.parentPanel = parentPanel;
        this.employee = employee;
        this.enterprise = enterprise;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.decode("#F5F7FA"));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.decode("#F5F7FA"));
        JLabel titleLabel = new JLabel("Edit Employee", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Current Info Label
        currentInfoLabel = new JLabel(String.format(
            "<html>Editing employee: <b>%s</b><br>Role: %s<br>Enterprise: %s</html>",
            employee.getUsername(),
            employee.getRole(),
            enterprise.getName()
        ));
        currentInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        currentInfoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.decode("#F5F7FA"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add current info
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(currentInfoLabel, gbc);

        // Username Field
        gbc.gridy = 1; gbc.gridwidth = 1;
        formPanel.add(new JLabel("New Username:"), gbc);
        
        usernameField = new JTextField(15);
        usernameField.setText(employee.getUsername());
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        // Password Field
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("New Password:"), gbc);
        
        passwordField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);
        
        // Username Rules Label
        JLabel usernameRuleLabel = new JLabel(USERNAME_RULE);
        usernameRuleLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        usernameRuleLabel.setForeground(Color.decode("#7F8C8D"));
        gbc.gridx = 2; gbc.gridy = 1;
        formPanel.add(usernameRuleLabel, gbc);

        // Password Rules Label
        JLabel passwordRuleLabel = new JLabel(PASSWORD_RULE);
        passwordRuleLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        passwordRuleLabel.setForeground(Color.decode("#7F8C8D"));
        gbc.gridx = 2; gbc.gridy = 2;
        formPanel.add(passwordRuleLabel, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(Color.decode("#F5F7FA"));

        submitButton = new JButton("Update");
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
        submitButton.addActionListener(e -> {
            String newUsername = usernameField.getText();
            String newPassword = passwordField.getText();  // Changed to getText()

            if (newUsername.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty");
                return;
            }

            // Username validation
            if (!validateCredential(newUsername)) {
                JOptionPane.showMessageDialog(this,
                    "Username must be at least 5 characters and contain at least 1 special character",
                    "Invalid Username",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Password validation (only if new password is provided)
            if (!newPassword.isEmpty() && !validateCredential(newPassword)) {
                JOptionPane.showMessageDialog(this,
                    "Password must be at least 5 characters and contain at least 1 special character",
                    "Invalid Password",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update credentials
            employee.setUsername(newUsername);
            if (!newPassword.isEmpty()) {
                employee.setPassword(newPassword);
            }

            JOptionPane.showMessageDialog(this, "Employee updated successfully!");
            backAction();
        });

        backButton.addActionListener(e -> backAction());
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

    private void backAction() {
        parentPanel.refreshTable();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
}