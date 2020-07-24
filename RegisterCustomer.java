
package automativecarsystem;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RegisterCustomer extends GUI2 {
    private Container c;
    private JLabel title;
    private JComboBox boxChoices;
    private JLabel name;
    private JTextField tname;
    private JLabel IdentityCard;
    private JTextField tidentityCard;
    private JLabel Department;
    private JTextField tdepartment;
    private JLabel staffSpecification;
    private JTextField tstaffSpecification;
   // private JLabel id;
    //private JTextField tid;
    private JLabel mail;
    private JTextField tmail;
    private JLabel phone;
    private JTextField tphone;
    private JLabel Add;
    private JTextArea tAdd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    
        
    
    public RegisterCustomer(){
    setTitle("Registration Form");
    setBounds(500,100,900,700);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    
    c = getContentPane();
    c.setLayout(null);
    
    title = new JLabel("Registration Form");
    title.setFont(new Font("Calibri",Font.PLAIN, 30));
    title.setSize(300,30);
    title.setLocation(300,30);
    c.add(title);
    
   String[] boxChoices = {"Customer","Staff","Technician","Manager"};
   JComboBox types = new JComboBox(boxChoices); 
   types.setEditable(true);
   types.addActionListener(this);
    
    name = new JLabel ("Name:");
    name.setFont(new Font("Arial",Font.PLAIN,20));
    name.setSize(100,20);
    name.setLocation(100,100);
    c.add(name);
    
    tname = new JTextField();
    tname.setFont(new Font("Arial",Font.PLAIN,15));
    tname.setSize(190,20);
    tname.setLocation(200,100);
    c.add(tname);
    
    IdentityCard = new JLabel("Identity Card");
    IdentityCard.setFont(new Font("Arial",Font.PLAIN,20));
    IdentityCard.setSize(100,20);
    IdentityCard.setLocation(100,150);
    c.add(IdentityCard);
    
    tidentityCard = new JTextField();
    tidentityCard.setFont(new Font("Arial",Font.PLAIN,15));
    tidentityCard.setSize(150,20);
    tidentityCard.setLocation(200,150);
    c.add(tidentityCard);
    
    Department = new JLabel("Department");
    Department.setFont(new Font("Arial",Font.PLAIN,20));
    Department.setSize(100,20);
    Department.setLocation(100,200);
    c.add(Department);
    
    tdepartment = new JTextField();
    tdepartment.setFont(new Font("Arial",Font.PLAIN,15));
    tdepartment.setSize(150,20);
    tdepartment.setLocation(200,150);
    c.add(tdepartment);
    
    staffSpecification = new JLabel("Staff Specification: ");
    staffSpecification.setFont(new Font("Arial",Font.PLAIN,20));
    staffSpecification.setSize(100,40);
    staffSpecification.setLocation(100,250);
    c.add(staffSpecification);
    
    tstaffSpecification = new JTextField();
    tstaffSpecification.setFont(new Font("Arial",Font.PLAIN,15));
    tstaffSpecification.setSize(190,20);
    tstaffSpecification.setLocation(200,100);
    c.add(tstaffSpecification);
    
    mail = new JLabel("Email:");
    mail.setFont(new Font("Arial",Font.PLAIN,20));
    mail.setSize(100,20);
    mail.setLocation(100,150);
    c.add(mail);
    
    tmail = new JTextField();
    tmail.setFont(new Font("Arial",Font.PLAIN,15));
    tmail.setSize(150,20);
    tmail.setLocation(200,150);
    c.add(tmail);
    
    phone = new JLabel("Phone Number:");
    phone.setFont(new Font("Arial",Font.PLAIN,20));
    phone.setSize(100, 20);
    phone.setLocation(100,150);
    c.add(phone);
    
    tphone = new JTextField();
    tphone.setFont(new Font("Arial",Font.PLAIN,15));
    tphone.setLocation(200,150);
    c.add(tphone);
    
    Add = new JLabel("Address:");
    Add.setFont(new Font("Arial",Font.PLAIN,20));
    Add.setSize(100,20);
    Add.setLocation(100,300);
    c.add(Add);
    
    tAdd = new JTextArea();
    tAdd.setFont(new Font("Arial",Font.PLAIN,15));
    tphone.setSize(200, 75);
    tphone.setLocation(200,300);
    tAdd.setLineWrap(true);
    c.add(tAdd);
    
    term = new JCheckBox("Accept Terms And Conditions.");
    term.setFont(new Font("Arial",Font.PLAIN,15));
    term.setSize(250,20);
    term.setLocation(150,400);
    c.add(term);
    
    sub = new JButton("Submit");
    sub.setFont(new Font("Arial",Font.PLAIN,15));
    sub.setSize(100,20);
    sub.setLocation(150,450);
    sub.addActionListener(this);
    c.add(sub);
    
    reset = new JButton("Reset");
    reset.setFont(new Font("Arial",Font.PLAIN,15));
    reset.setSize(100,20);
    reset.setLocation(270,450);
    reset.addActionListener(this);
    c.add(reset);
    //id = new JLabel("Identity Card")   
    
}
    public void ActionPerformed(ActionEvent e){
        
        
        if(e.getSource()==sub){
            if(term.isSelected()){
               // JComboBox types = new JComboBox(boxChoices);
                String data1;
               String data
                       = "Name :"
                      +tname.getText() + "\n"
                      +"IdentityCard :"
                       +tidentityCard.getText() + "\n"
                       +"Department :"
                       +tdepartment.getText() + "\n"
                       +"Staff Specification: "
                       +tstaffSpecification.getText() + "\n";
                       //+
               
                       
                        
            }
        }
    }
}