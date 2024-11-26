/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.Organization.Organization;
import Business.Enterprise.Enterprise;

/**
 *
 * @author yuanchanglee
 */
import Business.Enterprise.Enterprise;
public class UserAccount {
    private String username;
    private String password;
    private Role role;
    private Organization organization;
    private Enterprise enterprise;
    
    public UserAccount(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public void setOrganization(Organization org) {
        this.organization = org;
    }
    
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    
    public Role getRole() {
        return role;
    }
    
    public Organization getOrganization() {
        return organization;
    }
    
    public Enterprise getEnterprise() {
        return enterprise;
    }
    
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}