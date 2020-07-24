
package automativecarsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI1 extends JFrame implements ActionListener  {
  JButton login;
  JLabel userName , pass,iCon;
  final JTextField userText,passText; 
  private ButtonGroup user;
  JRadioButton Manager = new JRadioButton("Manager");
  JRadioButton Technician = new JRadioButton("Technician");
    
    public GUI1(){
        iCon = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\login.png");
        //ImageIcon Image = ImageIcon.getImage();
        iCon.setIcon(icon);
        
        setTitle("LOGIN FORM");
        setLayout(null);
        userName = new JLabel();
        userName.setText("Username: ");
        userText = new JTextField();
        
        pass = new JLabel();
        pass.setText("Password:");
        passText = new JPasswordField(3);
        
//        JRadioButton Manager = new JRadioButton("Manager");
//        JRadioButton Technician = new JRadioButton("Technician");
        login = new JButton("LOGIN");
       // logout = new JButton("LOGOUT");
        
        iCon.setBounds(380,50,50,30);
        userName.setBounds(350,100,100,20);
        userText.setBounds(450,100,200,20);
        pass.setBounds(350,130,100,20);
        passText.setBounds(450,130,200,20);
        Manager.setBounds(350,200,100,20);
        Technician.setBounds(450,200,100,20);
        login.setBounds(450,160,100,20);
      
        
        add(iCon);
        add(userName);
        add(userText);
        add(pass);
        add(passText);
        add(Manager);
        add(Technician);
        add(login);
      
        
        login.addActionListener(this);
        user = new ButtonGroup();
        user.add(Manager);
        user.add(Technician);
        
        setVisible(true);
        setSize(750,400);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            if(Manager.isSelected() || Technician.isSelected()){
                boolean flag = false;
                String position = "";
                String x = userText.getText();
                String y = passText.getText();
                if(x.equals("") || y.equals("")){
                    JOptionPane.showMessageDialog(null,"Sorry, cannot leave the field empty");
               
                }else{
                    if(x.equals("manager") && y.equals("manager")){
                        flag = true;
                        Manager m = new Manager("manger","manager","0","0","0","0","0");
                        AutomativeCarSystem.loginM = m;
                        position = "Manager"; 
                    }
                    for(int i=0; i <AutomativeCarSystem.allManager.size();i++){
                        if(AutomativeCarSystem.allManager.get(i).getUsername().equals(x)&&AutomativeCarSystem.allManager.get(i).getPassword().equals(y)){
                            flag = true;
                            AutomativeCarSystem.loginM = AutomativeCarSystem.allManager.get(i);
                            position = "Manager";
                            break;
                        }
                    }
                    for(int i =0; i<AutomativeCarSystem.allTechnician.size();i++){
                        if(AutomativeCarSystem.allTechnician.get(i).getUsername().equals(x)&&AutomativeCarSystem.allTechnician.get(i).getPassword().equals(y)){
                            flag = true;
                            AutomativeCarSystem.logint = AutomativeCarSystem.allTechnician.get(i);
                            position = "Technician";
                            break;
                        }
                        
                }
                    if(flag){
                        userText.setText("");
                        passText.setText("");
                        setVisible(false);
                        if(position.equals("Manager")){
                            AutomativeCarSystem.page2.setVisible(true);
                        }
                        else if(position.equals("Technician")){
                        AutomativeCarSystem.page3.setVisible(true);
                    }
                    }
                    else{
                        userText.setText("");
                        passText.setText("");
                        JOptionPane.showMessageDialog(this, "Wrong username or password!","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    
                
            }
                
            }
        }
        
        
    
}
}
    

   //}
//}
            
        
    

    
        
    
    
    
       


