/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import Jun.WorkRequest.WorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuanchanglee
 */
public abstract class Organization {
    private String name;
    private Enterprise enterprise;
    private List<UserAccount> userAccounts;
    private WorkQueue workQueue;
    
    public Organization(String name, Enterprise enterprise) {
        this.name = name;
        this.enterprise = enterprise;
        this.userAccounts = new ArrayList<>();
        this.workQueue = new WorkQueue();
    }
    
    public void addUserAccount(UserAccount userAccount) {
        userAccounts.add(userAccount);
    }
    
    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    
    public String getName() {
        return name;
    }
    
    public Enterprise getEnterprise() {
        return enterprise;
    }
    
    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }
}