
package automativecarsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Booking extends JFrame implements ActionListener{
    private Technician t = null;
    private Customer c = null;
    private Container d;
    private ButtonGroup serviceHour;
    JComboBox customers = new JComboBox();
    private JComboBox time;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
   JComboBox technicians = new JComboBox();
    
    JLabel customersLabel = new JLabel("Customers: ");
    JLabel typeofVehicle = new JLabel("type of vehicle");
    JTextField typeofVehicleText = new JTextField();
    JLabel Time = new JLabel ("Set time");
    JLabel bookdates = new JLabel("DATE: ");
    JLabel serviceHourLabel = new JLabel("service type : ");
    JRadioButton oneHour = new JRadioButton(" 1 Hour");
    JRadioButton threeHour = new JRadioButton(" 3 Hours");
    JLabel assignTech = new JLabel ("Assign Technician: ");
    JButton book = new JButton ("BOOK");
    JButton goBack = new JButton("Go Back");
    
    private Integer times[]=
    {9,10,11,12,13,14,15,16,17,18};
    
    private String dates[]
            = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14","15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
    private String months[]
            ={ "Jan", "feb", "Mar", "Apr",
                "May", "Jun", "July", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
    
    private String years[]
            ={"1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" }; 
       
Booking(){
    createWindow();
    setLocationAndSize();
    addComponentsToFrame();
    
}
public void createWindow(){
    setTitle("Booking");
    setBounds(60,60,500,800);
    getContentPane().setBackground(Color.GRAY);
    d = getContentPane();
    d.setLayout(null);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    
}
public void setLocationAndSize(){
    customersLabel.setBounds(100,100,100,20);
    customers.setBounds(200,100,190,20);
    typeofVehicle.setBounds(100,150,100,20);
    typeofVehicleText.setBounds(200,150,150,20);
    Time.setBounds(100,200,100,20);
    time = new JComboBox(times);
    time.setBounds(200,200,75,20);
   // EndTime.setBounds(100,250,100,20);
    //EndtimeText.setBounds(200,250,75,20);
    bookdates.setBounds(100,270,100,20);
    date = new JComboBox(dates);
    date.setBounds(200,270,50,20);
    month = new JComboBox(months);
    month.setBounds(250,270,60,20);
    year = new JComboBox(years);
    year.setBounds(320,270,60,20);
    serviceHourLabel.setBounds(100,300,100,20);
    oneHour.setBounds(200,300,100,20);
    threeHour.setBounds(300,300,100,20);
    assignTech.setBounds(100,350,100,20);
    technicians.setBounds(200,350,190,20);
    book.setBounds(70,400,100,35);  
    goBack.setBounds(220,600,400,35);
}
public void addComponentsToFrame(){
    d.add(customersLabel);
    d.add(typeofVehicle);
    d.add(Time);
    d.add(time);
    d.add(bookdates);
    d.add(serviceHourLabel);
    d.add(customers);
    d.add(typeofVehicleText);
    d.add(date);
    d.add(month);
    d.add(year);
    d.add(oneHour);
    d.add(threeHour);
    d.add(assignTech);
    d.add(technicians);
    book.addActionListener(this);
    goBack.addActionListener(this);
    serviceHour = new ButtonGroup();
    serviceHour.add(oneHour);
    serviceHour.add(threeHour);
    d.add(book);
    d.add(goBack);
    typeofVehicleText.setText(AutomativeCarSystem.allCustomer.get(0).getTypeOfCar());
    typeofVehicleText.setEditable(false);
    ArrayList<String> customerArray = new ArrayList<>();
    for(int i =0; i<AutomativeCarSystem.allCustomer.size();i++){
        customerArray.add(AutomativeCarSystem.allCustomer.get(i).getFullnameC());   
    }
    customers.removeAllItems();
    customerArray.forEach((s)->{
        customers.addItem(s);
        d.add(customers);
        
    });
    ArrayList<String> techArray = new ArrayList();
    for(int i = 0;i<AutomativeCarSystem.allTechnician.size();i++){
        techArray.add(AutomativeCarSystem.allTechnician.get(i).getUsername());
    }
       technicians.removeAllItems();
       techArray.forEach((t)->{
       technicians.addItem(t);
       d.add(technicians);   
    });
    
}
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==book){
            boolean flag = false;
            
            String id;
            if(AutomativeCarSystem.allAppoinments.size()==0){
                id = "1001";
            }else{
                int size = AutomativeCarSystem.allAppoinments.size();
                Appoinments last = AutomativeCarSystem.allAppoinments.get(size-1);
                id = last.getAppoinmentID()+1;
                JOptionPane.showMessageDialog(null,"Appoinment ID is : " +id);
            }
            //JOptionPane.showMessageDialog(null,"Appoinment ID is : " +id);
            int bookingStartTime = (Integer)time.getSelectedItem();
            int duration = 1;
            String radio = null;
            if(oneHour.isSelected()){
                duration = 1;
                radio = oneHour.getText();
            }
            else if (threeHour.isSelected()){
                duration=3;
                radio = threeHour.getText();
            }
            int bookingEndTime = bookingStartTime + duration; 
                
                //String time = timeText.getText();
                //String EndTime = EndtimeText.getText();
               
                String dates = date.getSelectedItem()
                        +"/" + (String)month.getSelectedItem()
                        +"/" + (String)year.getSelectedItem();
                        
               
                    //String radio = null;
                    //if(oneHour.isSelected()){
                        //radio = "1 Hour (Normal Service)";
                                    
                    //}else{
                        //radio = "3 Hours (Major Service)";
                                
                    //}
                  
                    for(int i =0;i<AutomativeCarSystem.allTechnician.size();i++){
                        Technician a = AutomativeCarSystem.allTechnician.get(i);
                        if(technicians.getSelectedItem().toString().equals(a.getUsername())){
                            
                            t = AutomativeCarSystem.allTechnician.get(i);
                            System.out.println(t.getUsername());
                            break;
                        } 
                    }
                    boolean success = false;
                    boolean sameDayApp = false;
                    Appoinments hasSameDayApp = null;
                    ArrayList<Appoinments>hasSameDayApps = new ArrayList();
                    for(int i=0;i<t.getMyAppoinments().size();i++){
                        if(t.getMyAppoinments().get(i).getDate().equals(dates)){
                            sameDayApp=true;
                            hasSameDayApp = t.getMyAppoinments().get(i);
                            hasSameDayApps.add(hasSameDayApp);
                        }
                    }
                    
                    boolean Overlap = false;
                    if(sameDayApp){
                        for(int i =0;i<hasSameDayApps.size();i++){
                            if(((((bookingStartTime>=
                                    hasSameDayApps.get(i).getTime()))&&
                                    (bookingStartTime<= hasSameDayApps.get(i).getEndTime()))||
                                    ((bookingEndTime>=hasSameDayApps.get(i).getTime())&&
                                    (bookingEndTime<=hasSameDayApps.get(i).getEndTime()))))
                                 
                            {
                                Overlap = true;
                            }
                        }
                    }
                    else{
                        AutomativeCarSystem.assignTech=t;
                        success = true;
                        
                    }if(Overlap){
                        JOptionPane.showMessageDialog(null,t.getUsername()+"already has an appoinment!");
                    }if(!Overlap || flag){
                        AutomativeCarSystem.assignTech=t;
                    }
                    if(!Overlap || flag){
                    
                    for(int i =0;i<AutomativeCarSystem.allCustomer.size();i++){
                        Customer m = AutomativeCarSystem.allCustomer.get(i);
                        if(customers.getSelectedItem().toString().equals(m.getFullnameC())){
                            
                            c = AutomativeCarSystem.allCustomer.get(i);
                            break;
                        }
                    }
                   Appoinments p = new Appoinments(id,bookingStartTime,bookingEndTime,dates,radio,c,t);
                   //t.addAppoinment(p);
                   AutomativeCarSystem.allAppoinments.add(p);   
                   t.addAppoinment(p);
                    }
                    printWriting.writeAppDetails();
        
            }else if(e.getSource()==goBack){
                this.dispose();
                new GUI2().setVisible(true);
                
    
            }
    
    
    }
}
   
           
 


        

    
    
    
    

