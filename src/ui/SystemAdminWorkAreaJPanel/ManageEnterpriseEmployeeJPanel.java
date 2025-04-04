/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemAdminWorkAreaJPanel;

import Business.Enterprise.Enterprise;
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
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class ManageEnterpriseEmployeeJPanel extends javax.swing.JPanel {

    private JTable employeeTable;
    private JButton createEmployeeButton;
    private JButton deleteEmployeeButton;
    private JPanel userProcessContainer;
    private WorkFlowSystem system;
    private JButton editEmployeeButton;

    private boolean isSystemAdmin;
    private Enterprise currentEnterprise; // For enterprise admin

    public ManageEnterpriseEmployeeJPanel(JPanel userProcessContainer, WorkFlowSystem system, 
                                         boolean isSystemAdmin, Enterprise currentEnterprise) {
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.isSystemAdmin = isSystemAdmin;
        this.currentEnterprise = currentEnterprise;
        initComponents();
        customizeComponents();
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

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    
    private void customizeComponents() {
        setBackground(Color.decode("#E8EEF1"));

        // Table Panel Section
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.decode("#E8EEF1"));

        JLabel tableLabel = new JLabel("Enterprise Employees", SwingConstants.CENTER);
        tableLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tablePanel.add(tableLabel, BorderLayout.NORTH);

        // Initialize table
        employeeTable = new JTable(new DefaultTableModel(
            new Object[][]{},
            new String[]{"No.", "Name", "Role", "Enterprise", "Network"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        // Configure table appearance
        employeeTable.setRowHeight(25);
        employeeTable.setFillsViewportHeight(true);
        employeeTable.setSelectionBackground(Color.decode("#D4E6F1"));
        employeeTable.getTableHeader().setBackground(Color.decode("#2980B9"));
        employeeTable.getTableHeader().setForeground(Color.GRAY);
        employeeTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        if (employeeTable.getColumnModel().getColumnCount() > 0) {
            employeeTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            employeeTable.getColumnModel().getColumn(0).setMaxWidth(50);
            employeeTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            employeeTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            employeeTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            employeeTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel Section
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(Color.decode("#E8EEF1"));

        createEmployeeButton = new JButton("Create Employee");
        createEmployeeButton.setBackground(Color.decode("#2980B9"));
        createEmployeeButton.setForeground(Color.WHITE);

        deleteEmployeeButton = new JButton("Delete Employee");
        deleteEmployeeButton.setBackground(Color.decode("#E74C3C"));
        deleteEmployeeButton.setForeground(Color.WHITE);
        
                // In Button Panel Section
        editEmployeeButton = new JButton("Edit Employee");
        editEmployeeButton.setBackground(Color.decode("#F39C12")); // Orange color
        editEmployeeButton.setForeground(Color.WHITE);

        buttonPanel.add(createEmployeeButton);
        buttonPanel.add(editEmployeeButton);      // Add this
        buttonPanel.add(deleteEmployeeButton);

        tablePanel.add(buttonPanel, BorderLayout.SOUTH);
        add(tablePanel, BorderLayout.CENTER);

        // Action Listeners
        createEmployeeButton.addActionListener(e -> {
            CreateEmployeeJPanel createEmployeePanel = new CreateEmployeeJPanel(userProcessContainer, system, this);
            userProcessContainer.add(createEmployeePanel, "CreateEmployeeJPanel");
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        });

        deleteEmployeeButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Please select an employee to delete.");
                return;
            } 

            int dialogResult = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this employee?",
                "Delete Employee",
                JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                String username = (String) employeeTable.getValueAt(selectedRow, 1);
                String enterpriseName = (String) employeeTable.getValueAt(selectedRow, 3);
                String networkName = (String) employeeTable.getValueAt(selectedRow, 4);

                // Find and remove the employee
                for (Network network : system.getNetworkList()) {
                    if (network.getName().equals(networkName)) {
                        for (Enterprise enterprise : network.getEnterpriseList()) {
                            if (enterprise.getName().equals(enterpriseName)) {
                                enterprise.getEmployerList().removeIf(emp -> emp.getUsername().equals(username));
                                break;
                            }
                        }
                    }
                }
                populateTable();
            }
        });
        
        editEmployeeButton.addActionListener(e -> {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(this, "Please select an employee to edit.");
                    return;
                }

                String username = (String) employeeTable.getValueAt(selectedRow, 1);
                String enterpriseName = (String) employeeTable.getValueAt(selectedRow, 3);
                String networkName = (String) employeeTable.getValueAt(selectedRow, 4);

                // Find the selected employee
                UserAccount selectedEmployee = null;
                Enterprise selectedEnterprise = null;

                for (Network network : system.getNetworkList()) {
                    if (network.getName().equals(networkName)) {
                        for (Enterprise enterprise : network.getEnterpriseList()) {
                            if (enterprise.getName().equals(enterpriseName)) {
                                for (UserAccount ua : enterprise.getEmployerList()) {
                                    if (ua.getUsername().equals(username)) {
                                        selectedEmployee = ua;
                                        selectedEnterprise = enterprise;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if (selectedEmployee != null) {
                    EditEmployeeJPanel editPanel = new EditEmployeeJPanel(
                        userProcessContainer, 
                        system, 
                        this, 
                        selectedEmployee,
                        selectedEnterprise
                    );
                    userProcessContainer.add(editPanel, "EditEmployeeJPanel");
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                }
            });
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        model.setRowCount(0);
        int sequenceNumber = 1;

        if (isSystemAdmin) {
            // System admin sees all employees
            for (Network network : system.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseList()) {
                    for (UserAccount userAccount : enterprise.getEmployerList()) {
                        addRowToTable(model, sequenceNumber++, userAccount, enterprise, network);
                    }
                }
            }
        } else {
            // Enterprise admin only sees their enterprise's employees
            if (currentEnterprise != null) {
                for (Network network : system.getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterpriseList()) {
                        if (enterprise.equals(currentEnterprise)) {
                            for (UserAccount userAccount : enterprise.getEmployerList()) {
                                addRowToTable(model, sequenceNumber++, userAccount, enterprise, network);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private void addRowToTable(DefaultTableModel model, int sequenceNumber, 
                          UserAccount userAccount, Enterprise enterprise, Network network) {
        Object[] row = new Object[5];
        row[0] = sequenceNumber;
        row[1] = userAccount.getUsername();
        row[2] = userAccount.getRole().toString();
        row[3] = enterprise.getName();
        row[4] = network.getName();
        model.addRow(row);
    }

    public void refreshTable() {
        populateTable();
    }

    // Getters
    public JTable getEmployeeTable() {
        return employeeTable;
    }

    public JButton getCreateEmployeeButton() {
        return createEmployeeButton;
    }

    public JButton getDeleteEmployeeButton() {
        return deleteEmployeeButton;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
