/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.Tech;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Tech.ProductManagerRole;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class ProductManagementOrganization extends Organization {
    public ProductManagementOrganization(Enterprise enterprise) {
        super("Product Management", enterprise);
    }
}
