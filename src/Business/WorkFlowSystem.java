package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;

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

public class WorkFlowSystem extends Organization {
    private static WorkFlowSystem business;
    private ArrayList<Network> networkList;
    private static Admin admin;
    
    public static WorkFlowSystem getInstance() {
        if (business == null) {
            business = new WorkFlowSystem();
            business.createTestSystem();    
            admin = new Admin("admin", "admin");
        }
        return business;
    }
    
    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    private WorkFlowSystem() {
        super("WorkFlowSystem", null);
        networkList = new ArrayList<Network>();
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public void printAllEmployees() {
        System.out.println("\n=== All Employees in WorkFlow System ===");

        int totalEmployees = 0;
        for (Network network : networkList) {
            System.out.println("\nNetwork: " + network.getName());

            for (Enterprise enterprise : network.getEnterpriseList()) {
                System.out.println("\n  Enterprise: " + enterprise.getName() + " (" + enterprise.getType() + ")");
                
                // Print by organization
                for (Organization org : enterprise.getOrganizationDirectory()) {
                    System.out.println("    Organization: " + org.getName());
                    List<UserAccount> orgUsers = org.getUserAccounts();
                    if (orgUsers.isEmpty()) {
                        System.out.println("      No employees");
                    } else {
                        for (UserAccount employee : orgUsers) {
                            System.out.println("      - Username: " + employee.getUsername()
                                    + ", Role: " + employee.getRole() + ", Org: " + employee.getOrganization());
                            totalEmployees++;
                        }
                    }
                }
            }
        }

        System.out.println("\nTotal Employees in System: " + totalEmployees);
        System.out.println("=====================================");
    }
    
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
        printAllEmployees();
    }
    
    private void createTechEnterprise(Network network) {
        String name = "TechCorp";
        String adminUsername = name.toLowerCase() + "_admin";
        String adminPassword = name.toLowerCase() + "_admin";
        Enterprise techEnterprise = new TechnologyProductEnterprise(name, adminUsername, adminPassword);
        System.out.println("test");
        System.out.println(adminUsername);
        network.addEnterprise(techEnterprise);
        System.out.println("\nCreated Tech Enterprise: " + techEnterprise.getName());
        System.out.println("  Created enterprise admin: " + adminUsername);

        // Each role matches to its specific organization
        createAccount(techEnterprise, "techpm", "123", new ProductManagerRole());    // Product Management Org
        createAccount(techEnterprise, "techrd", "123", new RDRole());                // R&D Org
        createAccount(techEnterprise, "pu", "123", new PurchasingManagerRole());     // Purchasing Org
        createAccount(techEnterprise, "techmkt", "123", new MarketingManagerRole()); // Marketing Org
    }

    private void createManufacturingEnterprise(Network network) {
        String name = "MfgCorp";
        String adminUsername = name.toLowerCase() + "_admin";
        String adminPassword = name.toLowerCase() + "_admin";
        Enterprise mfgEnterprise = new ManufacturingEnterprise(name, adminUsername, adminPassword);
        network.addEnterprise(mfgEnterprise);
        System.out.println("\nCreated Manufacturing Enterprise: " + mfgEnterprise.getName());
        System.out.println("  Created enterprise admin: " + adminUsername);

        createAccount(mfgEnterprise, "mm", "123", new ManufacturingManagerRole()); // Manufacturing Management Org
        createAccount(mfgEnterprise, "mw", "123", new ManufacturingWorkerRole());  // Manufacturing Operations Org
    }

    private void createDeliveryEnterprise(Network network) {
        String name = "DelCorp";
        String adminUsername = name.toLowerCase() + "_admin";
        String adminPassword = name.toLowerCase() + "_admin";
        Enterprise delEnterprise = new DeliveryEnterprise(name, adminUsername, adminPassword);
        network.addEnterprise(delEnterprise);
        System.out.println("\nCreated Delivery Enterprise: " + delEnterprise.getName());
        System.out.println("  Created enterprise admin: " + adminUsername);

        createAccount(delEnterprise, "delm", "123", new DeliveryManagerRole()); // Delivery Management Org
        createAccount(delEnterprise, "delw", "123", new DeliveryRole());        // Delivery Operations Org
    }

    private void createRetailEnterprise(Network network) {
        String name = "RetailCorp";
        String adminUsername = name.toLowerCase() + "_admin";
        String adminPassword = name.toLowerCase() + "_admin";
        Enterprise retEnterprise = new RetailEnterprise(name, adminUsername, adminPassword);
        network.addEnterprise(retEnterprise);
        System.out.println("\nCreated Retail Enterprise: " + retEnterprise.getName());
        System.out.println("  Created enterprise admin: " + adminUsername);

        createAccount(retEnterprise, "retmgr", "123", new RetailManagerRole());   // Retail Sales Org
    }

    private void createAdvertisingEnterprise(Network network) {
        String name = "AdCorp";
        String adminUsername = name.toLowerCase() + "_admin";
        String adminPassword = name.toLowerCase() + "_admin";
        Enterprise adEnterprise = new AdvertisingEnterprise(name, adminUsername, adminPassword);
        network.addEnterprise(adEnterprise);
        System.out.println("\nCreated Advertising Enterprise: " + adEnterprise.getName());
        System.out.println("  Created enterprise admin: " + adminUsername);

        createAccount(adEnterprise, "admgr", "123", new AdvertisingManagerRole());     // Planner Org
        createAccount(adEnterprise, "adstr", "123", new DigitalAdsStrategistRole());   // Digital Strategy Org
    }
    
    private void createAccount(Enterprise enterprise, String username, String password, Role role) {
        UserAccount account = new UserAccount(username, password, role);
        
        // Find the matching organization for this role
        Organization organization = enterprise.findOrganizationForRole(role);
        if (organization != null) {
            enterprise.addUserAccount(account);
            organization.addUserAccount(account);
            System.out.println("  Created account: " + username + 
                             " (" + role + ") in " + 
                             organization.getName() + " Organization");
        } else {
            System.out.println("  Warning: No matching organization found for " + 
                             username + " with role " + role);
        }
    }
}