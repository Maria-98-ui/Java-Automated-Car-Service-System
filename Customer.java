

package automativecarsystem;

import java.util.ArrayList;


    public class Customer implements Person{
    private String FullnameC;
    private String   IdentitycardC;
    private String emailAdd;
    private String phoneNum;
    private String mailingAdd;
    private String typeOfCar;
    private ArrayList<Appoinments> myAppoinments;
    public Customer(String name, String id, String mail, String phone, String Add, String typeofCar){
        this.FullnameC = name;
        this.IdentitycardC = id;
        this.emailAdd = mail;
        this.phoneNum = phone;
        this.mailingAdd = Add;
        this.typeOfCar = typeofCar;
        this.myAppoinments = new ArrayList<Appoinments>();  
    }
     public Customer(String name, String id, String mail, String phone, String Add){
     this(name,id,mail,phone,Add,"Car");
 }
             
    
    public void setMyAppoinments(ArrayList<Appoinments> myAppoinments) {
        this.myAppoinments = myAppoinments;
    }

    public ArrayList<Appoinments> getMyAppoinments() {
        return myAppoinments;
    }
    

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public String getFullnameC() {
        return FullnameC;
    }

    public String getIdentitycardC() {
        return IdentitycardC;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getMailingAdd() {
        return mailingAdd;
    }

    public void setFullnameC(String FullnameC) {
        this.FullnameC = FullnameC;
    }

    public void setIdentitycardC(String IdentitycardC) {
        this.IdentitycardC = IdentitycardC;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setMailingAdd(String mailingAdd) {
        this.mailingAdd = mailingAdd;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }
    
    
    
}
