/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkRequest;

import Business.Product.Product;

/**
 *
 * @author User
 */
public class DelieverWorkRequest {

    Product product;

    String OrderName;//set By ManufacturingManager
    String ShipFromAddress;//set By ManufacturingManager
    String shipToAddress;//set By ManufacturingManager
    int shippingQuantity;//set By ManufacturingManager
    boolean signed;//set By ManufacturingManager

    int shippingPrice;//set by DelieverManager

    String ShippingStatus; // modified by Deliever
    Boolean ShipConfirmed;//verifiedBy RetailManager
    String feedback;// modifeid by everyone
}
