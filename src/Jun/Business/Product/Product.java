/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jun.Business.Product;

/**
 *
 * @author User
 */
public class Product {



    private String name;
    private String description;
    private int cpuCoreNumber;
    private double screenSize;
    private int ramSize;
    private int storageSize;         
    // constructor
    public Product(String name, String description, int cpuCoreNumber, double screenSize, int ramSize, int storageSize) {
        this.name = name;
        this.description = description;
        this.cpuCoreNumber = cpuCoreNumber;
        this.screenSize = screenSize;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
    }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCpuCoreNumber() {
        return cpuCoreNumber;
    }

    public void setCpuCoreNumber(int cpuCoreNumber) {
        this.cpuCoreNumber = cpuCoreNumber;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }
    @Override
    public String toString() {
        return name;
    }
   
}

