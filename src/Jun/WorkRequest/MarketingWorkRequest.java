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
public class MarketingWorkRequest {
    Product product;
    
    String MarketingPlanName;//modified by Marketing Manager Role
    int budget;//modified by Marketing Manager Role
    String MarketingPlanStatus;//modified by Marketing Manager Role
    Boolean Verified;//modified by Marketing Manager Role
     
    Boolean Signed;//modified by AdvertisingManager Role
    
    String AdsExecutionStatus;//modified by AdvertisingManager Role
    String AdsPerformance;//modified by AdvertisingManager Role
    int currentBedgetUsed;//modifeid by  DigitalStrategist role

    String feedback;//modified by three roles
}
