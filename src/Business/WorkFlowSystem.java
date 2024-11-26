/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;
import Business.Role.*;
import Business.Role.Advertisement.*;  
import Business.Role.Delivery.*;       
import Business.Role.Manufacturing.*;  
import Business.Role.Retail.*;        
import Business.Role.Tech.*;
import Business.Enterprise.*;
import static Business.Enterprise.EnterpriseType.ADVERTISING;
import static Business.Enterprise.EnterpriseType.DELIVERY;
import static Business.Enterprise.EnterpriseType.MANUFACTURING;
import static Business.Enterprise.EnterpriseType.RETAIL;
import Business.Admin;

/**
 *
 * @author yuanchanglee
 */

public class WorkFlowSystem extends Organization {
    private static WorkFlowSystem business;
    private ArrayList<Network> networkList;
    private static Admin admin;
    
    public static WorkFlowSystem getInstance(){
        if(business==null){
            business=new WorkFlowSystem();
            business.createTestSystem();    
            admin = new Admin();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }


    private WorkFlowSystem() {
        super("WorkFlowSystem", null);
        networkList=new ArrayList<Network>();
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    
    // Print All Employee
    
    public void printAllEmployees() {
        System.out.println("\n=== All Employees in WorkFlow System ===");

        int totalEmployees = 0;
        for (Network network : networkList) {
            System.out.println("\nNetwork: " + network.getName());

            for (Enterprise enterprise : network.getEnterpriseList()) {
                System.out.println("\n  Enterprise: " + enterprise.getName() + " (" + enterprise.getType() + ")");

                List<UserAccount> employees = enterprise.getEmployerList();
                if (employees.isEmpty()) {
                    System.out.println("    No employees");
                } else {
                    for (UserAccount employee : employees) {
                        System.out.println("    - Username: " + employee.getUsername()
                                + ", Role: " + employee.getRole()
                                + ", Name: " + employee.getUsername());
                        totalEmployees++;
                    }
                }
            }
        }

        System.out.println("\nTotal Employees in System: " + totalEmployees);
        System.out.println("=====================================");
    }
    
   
    // fake data
    public void createTestSystem() {
        // Create Network
        Network network = createAndAddNetwork();
        network.setName("TestNetwork");
        
        System.out.println("\n=== Creating Test System ===");
        System.out.println("Network created: " + network.getName());

        // Create all enterprise types with accounts
        createTechEnterprise(network);
        createManufacturingEnterprise(network);
        createDeliveryEnterprise(network);
        createRetailEnterprise(network);
        createAdvertisingEnterprise(network);
        
        System.out.println("\n=== Test System Created Successfully ===");
        printAllEmployees(); // Print all created accounts
    }
    
    private void createTechEnterprise(Network network) {
        Enterprise techEnterprise = new TechnologyProductEnterprise("TechCorp");
        network.addEnterprise(techEnterprise);
        System.out.println("\nCreated Tech Enterprise: " + techEnterprise.getName());
        
        // Create user accounts for each role
        createAccount(techEnterprise, "techpm", "test123", new ProductManagerRole());
        createAccount(techEnterprise, "techrd", "test123", new RDRole());
        createAccount(techEnterprise, "techpur", "test123", new PurchasingManagerRole());
        createAccount(techEnterprise, "techmkt", "test123", new MarketingManagerRole());
    }
    
    private void createManufacturingEnterprise(Network network) {
        Enterprise mfgEnterprise = new ManufacturingEnterprise("MfgCorp");
        network.addEnterprise(mfgEnterprise);
        System.out.println("\nCreated Manufacturing Enterprise: " + mfgEnterprise.getName());
        
        createAccount(mfgEnterprise, "mfgmgr", "test123", new ManufacturingManagerRole());
        createAccount(mfgEnterprise, "mfgwrk", "test123", new ManufacturingWorkerRole());
    }
    
    private void createDeliveryEnterprise(Network network) {
        Enterprise delEnterprise = new DeliveryEnterprise("DelCorp");
        network.addEnterprise(delEnterprise);
        System.out.println("\nCreated Delivery Enterprise: " + delEnterprise.getName());
        
        createAccount(delEnterprise, "delmgr", "test123", new DeliveryManagerRole());
        createAccount(delEnterprise, "delwrk", "test123", new DeliveryRole());
    }
    
    private void createRetailEnterprise(Network network) {
        Enterprise retEnterprise = new RetailEnterprise("RetailCorp");
        network.addEnterprise(retEnterprise);
        System.out.println("\nCreated Retail Enterprise: " + retEnterprise.getName());
        
        createAccount(retEnterprise, "retmgr", "test123", new RetailManagerRole());
    }
    
    private void createAdvertisingEnterprise(Network network) {
        Enterprise adEnterprise = new AdvertisingEnterprise("AdCorp");
        network.addEnterprise(adEnterprise);
        System.out.println("\nCreated Advertising Enterprise: " + adEnterprise.getName());
        
        createAccount(adEnterprise, "admgr", "test123", new AdvertisingManagerRole());
        createAccount(adEnterprise, "adstr", "test123", new DigitalAdsStrategistRole());
    }
    
    private void createAccount(Enterprise enterprise, String username, String password, Role role) {
        UserAccount account = new UserAccount(username, password, role);
        enterprise.addUserAccount(account);
        System.out.println("  Created account: " + username + " (" + role + ")");
    }
}