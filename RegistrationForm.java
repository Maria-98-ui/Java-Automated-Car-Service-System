
package automativecarsystem;

//import javafx.scene.paint.Color;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;
import java.security.SecureRandom;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class RegistrationForm extends GUI2 implements MouseListener{
    
     
    
    private Container c;
    
    JComboBox typesComboBox = new JComboBox();     
    JLabel nameLabel=new JLabel("Name");
    JLabel EmailaddLabel = new JLabel("Email Address");
    JLabel PhonenumLabel = new JLabel("Phone Number");
    JLabel MailingaddLabel = new JLabel("Mailing Address");
    JTextField nameTextField =new JTextField();
    JTextField EmailaddTextField=new JTextField();
    JTextField PhonenumTextField = new JTextField();
    JTextField MailingaddTextField = new JTextField();
    JLabel Combobox = new JLabel("Type of Vehicle:");
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton= new JButton("RESET");
    JButton close = new JButton("CLOSE");
    JCheckBox promo = new JCheckBox("Send Email Promotions?");
    JLabel GoBack = new JLabel("Go Back To Previous Page?");
    
    

    
    RegistrationForm(){
        createWindow();
        setLocationAndSize();
        addComponentToFrame();
        add(GoBack);
        this.addMouseListener(this);
        //JComboBox typesComboBox = new JComboBox();
        typesComboBox.addItem("TRUCK");
        typesComboBox.addItem("VAN");
        typesComboBox.addItem("CAR");
        typesComboBox.addItem("BUSS");
        typesComboBox.setSelectedItem(null);
        typesComboBox.setBounds(180,250,90,23);
        c.add(typesComboBox);
     
    }
    public void createWindow(){
        
        setTitle("Customer Registration");
        setBounds(60,60,500,800);
        getContentPane().setBackground(Color.CYAN);
        c = getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
     
    }
    public void setLocationAndSize(){
        
        nameLabel.setBounds(20,20,40,70);
        EmailaddLabel.setBounds(20,50,100,70);
        PhonenumLabel.setBounds(20,120,100,70);
        MailingaddLabel.setBounds(20,150,100,70);
        Combobox.setBounds(20,230,100,70);
        nameTextField.setBounds(180,43,165,23);
        EmailaddTextField.setBounds(180,70,165,23);
        PhonenumTextField.setBounds(180,143,165,23);
        MailingaddTextField.setBounds(180,200,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
        close.setBounds(300,400,100,35);
        promo.setBounds(20,500,300,35);
        GoBack.setBounds(220,600,400,35);  
    }
    public void addComponentToFrame(){
        c.add(nameLabel);
        c.add(EmailaddLabel);
        c.add(PhonenumLabel);
        c.add(MailingaddLabel);
        c.add(Combobox);
        c.add(nameTextField);
        c.add(EmailaddTextField);
        c.add(PhonenumTextField);
        c.add(MailingaddTextField);
        c.add(registerButton);
        c.add(resetButton);
        c.add(close);
        c.add(promo);
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        close.addActionListener(this);
         
    }
       public void actionPerformed(ActionEvent e){
       if(e.getSource()==registerButton){
               boolean flag = false;
               String name = nameTextField.getText();
               for(int i=0; i<AutomativeCarSystem.allCustomer.size();i++){
                   if(AutomativeCarSystem.allCustomer.get(i).getFullnameC().equals(name)){
                      
                       flag = true;
                       break;
                   }
               }
               
               if(nameTextField.getText().equals("") ||  EmailaddTextField.getText().equals("") || PhonenumTextField.getText().equals("") || MailingaddTextField.getText().equals("")){
                   JOptionPane.showMessageDialog(this,"Please Fill in all the required fields.");
                  
               }else if (!AutomativeCarSystem.isInt(PhonenumTextField.getText())){
                   JOptionPane.showMessageDialog(null, "Please enter digits only for phone number");
                           
                }  
                if(flag){
                   JOptionPane.showMessageDialog(null,"This name already exists!","ERROR",JOptionPane.ERROR_MESSAGE);
               }else{
                   String value = (String)typesComboBox.getSelectedItem();
                   SecureRandom r = new SecureRandom();
                   int random = r.nextInt((9999-1000)+1)+1000;
                   String id = Integer.toString(random);
                   JOptionPane.showMessageDialog(null,"ID number is: " + id);
                   String mail = EmailaddTextField.getText();
                   String phone = PhonenumTextField.getText();
                   String Add = MailingaddTextField.getText();
                   Customer customer = new Customer(name,id,mail,phone,Add,value);
                   AutomativeCarSystem.allCustomer.add(customer);
                                      
               }
                printWriting.custWriteDetails();
                  
          }else if(e.getSource()== resetButton){
           String def = "";
           nameTextField.setText(def);
           EmailaddTextField.setText(def);
           PhonenumTextField.setText(def);
           MailingaddTextField.setText(def);
         
     } else if(e.getSource()==close){
         System.exit(0);
     }
        
       } 
  
     public void mouseClicked(MouseEvent me) {
        new GUI2().setVisible(true);
        this.dispose(); 
         
    }

    
    public void mousePressed(MouseEvent me) {}
    
    public void mouseReleased(MouseEvent me) {}
      
    public void mouseEntered(MouseEvent me) {}
        
    public void mouseExited(MouseEvent me) {}
       
}
    
       
     
         
     
     
       
        
    
      
    
    
               
                   
               
       

           
       
                
    
        

            
        
       
        
        //else if(e.getSource()==registerButton){
           // boolean flag = false;
          //  String typesComboBox = (String) combo.getSelectedItem()
        
        
    

