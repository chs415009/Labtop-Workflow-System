/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.Delivery;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;

/**
 *
 * @author yuta
 */
public class DeliveryManagerOrganization extends Organization {
    public DeliveryManagerOrganization(Enterprise enterprise) {
        super("Delivery Management", enterprise);
    }
}