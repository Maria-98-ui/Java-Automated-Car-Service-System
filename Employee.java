
package automativecarsystem;

import java.util.ArrayList;


public abstract class Employee {
    protected String username;
    protected String password;
    protected String IdentityCard;
    protected String Department;
    protected String emailAddress;
    protected String phoneNumber;
    protected String mailingAddress;
    protected ArrayList<Technician>allTechnician;
    protected ArrayList<Manager>allManager;

    public Employee(String username, String password, String IdentityCard, String Department, String emailAddress, String phoneNumber, String mailingAddress) {

       this.username = username;
       this.password = password;
       this.IdentityCard = IdentityCard;
       this.Department = Department;
       this.emailAddress = emailAddress;
       this.phoneNumber = phoneNumber;
       this.mailingAddress = mailingAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

   

    public String getIdentityCard() {
        return IdentityCard;
    }

    public String getDepartment() {
        return Department;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public ArrayList<Technician> getAllTechnician() {
        return allTechnician;
    }

    public ArrayList<Manager> getAllManager() {
        return allManager;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdentityCard(String IdentityCard) {
        this.IdentityCard = IdentityCard;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setAllTechnician(ArrayList<Technician> allTechnician) {
        this.allTechnician = allTechnician;
    }

    public void setAllManager(ArrayList<Manager> allManager) {
        this.allManager = allManager;
    }
   

    
}
