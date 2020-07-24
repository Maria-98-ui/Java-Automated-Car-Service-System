
package automativecarsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class AutomativeCarSystem {
    
    public static Manager loginM;
    public static Technician logint,assignTech;
    public static String username;
   // public static Customer register;
   // public static Staff registerc;
    //public static Staff loginS;
    public static GUI1 page1;
    public static GUI2 page2;     
    public static GUI3 page3;
    public static ArrayList<Manager> allManager;
    public static ArrayList<Technician> allTechnician;
    public static ArrayList<Appoinments> allAppoinments;
  //  public static ArrayList<Staff> allStaff; 
    public static ArrayList<Customer> allCustomer; 
    //static Manager Login1;
    //static Technician Login2;

    public static boolean isInt(final String str){
        if (str == null || str.length()==0){
            return false;
        }
        for(char c : str.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        page1 = new GUI1();
        page2 = new GUI2();
        page3 = new GUI3();
       
        GUI2 g;
        
        
        allManager = new ArrayList<Manager>();
        allTechnician = new ArrayList<Technician>();
      //  allStaff = new ArrayList<Staff>();
        allCustomer = new ArrayList<Customer>();
        allAppoinments = new ArrayList<Appoinments>();
        try{
            File file = new File("Manager.txt");
            Scanner s = new Scanner(file);
            
            while(s.hasNext()){
                String username = s.nextLine();
                String password = s.nextLine();
                String IdentityCard = s.nextLine();
                String Department = s.nextLine();
                String emailAddress = s.nextLine();
                String phoneNumber = s.nextLine();
                String mailingAddress = s.nextLine();
                s.nextLine();
                Manager m = new Manager(username, password,IdentityCard,Department,emailAddress,phoneNumber,mailingAddress);
                allManager.add(m);
            
            }
           
        }catch(Exception e){}
           
        
        
            //System.out.println("");
            
        try{
            File file = new File("Technician.txt");
            Scanner s = new Scanner(file);
            while(s.hasNext()){
                String username = s.nextLine();
                String password = s.nextLine();
                String IdentityCard = s.nextLine();
                String Department = s.nextLine();
                String emailAddress = s.nextLine();
                String phoneNumber = s.nextLine();
                String mailingAddress = s.nextLine();
                s.nextLine();
                Technician t = new Technician(username,password,IdentityCard,Department,emailAddress,phoneNumber,mailingAddress);
                allTechnician.add(t);
            }
            //s.close();
               /// System.out.println("HELLO");
        }catch(Exception e){}
        
        try{
            File file = new File("Customer.txt");
            Scanner s = new Scanner(file);
            while(s.hasNext()){
                String name = s.nextLine();
                String id = s.nextLine();
                String mail = s.nextLine();
                String phone = s.nextLine();
                String Add = s.nextLine();
                String typeOfCar = s.nextLine();
                s.nextLine();
                Customer customer = new Customer(name,id,mail,phone,Add,typeOfCar);
                allCustomer.add(customer);
            }
        }catch(Exception e){}
       
      try{
          Scanner s = new Scanner(new File("appoinments.txt"));
          while(s.hasNext()){
              String appoinmentID = s.nextLine();
              int time = Integer.parseInt(s.nextLine());
              int EndTime = Integer.parseInt(s.nextLine());
              String date = s.nextLine();
              String serviceHour = s.nextLine();
              String custName = s.nextLine();
              String TechName = s.nextLine();
              s.nextLine();
              Customer c = null;
              Technician t =null;
              
              for(int i =0;i<allCustomer.size();i++){
                  Customer y =allCustomer.get(i);
                  if(custName.equals(y.getFullnameC())){
                      c = y;
                      break;
                  }
              }
              for(int i=0;i<allTechnician.size();i++){
                  Technician x = allTechnician.get(i);
                  if(TechName.equals(x.getUsername())){
                      t = x;
                      break;
                  }
              }
              Appoinments p = new Appoinments(appoinmentID,time,EndTime,date,serviceHour,c,t);
              t.getMyAppoinments().add(p); 
              c.getMyAppoinments().add(p);
              allAppoinments.add(p);
              
          }
      }catch(Exception s){}
            
       // }
                
    }
    public static void addData(String userType){
         try{
            File file = new File(userType+".txt");
            Scanner s = new Scanner(file);
            
            while(s.hasNext()){
                String username = s.nextLine();
                String password = s.nextLine();
                String IdentityCard = s.nextLine();
                String Department = s.nextLine();
                String emailAddress = s.nextLine();
                String phoneNumber = s.nextLine();
                String mailingAddress = s.nextLine();
                s.nextLine();
                
                switch(userType){
                    case "manager":
                        Manager m = new Manager(username, password,IdentityCard,Department,emailAddress,phoneNumber,mailingAddress);
                allManager.add(m);
                break;
                    case "technician":
                Technician t = new Technician(username,password,IdentityCard,Department,emailAddress,phoneNumber,mailingAddress);
                allTechnician.add(t);
                break;
                    
                      
                }
                
            
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"file not found!");
        }
    }
} 


    


    

