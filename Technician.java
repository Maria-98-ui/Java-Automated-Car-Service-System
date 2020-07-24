
package automativecarsystem;

import java.util.ArrayList;

public class Technician extends Employee{
    
    
   private String position = "Technician";
   private int startingShift;
   private int endingShift;
   private ArrayList<Appoinments> myAppoinments;

    public Technician( String username, String password, String IdentityCard, String Department, String emailAddress, String phoneNumber, String mailingAddress) {
        super(username, password, IdentityCard, Department, emailAddress, phoneNumber, mailingAddress);
        this.startingShift = startingShift;
        this.endingShift = endingShift;
        
        this.myAppoinments = new ArrayList<Appoinments>();
    }

    public String getPosition() {
        return position;
    }

    public int getStartingShift() {
        return startingShift;
    }

    public int getEndingShift() {
        return endingShift;
    }

    public ArrayList<Appoinments> getMyAppoinments() {
        return myAppoinments;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStartingShift(int startingShift) {
        this.startingShift = startingShift;
    }

    public void setEndingShift(int endingShift) {
        this.endingShift = endingShift;
    }

    public void setMyAppoinments(ArrayList<Appoinments> myAppoinments) {
        this.myAppoinments = myAppoinments;
    }
    public void addAppoinment(Appoinments i){
        myAppoinments.add(i);
    }
    
}
