/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Tech.MarketingOrganization;
import Business.Organization.Tech.ProductManagementOrganization;
import Business.Organization.Tech.PurchasingOrganization;
import Business.Organization.Tech.ResearchAndDevelopmentOrganization;

/**
 *
 * @author yuta
 */
public class TechnologyProductEnterprise extends Enterprise {
    public TechnologyProductEnterprise(String name, String adminName, String adminPassword) {
        super(name, EnterpriseType.TECH, adminName, adminPassword);
    }
    
    @Override
    protected void initializeOrganizations() {
        addOrganization(new ProductManagementOrganization(this));
        addOrganization(new ResearchAndDevelopmentOrganization(this));
        addOrganization(new PurchasingOrganization(this));
        addOrganization(new MarketingOrganization(this));
    }
}