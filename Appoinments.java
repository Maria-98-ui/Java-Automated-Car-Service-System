
package automativecarsystem;


public class Appoinments {
    private String appoinmentID;
    private int time;
    private int EndTime;
    private String date;
    private String serviceHour;
    private int charge =0;
    private Customer c;
    private Technician t;
    
    
    public Appoinments(String appoinmentID,int time,int EndTime,String date,String serviceHour,Customer c, Technician t){
        this.appoinmentID = appoinmentID;
        this.time = time;
        this.EndTime = EndTime;
        this.date = date;
        this.serviceHour = serviceHour;
        this.c = c;
        this.t = t;
        
    }

    public void setAppoinmentID(String appoinmentID) {
        this.appoinmentID = appoinmentID;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setEndTime(int EndTime) {
        this.EndTime = EndTime;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setServiceHour(String serviceHour) {
        this.serviceHour = serviceHour;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public void setT(Technician t) {
        this.t = t;
    }

    public String getAppoinmentID() {
        return appoinmentID;
    }

    public int getTime() {
        return time;
    }

    public int getEndTime() {
        return EndTime;
    }

    public String getDate() {
        return date;
    }

    public String getServiceHour() {
        return serviceHour;
    }

    public Customer getC() {
        return c;
    }

    public Technician getT() {
        return t;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    
    
    
}
