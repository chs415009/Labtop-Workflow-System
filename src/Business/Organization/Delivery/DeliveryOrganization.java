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
public class DeliveryOrganization extends Organization {
    public DeliveryOrganization(Enterprise enterprise) {
        super("Delivery", enterprise);
    }
}
