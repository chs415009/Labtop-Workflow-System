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
public class PurchaseWorkRequest {

   
    Product product;
    
    String OrderName;//modified by Purhcasing Manager
    int targetQuantity;//modified by Purhcasing Manager
    String perchaseStatus;//modified by Purhcasing Manager
    Boolean Verified;//modified by Purhcasing Manager
    Boolean Signed;//modified by Purhcasing Manager
     
    int productPerPrice;//modified by ManufacturingManager Role
   
    
    int currentManufacturedQuantity;//modifeid by ManufacturingWorker role
    String productionStatus;//modified by Purhcasing Manager
    
   
    String feedback;//modified by three roles
    public PurchaseWorkRequest(Product product, String OrderName, int targetQuantity) {
        this.product = product;
        this.OrderName = OrderName;
        this.targetQuantity = targetQuantity;
        perchaseStatus="Processing";
        Verified= false;
        Signed=false;
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

    public int getTargetQuantity() {
        return targetQuantity;
    }

    public void setTargetQuantity(int targetQuantity) {
        this.targetQuantity = targetQuantity;
    }

    public String getPerchaseStatus() {
        return perchaseStatus;
    }

    public void setPerchaseStatus(String perchaseStatus) {
        this.perchaseStatus = perchaseStatus;
    }

    public Boolean getVerified() {
        return Verified;
    }

    public void setVerified(Boolean Verified) {
        this.Verified = Verified;
    }

    public Boolean getSigned() {
        return Signed;
    }

    public void setSigned(Boolean Signed) {
        this.Signed = Signed;
    }

    public int getProductPerPrice() {
        return productPerPrice;
    }

    public void setProductPerPrice(int productPerPrice) {
        this.productPerPrice = productPerPrice;
    }

    public int getCurrentManufacturedQuantity() {
        return currentManufacturedQuantity;
    }

    public void setCurrentManufacturedQuantity(int currentManufacturedQuantity) {
        this.currentManufacturedQuantity = currentManufacturedQuantity;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    
   
    
   
   
}
