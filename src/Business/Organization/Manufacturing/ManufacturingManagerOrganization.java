/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.Manufacturing;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;

/**
 *
 * @author yuta
 */
public class ManufacturingManagerOrganization extends Organization {
    public ManufacturingManagerOrganization(Enterprise enterprise) {
        super("Manufacturing Management", enterprise);
    }
}