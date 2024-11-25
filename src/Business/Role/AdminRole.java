/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkFlowSystem;
import javax.swing.JPanel;
import ui.AdministrativeRole.AdminWorkAreaJPanel;

/**
 *
 * @author yuanchanglee
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, WorkFlowSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise);
    }

    
    
}