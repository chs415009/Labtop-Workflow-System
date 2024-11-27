/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.Retail;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;

/**
 *
 * @author yuta
 */
public class RetailSalesOrganization extends Organization {
    public RetailSalesOrganization(Enterprise enterprise) {
        super("Retail Sales", enterprise);
    }
}