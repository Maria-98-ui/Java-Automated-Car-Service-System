
package automativecarsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ViewAppoinment extends JFrame implements ActionListener {
    private String appoinmentID;
    private String technicianName;
    private String date;
    private int time, endTime;
    private String customer, address, phone;
    private String serviceHour;
    private final String [][] columnNames = {{"Appoinment ID", "Appoinment Date", "Appoinment Time","End time" ,"Customer","Address","Phone","Technician","Servive Hour"}};
     
//setting column names as per as txt file
 
    
    private JTable appoinmentT; //create JTable
    private final DefaultTableModel managerModel = new DefaultTableModel(columnNames[0],0);//setting the table and columns, giving [0],0 index to a column
    //if there are two columns, or table then the second table will be set [1],0;
    //example;
   // private final DefaultTableModel techModel = new DefaultTableModel(columnNames[1],0);
    
    private JScrollPane appoinmentScroll; //scroll pane for the table
    private JLabel l;
    
    public ViewAppoinment(){
        try{
            if(AutomativeCarSystem.loginM.getDepartment().equals("Manager")){ //initiating manager table
                appoinmentT = new JTable(managerModel); 
                setData(AutomativeCarSystem.allAppoinments); //initiate a method setData to add appoinments details
                
            }
            
        }catch(Exception e){}
        
        setSize(1200,500);
        setLocation(400,400);
        
        l = new JLabel("Appoinments Dashboard");
        l.setBounds(10,10,200,25);
        
        appoinmentScroll = new JScrollPane(appoinmentT);//adding scrollpane to table
        appoinmentScroll.setBounds(50,50,1000,500);
        add(l);
        add(appoinmentScroll);
        setLayout(null);
            
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {    
    }
    //create method to add all the appoinments details in the managerModel
    public final void setData(ArrayList<Appoinments>appoinment){
        for(int i =0; i<AutomativeCarSystem.allAppoinments.size();i++){
           appoinmentID = AutomativeCarSystem.allAppoinments.get(i).getAppoinmentID();
           date = AutomativeCarSystem.allAppoinments.get(i).getDate();
           time = AutomativeCarSystem.allAppoinments.get(i).getTime();
           endTime = AutomativeCarSystem.allAppoinments.get(i).getEndTime();
           customer = AutomativeCarSystem.allAppoinments.get(i).getC().getFullnameC();
           address = AutomativeCarSystem.allAppoinments.get(i).getC().getMailingAdd();
           phone = AutomativeCarSystem.allAppoinments.get(i).getC().getPhoneNum();
           technicianName = AutomativeCarSystem.allAppoinments.get(i).getT().getUsername();
           serviceHour = AutomativeCarSystem.allAppoinments.get(i).getServiceHour();
           Object[] details = {appoinmentID,date,time,endTime,customer,address,phone,technicianName,serviceHour};
           //creating an Object for the details
           managerModel.addRow(details);
           //adding rows 
        } 
    }
    
    
    
    
}
