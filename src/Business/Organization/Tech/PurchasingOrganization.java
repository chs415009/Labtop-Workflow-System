/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.Tech;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Tech.PurchasingManagerRole;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PurchasingOrganization extends Organization {
    public PurchasingOrganization(Enterprise enterprise) {
        super("Purchasing", enterprise);
    }
}
