
package automativecarsystem;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI2 extends JFrame implements ActionListener{

    private Button registerCustomer, registerStaff,updateManager,updateTech, updateCust, book,ViewApp,logout;
  
    public GUI2(){
        setSize(400,200);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerCustomer = new Button("Register Customer");
        registerStaff = new Button("Register Staff");
        //registerStaff = new Button("Register Staff");
      //  Update = new Button("Update");
        updateManager = new Button("Update Manager");
        updateTech = new Button("Update Technician");
        updateCust = new Button("Update Customer");
        book = new Button("Book");
        ViewApp = new Button("View Appoinment");
       // assignTech = new Button("Assign Technician");
        //addManager = new Button("Add Manager");
        logout = new Button("LOGOUT");
        registerCustomer.addActionListener(this);
        registerStaff.addActionListener(this);
       // Update.addActionListener(this);
        updateManager.addActionListener(this);
        updateTech.addActionListener(this);
        updateCust.addActionListener(this);
        book.addActionListener(this);
        ViewApp.addActionListener(this);
        logout.addActionListener(this);
        
        setLayout(new FlowLayout());
        
        
        JLabel lbl = new JLabel("WELCOME TO HOMEPAGE",JLabel.CENTER);
        lbl.setBackground(Color.BLUE);
        //lbl.setOpaque(true);
        add(lbl);
        add(registerCustomer);
        add(registerStaff);
       // add(Update);
        add(updateManager);
        add(updateTech);
        add(updateCust);
        add(book);
        add(ViewApp);
        add(logout);
        //add(lbl);
       //setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerCustomer){
           this.dispose();
           new RegistrationForm().setVisible(true);
                    
            
        }if(e.getSource()==registerStaff){
           this.dispose();
            new RegisterStaff().setVisible(true);
            
        }if(e.getSource()==logout){
            this.dispose();
            new GUI1();
            
       
            
        }if(e.getSource()==book){
            this.dispose();
            new Booking().setVisible(true);
            
        }if(e.getSource()==ViewApp){
            this.dispose();
            new ViewAppoinment().setVisible(true);
            
        }if(e.getSource()==updateManager){
            this.dispose();
            new UpdateManagerr().setVisible(true);
            
        }if(e.getSource()==updateTech){
            this.dispose();
            new updateTech().setVisible(true);
            
        }if(e.getSource()==updateCust){
            this.dispose();
            new updateCustomer().setVisible(true);
        }
        
        
        }
    }
    
    

