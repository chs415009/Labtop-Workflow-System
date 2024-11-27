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

/**
 *
 * @author Bolin
 */
public abstract class Role {
    private String name;
    
    public Role(String name) {
        this.name = name;
    }
    
    public String getName() { 
        return name; 
    }
    
    @Override
    public String toString() {
        return name;
    }
}
