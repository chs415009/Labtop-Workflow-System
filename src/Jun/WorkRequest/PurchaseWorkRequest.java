/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jun.WorkRequest;

import Jun.Business.Product.Product;

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

    
    
    public PurchaseWorkRequest(String OrderName, Product product, int productPerPrice, int quantity, String perchaseStatus, String feedback, Boolean Signed, Boolean Verified) {
       
    }

    
   
    
    
    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String OrderName) {
        this.OrderName = OrderName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductPerPrice() {
        return productPerPrice;
    }

    public void setProductPerPrice(int productPerPrice) {
        this.productPerPrice = productPerPrice;
    }

    public String getPerchaseStatus() {
        return perchaseStatus;
    }

    public void setPerchaseStatus(String perchaseStatus) {
        this.perchaseStatus = perchaseStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Boolean getVerified() {
        return Verified;
    }

    public void setVerified(Boolean Verified) {
        this.Verified = Verified;
    }
   
}
