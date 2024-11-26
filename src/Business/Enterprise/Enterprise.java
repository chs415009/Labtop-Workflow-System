/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bolin
 */

public abstract class Enterprise {
    private EnterpriseType type;
    private String name;
    private List<Organization> organizationList;
    private List<UserAccount> employerList;
    
    public Enterprise(String name, EnterpriseType type) {
        this.name = name;
        this.type = type;
        this.organizationList = new ArrayList<>();
        this.employerList = new ArrayList<>();
    }
    
    public void addOrganization(Organization org) {
        organizationList.add(org);
    }
    
    public void addUserAccount(UserAccount userAccount) {
        employerList.add(userAccount);
    }
    
    public List<Organization> getOrganizationDirectory() {
        return organizationList;
    }
    
    public EnterpriseType getType() {
        return type;
    }
    
    public String getName() {
        return name;
    }
    
    public List<UserAccount> getEmployerList() {
        return employerList;
    }
}
