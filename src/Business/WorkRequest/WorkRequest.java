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
public class WorkRequest {

    String name;  // WorkRequest name 
    Product product;  // Product in this WorkRequest
    String status;

    DevelopmentWorkRequest developmentWorkRequest;
    PurchaseWorkRequest purchaseWorkRequest;
    DelieverWorkRequest delieverWorkRequeset;
    MarketingWorkRequest marketingWorkRequest ;

  
    
     public WorkRequest(String name, Product product) {
        this.name = name;
        this.product = product;
        this.status = "processing";  // 
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public DevelopmentWorkRequest getDevelopmentWorkRequest() {
        return developmentWorkRequest;
    }

    public void setDevelopmentWorkRequest(DevelopmentWorkRequest developmentWorkRequest) {
        this.developmentWorkRequest = developmentWorkRequest;
    }
    
     public void setPurchaseWorkRequest(PurchaseWorkRequest purchaseWorkRequest) {
        this.purchaseWorkRequest = purchaseWorkRequest;
    }

    public void setDelieverWorkRequeset(DelieverWorkRequest delieverWorkRequeset) {
        this.delieverWorkRequeset = delieverWorkRequeset;
    }

    public void setMarketingWorkRequest(MarketingWorkRequest marketingWorkRequest) {
        this.marketingWorkRequest = marketingWorkRequest;
    }
    
    @Override
    public String toString() {
        return  name ;
    }
    
}

