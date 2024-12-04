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
public class MarketingWorkRequest {

    
    Product product;
    
    String MarketingPlanName;//modified by Marketing Manager Role
    int budget;//modified by Marketing Manager Role
    String MarketingPlanStatus;//modified by Marketing Manager Role
    Boolean Verified;//modified by Marketing Manager Role
     
    Boolean Signed;//modified by AdvertisingManager Role
    
    String AdsExecutionStatus;//modified by AdvertisingManager Role
    String AdsPerformance;//modified by AdvertisingManager Role
    int usedBudget;//modifeid by  DigitalStrategist role
    
    public MarketingWorkRequest(Product product, String MarketingPlanName, int budget) {
        this.product = product;
        this.MarketingPlanName = MarketingPlanName;
        this.budget = budget;
        this.MarketingPlanStatus ="Processing";
        this.Verified = false;
        this.Signed = false;
        this.AdsExecutionStatus = ""; 
        this.AdsPerformance = "";
        this.usedBudget = 0;
    }

    String feedback;//modified by three roles
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMarketingPlanName() {
        return MarketingPlanName;
    }

    public void setMarketingPlanName(String MarketingPlanName) {
        this.MarketingPlanName = MarketingPlanName;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getMarketingPlanStatus() {
        return MarketingPlanStatus;
    }

    public void setMarketingPlanStatus(String MarketingPlanStatus) {
        this.MarketingPlanStatus = MarketingPlanStatus;
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

    public String getAdsExecutionStatus() {
        return AdsExecutionStatus;
    }

    public void setAdsExecutionStatus(String AdsExecutionStatus) {
        this.AdsExecutionStatus = AdsExecutionStatus;
    }

    public String getAdsPerformance() {
        return AdsPerformance;
    }

    public void setAdsPerformance(String AdsPerformance) {
        this.AdsPerformance = AdsPerformance;
    }

    public int getUsedBudget() {
        return usedBudget;
    }

    public void setUsedBudget(int currentBedgetUsed) {
        this.usedBudget = currentBedgetUsed;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
   
}
