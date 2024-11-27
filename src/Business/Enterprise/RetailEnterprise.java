/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Retail.RetailSalesOrganization;

/**
 *
 * @author yuta
 */
 public class RetailEnterprise extends Enterprise {
    public RetailEnterprise(String name) {
        super(name, EnterpriseType.RETAIL);
    }
    
    @Override
    protected void initializeOrganizations() {
        addOrganization(new RetailSalesOrganization(this));
    }
}