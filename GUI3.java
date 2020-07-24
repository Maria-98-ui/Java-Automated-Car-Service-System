
package automativecarsystem;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI3 extends JFrame implements ActionListener {
    private Button checkIndSchedule,provideFeedback, logout;
            
    public GUI3(){
        setSize(400,200);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkIndSchedule = new Button("Check Schedule");
        provideFeedback = new Button(" process payment & Provide Feedback");
        logout = new Button("Logout");
        checkIndSchedule.addActionListener(this);
        provideFeedback.addActionListener(this); 
        logout.addActionListener(this);
        setLayout(new FlowLayout());
        JLabel lbl = new JLabel("WELCOME TO HOMEPAGE", JLabel.CENTER);
        lbl.setBackground(Color.PINK);
        //lbl.setOpaque(true);
       // add(ViewCust);
        add(checkIndSchedule);
        add(provideFeedback);
        add(logout);
        //setVisible(true);
       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==checkIndSchedule){
           this.dispose();
           new ViewAppTech().setVisible(true);
           
       }else if(e.getSource()==provideFeedback){
           this.dispose();
           new paymentFeed().setVisible(true);
       }else if(e.getSource()==logout){
           this.dispose();
           new GUI1();
       }
    }
    

    
   
    
}
