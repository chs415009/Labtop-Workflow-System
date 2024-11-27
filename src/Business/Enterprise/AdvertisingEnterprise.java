/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Advertisement.DigitalStrategyOrganization;
import Business.Organization.Advertisement.PlannerOrganization;

/**
 *
 * @author yuta
 */
public class AdvertisingEnterprise extends Enterprise {
    public AdvertisingEnterprise(String name) {
        super(name, EnterpriseType.ADVERTISING);
    }
    
    @Override
    protected void initializeOrganizations() {
        addOrganization(new PlannerOrganization(this));
        addOrganization(new DigitalStrategyOrganization(this));
    }
}