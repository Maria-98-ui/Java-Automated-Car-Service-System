
package automativecarsystem;

import automativecarsystem.UpdateManagerr.Handler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class updateCustomer extends JFrame implements ActionListener {
    JFrame frame;
    JTable table;
    
    Object[] columns = {"Name", "ID", "Email Address", "Phone number", "Mailing address", "Type of car"};
    DefaultTableModel model;
    
    Font font;
    JTextField textName;
    JTextField Id;
    JTextField EmailAdd;
    JTextField Phonenum;
    JTextField Mailingadd;
    JTextField typeCar;
    
    JLabel labelName;
    JLabel labelId;
    JLabel labelEmailadd;
    JLabel labelPhonenum;
    JLabel labelMailingadd;
    JLabel typeCarl;
    
    JButton buttonDelete = new JButton("Delete");
    JButton buttonUpdate = new JButton("Edit");
    
    JScrollPane pane;
    
    Object[] rowData;
    
    Customer cEdit;
    Customer cDelete;
    

    public updateCustomer(){
        setSize(900,950);
        
        cEdit = null;
        cDelete = null;
        table = new JTable();  //create new table
        model = new DefaultTableModel(); //create new model
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        
        font = new Font("",1,10);
        table.setFont(font);
        table.setRowHeight(30);
        Handler myMouseListener = new Handler();
        table.addMouseListener(myMouseListener);
        
        labelName = new JLabel("User Name: ");
        labelId= new JLabel("ID: ");
        labelEmailadd = new JLabel("Email Address: ");
        labelPhonenum = new JLabel("Phone number : ");
        labelMailingadd = new JLabel("Mailing Address: ");
        typeCarl = new JLabel("Car Type: ");
           
            textName = new JTextField();
            Id = new JTextField();
            EmailAdd = new JTextField();
            Phonenum = new JTextField();
            Mailingadd = new JTextField();
            typeCar = new JTextField();
            
            add(buttonDelete);
            add(buttonUpdate);
            
            
            labelName.setBounds(20, 220, 100, 25);
            labelId.setBounds(20, 250, 100, 25);
            labelEmailadd.setBounds(20, 280, 100, 25);
            labelPhonenum.setBounds(20, 310, 100, 25);
            labelMailingadd.setBounds(20, 340, 100, 25);
            typeCarl.setBounds(20,370,100,25);
           
            textName.setBounds(130, 220, 100, 25);
            Id.setBounds(130, 250, 100, 25);
            EmailAdd.setBounds(130, 280, 100, 25);
            Phonenum.setBounds(130, 310, 100, 25);
            Mailingadd.setBounds(130, 340, 100, 25);
            typeCar.setBounds(130,370,100,25);
        
            
            buttonDelete.setBounds(250, 220, 100, 25);
            buttonDelete.setVisible(true);
            buttonUpdate.setBounds(250, 265, 100, 25);
            buttonUpdate.setVisible(true);
            buttonDelete.setBounds(250, 310, 100, 25);
            buttonDelete.setVisible(true);
            
            pane = new JScrollPane(table);
            pane.setVisible(true);
            pane.setBounds(0, 0, 880, 200);
            
            
            add(pane);
            add(labelName);
            add(labelId);
            add(labelEmailadd);
            add(labelPhonenum);
            add(labelMailingadd);
            add(typeCarl);
            
            
            add(textName);
            add(Id);
            add(EmailAdd);
            add(Phonenum);
            add(Mailingadd);
            add(typeCar);
        
            
            
            rowData = new Object[6]; // set the rows according to the number of customers
            for(int i = 0; i < AutomativeCarSystem.allCustomer.size(); i++){
                rowData[0] = AutomativeCarSystem.allCustomer.get(i).getFullnameC();
                rowData[1] = AutomativeCarSystem.allCustomer.get(i).getIdentitycardC();
                rowData[2] = AutomativeCarSystem.allCustomer.get(i).getEmailAdd();
                rowData[3] = AutomativeCarSystem.allCustomer.get(i).getPhoneNum();
                rowData[4] = AutomativeCarSystem.allCustomer.get(i).getMailingAdd();
                rowData[5] = AutomativeCarSystem.allCustomer.get(i).getTypeOfCar();
               
                model.addRow(rowData);
                
                
    }
            buttonDelete.addActionListener(this);
            buttonUpdate.addActionListener(this);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
    }      
    
        
    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == buttonUpdate){
             // i = the index of the selected row
                int i = table.getSelectedRow();
                cEdit = AutomativeCarSystem.allCustomer.get(i);
                
                if(i>=0){
                   model.setValueAt(textName.getText(), i, 0);
                   model.setValueAt(Id.getText(), i, 1);
                   model.setValueAt(EmailAdd.getText(), i, 2);
                   model.setValueAt(Phonenum.getText(), i, 3);
                   model.setValueAt(Mailingadd.getText(), i, 4);
                   model.setValueAt(typeCar.getText(),i,5);
       
                   
                   cEdit.setFullnameC(textName.getText());
                   cEdit.setIdentitycardC(Id.getText());
                   cEdit.setEmailAdd(EmailAdd.getText());
                   cEdit.setPhoneNum(Phonenum.getText());
                   cEdit.setMailingAdd(Mailingadd.getText());
                   cEdit.setTypeOfCar(typeCar.getText());
                    //System.out.println(cEdit.getEmailAddress());
                   
                   printWriting.custWriteDetails();
                  //addData("manager");
                   JOptionPane.showMessageDialog(null,"Update Successfull!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Update not successfull");
                }
        
    }if(ae.getSource()==buttonDelete){
        int i = table.getSelectedRow();
        if(i>=0){
            model.removeRow(i);
            AutomativeCarSystem.allCustomer.remove(i);
            printWriting.custWriteDetails();
            JOptionPane.showMessageDialog(null,"Customer removed successfully");
            
        }else{
            JOptionPane.showMessageDialog(null,"Customer did not get removed");
        }
    }
    }
    
     class Handler extends MouseAdapter{
           @Override
           public void mousePressed(MouseEvent mvt){
               int i = table.getSelectedRow();
                for(int j=0;j<AutomativeCarSystem.allCustomer.size();j++){ //checks the whole size of login 
                        if(AutomativeCarSystem.allCustomer.get(i).getFullnameC().equals(textName.getText())){ 
                            cEdit = AutomativeCarSystem.allCustomer.get(j); //assign login as the specific customer object
                            break;
                        }
                }
                
                 textName.setText(model.getValueAt(i, 0).toString());
                 Id.setText(model.getValueAt(i, 1).toString());
                 EmailAdd.setText(model.getValueAt(i, 2).toString());
                 Phonenum.setText(model.getValueAt(i, 3).toString());
                 Mailingadd.setText(model.getValueAt(i, 4).toString());
                 typeCar.setText(model.getValueAt(i, 5).toString());
                

           }
     }
  
}
