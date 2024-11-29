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
public class DeliverWorkRequest {

   
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

    
    
     public DeliverWorkRequest(Product product, String OrderName, String ShipFromAddress, String shipToAddress, int shippingQuantity) {
        this.product = product;
        this.OrderName = OrderName;
        this.ShipFromAddress = ShipFromAddress;
        this.ShippingStatus="pending";
        this.shipToAddress = shipToAddress;
        this.shippingQuantity = shippingQuantity;
        this.signed = false;
        this.ShipConfirmed =false;
    }
    
public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String OrderName) {
        this.OrderName = OrderName;
    }

    public String getShipFromAddress() {
        return ShipFromAddress;
    }

    public void setShipFromAddress(String ShipFromAddress) {
        this.ShipFromAddress = ShipFromAddress;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public int getShippingQuantity() {
        return shippingQuantity;
    }

    public void setShippingQuantity(int shippingQuantity) {
        this.shippingQuantity = shippingQuantity;
    }

    public boolean getSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public int getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(int shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public String getShippingStatus() {
        return ShippingStatus;
    }

    public void setShippingStatus(String ShippingStatus) {
        this.ShippingStatus = ShippingStatus;
    }

    public Boolean getShipConfirmed() {
        return ShipConfirmed;
    }

    public void setShipConfirmed(Boolean ShipConfirmed) {
        this.ShipConfirmed = ShipConfirmed;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
   
}
