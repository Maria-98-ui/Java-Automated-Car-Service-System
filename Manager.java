package automativecarsystem;
import java.util.ArrayList;
public class Manager extends Employee{
    String position = "Manager";
  

    public Manager(String username, String password, String IdentityCard, String Department, String emailAddress, String phoneNumber, String mailingAddress) {
        super(username, password, IdentityCard, Department, emailAddress, phoneNumber, mailingAddress);
    }

    

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    

    
    }

   
    
