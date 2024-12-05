/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Delivery.DeliveryManagerOrganization;
import Business.Organization.Delivery.DeliveryOrganization;

/**
 *
 * @author yuta
 */
public class DeliveryEnterprise extends Enterprise {
    public DeliveryEnterprise(String name, String adminName, String adminPassword) {
        super(name, EnterpriseType.DELIVERY, adminName, adminPassword);
    }
    
    @Override
    protected void initializeOrganizations() {
        addOrganization(new DeliveryManagerOrganization(this));
        addOrganization(new DeliveryOrganization(this));
    }
}