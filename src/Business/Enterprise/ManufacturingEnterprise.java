/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Manufacturing.ManufacturingManagerOrganization;
import Business.Organization.Manufacturing.ProductionLineOrganization;

/**
 *
 * @author yuta
 */
 public class ManufacturingEnterprise extends Enterprise {
    public ManufacturingEnterprise(String name) {
        super(name, EnterpriseType.MANUFACTURING);
    }
    
    @Override
    protected void initializeOrganizations() {
        addOrganization(new ManufacturingManagerOrganization(this));
        addOrganization(new ProductionLineOrganization(this));
    }
}