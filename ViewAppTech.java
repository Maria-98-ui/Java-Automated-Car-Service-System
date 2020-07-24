
package automativecarsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ViewAppTech extends JFrame implements ActionListener {
    private String appoinmentID;
    private String technicianName;
    private String date;
    private int time, endTime;
    private String customer, address, phone;
    private String serviceHour;
    private final String [][] columnNames={{"Appoinment ID","Appoinment Date","Appoinment time","End Time","Customer","Address","Phone","Service Hour"}};
    
    private JTable appoinmentT;
    private final DefaultTableModel techModel = new DefaultTableModel(columnNames[0],0);
    
    private JScrollPane appoinmentScroll;
    private JLabel l;
    
    public ViewAppTech(){
        try{
            if(AutomativeCarSystem.logint.getDepartment().equals("Technician")){
                appoinmentT = new JTable(techModel);
                setallData(AutomativeCarSystem.allAppoinments);
                
            }else{
                JOptionPane.showMessageDialog(null,"Sorry no appoinments yet");
            }
            
        }catch(Exception e){
           
        }
        
        setSize(1200,500);
        setLocation(400,400);
        
        l = new JLabel("Appoinments Dashboard");
        l.setBounds(10,10,200,25);
        
        appoinmentScroll = new JScrollPane(appoinmentT);
        appoinmentScroll.setBounds(50,50,1000,500);
        add(l);
        add(appoinmentScroll);
        setLayout(null); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         
    }
    
    public final void setallData(ArrayList<Appoinments>appoinment){
        for(int i=0;i<AutomativeCarSystem.allAppoinments.size();i++){
            if(AutomativeCarSystem.logint.getUsername().equals(AutomativeCarSystem.allAppoinments.get(i).getT().getUsername())){
                appoinmentID = AutomativeCarSystem.allAppoinments.get(i).getAppoinmentID();
                date = AutomativeCarSystem.allAppoinments.get(i).getDate();
                time = AutomativeCarSystem.allAppoinments.get(i).getTime();
                endTime = AutomativeCarSystem.allAppoinments.get(i).getEndTime();
                customer = AutomativeCarSystem.allAppoinments.get(i).getC().getFullnameC();
                address = AutomativeCarSystem.allAppoinments.get(i).getC().getMailingAdd();
                phone = AutomativeCarSystem.allAppoinments.get(i).getC().getPhoneNum();
                serviceHour = AutomativeCarSystem.allAppoinments.get(i).getServiceHour();
                Object[] detail ={appoinmentID,date,time,endTime,customer,address,phone,serviceHour};
                techModel.addRow(detail);
                
                
                
            }
        }
    }
    
    
}
 