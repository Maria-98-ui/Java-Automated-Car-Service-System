
package automativecarsystem;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class paymentFeed extends JFrame implements ActionListener {
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
    
    JButton pay = new JButton("payment");
    JButton generate = new JButton("Generate Feedback");
    JTextField a = new JTextField();
    JLabel feed = new JLabel("feedback:");
    
    public paymentFeed(){
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
        l.setBounds(20,20,200,25);
        
        pay.setBounds(180,120,165,23);
        pay.addActionListener(this);
        
        generate.setBounds(20,120,165,23);
        generate.addActionListener(this);
        a.setBounds(180,200,300,23);
        feed.setBounds(60,200,165,23);
        
        appoinmentScroll = new JScrollPane(appoinmentT);
        appoinmentScroll.setBounds(50,50,1000,500);
        add(l);
        add(pay);
        add(generate);
        add(feed);
        add(a);
        add(appoinmentScroll);
        setLayout(null); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==pay){
            int bookingid = appoinmentT.getSelectedRow();
            int duration = (AutomativeCarSystem.logint.getMyAppoinments().get(bookingid).getEndTime())-
                    (AutomativeCarSystem.logint.getMyAppoinments().get(bookingid).getTime());
            
                  int mycharge = duration*50;
                  
                  String bill = JOptionPane.showInputDialog("please pay" +mycharge);
                  int a = Integer.parseInt(bill);
                  
                  AutomativeCarSystem.allAppoinments.get(bookingid).setCharge(a);
                  AutomativeCarSystem.logint.getMyAppoinments().get(bookingid).setCharge(a);
                  
                  JOptionPane.showMessageDialog(null,"You have paid the bill");
            
            
        }else if(ae.getSource()==generate){
            for(int i =0; i<AutomativeCarSystem.allAppoinments.size();i++){
               String n = a.getText();
                int bookingid = appoinmentT.getSelectedRow();
               
               
             try{
                        Document document = new Document();
                        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("receipt.pdf"));
                        document.open();
                        PdfContentByte cb = writer.getDirectContent();
                        cb.beginText();
                        BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN , BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                        cb.setFontAndSize(bf, 12);
                        cb.setRGBColorFill(0, 0, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT,"Technician:", 36, 788, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, AutomativeCarSystem.logint.getUsername(), 120, 788, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "name: ", 36, 760, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, AutomativeCarSystem.allAppoinments.get(bookingid).getC().getFullnameC(), 70, 760, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "DATE: ", 36, 730, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, AutomativeCarSystem.allAppoinments.get(i).getDate(), 120, 730, 0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "Payment: ", 36,700,0);
                        cb.showTextAligned(Element.ALIGN_LEFT,""+AutomativeCarSystem.allAppoinments.get(bookingid).getCharge(),120,700,0);
                        cb.showTextAligned(Element.ALIGN_LEFT, "Completed", 36, 670, 0);
                        
                        cb.showTextAligned(Element.ALIGN_LEFT,n,36,640,0);
                        
                       
                        cb.endText();
                        document.close();
                       
                     
                    }catch(Exception t){
                        System.out.println(t);
                    }
                    JOptionPane.showMessageDialog(null,"reciept generated!");
            
            }
        }
         
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


