/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/**
 *
 * @author yuta
 */
public class Admin {
    private String name;
    private String password;
    
    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public String getName() { return name; }
    public String getPassword() { return password; }
}
