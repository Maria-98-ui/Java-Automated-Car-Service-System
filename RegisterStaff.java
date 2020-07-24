
package automativecarsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;
import java.security.SecureRandom;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
//import static jdk.nashorn.internal.runtime.Debug.id;


public class RegisterStaff extends GUI2 implements MouseListener{
    
    
   private Container s;
   private ButtonGroup Department;
   JLabel usernameLabel=new JLabel("username");
   JLabel password = new JLabel("Password");
   //JLabel identitycardLabel = new JLabel("Identity Card");
   JLabel EmailaddLabel = new JLabel("Email Address");
   JLabel DepartmenttypeLabel = new JLabel("Department");
   //JLabel staffSpecLabel = new JLabel("Staff Specification");
   JLabel PhonenumbLabel = new JLabel("Phone Number");
   JLabel MailingaddLabel=new JLabel("Mailing Address");
  
   JTextField nameTextField =new JTextField();
   JTextField passTextField = new JTextField();
   //JTextField IdentitycardField=new JTextField();
   JTextField EmailaddTextField=new JTextField();
  // JTextField DepartmenttypeTextField=new JTextField();
   JRadioButton Manager = new JRadioButton("Manager");
   JRadioButton Technician = new JRadioButton("Technician");
   //JRadioButton shiftWorker = new JRadioButton("Shift Worker");
  // JTextField staffSpecTextField= new JTextField();
   JTextField PhonenumTextField = new JTextField();
   JTextField MailingaddTextField = new JTextField();
   JCheckBox TermsAndCondition = new JCheckBox("Terms And Conditions");
   JButton registerButton=new JButton("REGISTER");
   
   JButton resetButton= new JButton("RESET");
   JButton close = new JButton("Close");
   JCheckBox promo = new JCheckBox("");
   JLabel GoBack = new JLabel("Go Back To Previous Page?");
  
 
  public RegisterStaff(){
      createWindow();
      setLocationAndSize();
      addComponentToFrame();
      add(GoBack);
      setVisible(true);
      this.addMouseListener(this);
       
   }
    public void createWindow(){
       setTitle("Staff Registration");
       setBounds(60,60,500,800);
       getContentPane().setBackground(Color.LIGHT_GRAY);
       s = getContentPane();
       s.setLayout(null);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
   public void setLocationAndSize(){
      usernameLabel.setBounds(20,20,70,70);
      password.setBounds(20,50,60,70);
      EmailaddLabel.setBounds(20,120,100,70);
      DepartmenttypeLabel.setBounds(20,150,200,70); 
      PhonenumbLabel.setBounds(20,270,100,70);
      MailingaddLabel.setBounds(20,320,100,70);
      nameTextField.setBounds(180,43,165,23);
      passTextField.setBounds(180,70,165,23);
      EmailaddTextField.setBounds(180,143,165,23);
      Manager.setBounds(180,200,165,23);
      Technician.setBounds(180,230,165,23);
      PhonenumTextField.setBounds(180,293,165,23);
      MailingaddTextField.setBounds(180,343,165,23);
      registerButton.setBounds(70,400,100,35);
      resetButton.setBounds(220,400,100,35);
      close.setBounds(290,400,100,35);
      promo.setBounds(20,500,300,35);
      GoBack.setBounds(220,600,400,35);
      
  }
  
  public void addComponentToFrame(){
      
      s.add(usernameLabel);
      s.add(password);
      //s.add(identitycardLabel);
      s.add(EmailaddLabel);
      s.add(DepartmenttypeLabel);
     
      s.add(PhonenumbLabel);
      s.add(MailingaddLabel);
      s.add(nameTextField);
      s.add(passTextField);
     // s.add(IdentitycardField);
      s.add(EmailaddTextField);
       // s.add(DepartmenttypeTextField);
      s.add(Manager);
      s.add(Technician);
       //s.add(shiftWorker);
      s.add(PhonenumTextField);
      s.add(MailingaddTextField);
      s.add(registerButton);
      s.add(resetButton);
      s.add(close);
       // s.add(promo);
      s.add(GoBack);
    
       registerButton.addActionListener(this);
       resetButton.addActionListener(this);
       close.addActionListener(this);
       Department = new ButtonGroup();
       Department.add(Manager);
       Department.add(Technician);
       

   }


   public void mouseExited(MouseEvent me) {}
       
  

    @Override
    public void mouseClicked(MouseEvent me) {
       new GUI2().setVisible(true);
        this.dispose(); 
    
    }

    @Override
    public void mousePressed(MouseEvent me) {}
        
    

    @Override
    public void mouseReleased(MouseEvent me) {}
        
    

    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==registerButton){
            //String radioText =null;
            if(Manager.isSelected()){
                String radioText =null;
                radioText = Manager.getText();
                boolean flag = false;
                String username = nameTextField.getText();
                for(int i=0;i<AutomativeCarSystem.allManager.size();i++){
                if(AutomativeCarSystem.allManager.get(i).getUsername().equals(username)){
                    flag = true;
                    break;
                }
            }
            if(nameTextField.getText().equals("") || passTextField.getText().equals("")||EmailaddTextField.getText().equals("") || PhonenumTextField.getText().equals("") || MailingaddTextField.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please Fill in all the required fields");
            }
            if(flag){
                JOptionPane.showMessageDialog(null,"Name already exists.");
                
            }else{
                //String radioText = null;
                
                String pass = passTextField.getText();
                SecureRandom r = new SecureRandom();
                int rand = r.nextInt((9999-1000)+1)+1000;
                String id = Integer.toString(rand);
                JOptionPane.showMessageDialog(null,"ID number is: "+id);
                //String id = IdentitycardField.getText();
                String emailAddress = EmailaddTextField.getText();
                String phoneNum = PhonenumTextField.getText();
                String Mailingadd = MailingaddTextField.getText();
                Manager m = new Manager(username,pass,id,radioText,emailAddress,phoneNum,Mailingadd);
                AutomativeCarSystem.allManager.add(m);
            }
            new printWriting();
            }
            
            else if(Technician.isSelected()){
               String r = null;
               r=Technician.getText();
               
                boolean success = false;
                String user = nameTextField.getText();
                for(int i=0;i<AutomativeCarSystem.allTechnician.size();i++){
                if(AutomativeCarSystem.allTechnician.get(i).getUsername().equals(user)){
                    success = true;
                    break;
                }
                }
                
                String pass = passTextField.getText();
                SecureRandom ry = new SecureRandom();
                int rand = ry.nextInt((9999-1000)+1)+100;
                String id = Integer.toString(rand);
                JOptionPane.showMessageDialog(null,"ID number is: " + id);
                String emailAddress = EmailaddTextField.getText();
                String phoneNum = PhonenumTextField.getText();
                String Mailingadd = MailingaddTextField.getText();
                Technician t = new Technician(user,pass,id,r,emailAddress,phoneNum,Mailingadd);
                AutomativeCarSystem.allTechnician.add(t);
                }
                printWriting.techWriteDetails();
             
            }
            
        else if(e.getSource()==resetButton){
        String def = "";
        nameTextField.setText(def);
        passTextField.setText(def);
        EmailaddTextField.setText(def);
        PhonenumTextField.setText(def);
        MailingaddTextField.setText(def);
    }else if(e.getSource()==close){
        System.exit(0);
    }
        
    
        
    }
}
