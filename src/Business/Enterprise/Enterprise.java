/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Advertisement.DigitalStrategyOrganization;
import Business.Organization.Advertisement.PlannerOrganization;
import Business.Organization.Delivery.DeliveryManagerOrganization;
import Business.Organization.Delivery.DeliveryOrganization;
import Business.Organization.Manufacturing.ManufacturingManagerOrganization;
import Business.Organization.Manufacturing.ProductionLineOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.Retail.RetailSalesOrganization;
import Business.Organization.Tech.MarketingOrganization;
import Business.Organization.Tech.ProductManagementOrganization;
import Business.Organization.Tech.PurchasingOrganization;
import Business.Organization.Tech.ResearchAndDevelopmentOrganization;
import Business.Role.Role;
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
    private List<UserAccount> employeeList;
    
    public Enterprise(String name, EnterpriseType type) {
        this.name = name;
        this.type = type;
        this.organizationList = new ArrayList<>();
        this.employeeList = new ArrayList<>();
        initializeOrganizations();
    }
    
    protected abstract void initializeOrganizations();
    
    public void addOrganization(Organization org) {
        organizationList.add(org);
    }
    
    public void addUserAccount(UserAccount userAccount) {
        employeeList.add(userAccount);
        userAccount.setEnterprise(this);
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
        return employeeList;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public Organization findOrganizationForRole(Role role) {
        String roleName = role.getClass().getSimpleName();
        
        for (Organization org : organizationList) {
            switch (roleName) {
                // Tech Enterprise Roles
                case "ProductManagerRole":
                    if (org instanceof ProductManagementOrganization) return org;
                    break;
                case "RDRole":
                    if (org instanceof ResearchAndDevelopmentOrganization) return org;
                    break;
                case "PurchasingManagerRole":
                    if (org instanceof PurchasingOrganization) return org;
                    break;
                case "MarketingManagerRole":
                    if (org instanceof MarketingOrganization) return org;
                    break;
                    
                // Manufacturing Enterprise Roles
                case "ManufacturingManagerRole":
                    if (org instanceof ManufacturingManagerOrganization) return org;
                    break;
                case "ManufacturingWorkerRole":
                    if (org instanceof ProductionLineOrganization) return org;
                    break;
                    
                // Delivery Enterprise Roles
                case "DeliveryManagerRole":
                    if (org instanceof DeliveryManagerOrganization) return org;
                    break;
                case "DeliveryRole":
                    if (org instanceof DeliveryOrganization) return org;
                    break;
                    
                // Retail Enterprise Roles
                case "RetailManagerRole":
                    if (org instanceof RetailSalesOrganization) return org;
                    break;
                    
                // Advertising Enterprise Roles
                case "AdvertisingManagerRole":
                    if (org instanceof PlannerOrganization) return org;
                    break;
                case "DigitalAdsStrategistRole":
                    if (org instanceof DigitalStrategyOrganization) return org;
                    break;
            }
        }
        return null;
    }
}
