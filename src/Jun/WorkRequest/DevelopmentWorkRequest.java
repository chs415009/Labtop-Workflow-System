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
public class DevelopmentWorkRequest {

    Product product;
    String devStatus;//modifeid by RD
    String feedback;//modified by RD
    Boolean Verified;//modified by PM

   
    
    public DevelopmentWorkRequest(Product product) {
        this.product = product;
        this.devStatus = "Pending"; // Pedning -> Developing ->testing ->  Compeleted
        this.feedback = feedback;
        this.Verified = false;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getdevStatus() {
        return devStatus;
    }

    public void setdevStatus(String currentStatus) {
        this.devStatus = currentStatus;
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
