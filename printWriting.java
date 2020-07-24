
package automativecarsystem;

import static automativecarsystem.AutomativeCarSystem.allAppoinments;
import static automativecarsystem.AutomativeCarSystem.allCustomer;
import static automativecarsystem.AutomativeCarSystem.allTechnician;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class printWriting extends JFrame implements ActionListener{

    
    
    
    public printWriting(){
        try{
               PrintWriter p = new PrintWriter("Manager.txt");
                for(int i =0;i<AutomativeCarSystem.allManager.size();i++){
                    p.println(AutomativeCarSystem.allManager.get(i).getUsername());
                    p.println(AutomativeCarSystem.allManager.get(i).getPassword());
                    p.println(AutomativeCarSystem.allManager.get(i).getIdentityCard());
                    p.println(AutomativeCarSystem.allManager.get(i).getDepartment());
                    p.println(AutomativeCarSystem.allManager.get(i).getEmailAddress());
                    p.println(AutomativeCarSystem.allManager.get(i).getPhoneNumber());
                    p.println(AutomativeCarSystem.allManager.get(i).getMailingAddress());
                    p.println();
                }
                p.close();
                    
                    
        
    }catch(Exception e){}
     
    }
    
    static void writeAppDetails(){
        
        try{
                PrintWriter pi = new PrintWriter("appoinments.txt");
                for(int v=0;v<AutomativeCarSystem. allAppoinments.size();v++){
                    pi.println(AutomativeCarSystem.allAppoinments.get(v).getAppoinmentID());
                    pi.println(AutomativeCarSystem.allAppoinments.get(v).getTime());
                    pi.println(AutomativeCarSystem.allAppoinments.get(v).getEndTime());
                    pi.println(AutomativeCarSystem.allAppoinments.get(v).getDate());
                    pi.println(AutomativeCarSystem.allAppoinments.get(v).getServiceHour());
                    pi.println(AutomativeCarSystem.allAppoinments.get(v).getC().getFullnameC());
                    pi.println(AutomativeCarSystem.allAppoinments.get(v).getT().getUsername());
                    pi.println();
                }
                //t.addAppoinment(p);
                JOptionPane.showMessageDialog(null,"Booking Successfull!");
                pi.close();
            }catch(Exception ae){}
        
       
        }
    
    static void techWriteDetails(){
        
        try{
                PrintWriter p = new PrintWriter("Technician.txt");
                for(int i =0;i<AutomativeCarSystem.allTechnician.size();i++){
                    p.println(AutomativeCarSystem.allTechnician.get(i).getUsername());
                    p.println(AutomativeCarSystem.allTechnician.get(i).getPassword());
                    p.println(AutomativeCarSystem.allTechnician.get(i).getIdentityCard());
                    p.println(AutomativeCarSystem.allTechnician.get(i).getDepartment());
                    p.println(AutomativeCarSystem.allTechnician.get(i).getEmailAddress());
                    p.println(AutomativeCarSystem.allTechnician.get(i).getPhoneNumber());
                    p.println(AutomativeCarSystem.allTechnician.get(i).getMailingAddress());
                    p.println();
                    
            }
                JOptionPane.showMessageDialog(null,"Staff Successfully registered!");
                p.close();
            
        }catch(Exception x){}
    }
    
    static void custWriteDetails(){
        try{
               PrintWriter p = new PrintWriter("Customer.txt");
               for(int i = 0;i<AutomativeCarSystem.allCustomer.size();i++){
                   p.println(AutomativeCarSystem.allCustomer.get(i).getFullnameC());
                   p.println(AutomativeCarSystem.allCustomer.get(i).getIdentitycardC());
                   p.println(AutomativeCarSystem.allCustomer.get(i).getEmailAdd());
                   p.println(AutomativeCarSystem.allCustomer.get(i).getPhoneNum());
                   p.println(AutomativeCarSystem.allCustomer.get(i).getMailingAdd());
                   p.println(AutomativeCarSystem.allCustomer.get(i).getTypeOfCar());
                   p.println();
                 
                  
                  
           }
                 JOptionPane.showMessageDialog(null,"Customer Successfully Registered!");
                 p.close();
             
           }catch(Exception ae){}
    }

        
    

    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }
    
}
