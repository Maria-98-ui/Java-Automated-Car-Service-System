
package automativecarsystem;



import static automativecarsystem.AutomativeCarSystem.addData;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Handler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class UpdateManagerr extends JFrame implements ActionListener{
    JFrame frame;
    JTable table;
    
    Object[] columns = {"Username", "Password", "ID", "Department", "Email Address", "Phone number", "Mailing address"};
    DefaultTableModel model;
    
    Font font;
    JTextField textUserName;
    JTextField textPass;
    JTextField Id;
    JTextField Department;
    JTextField EmailAdd;
    JTextField Phonenum;
    JTextField Mailingadd;
    
    JLabel labelUserName;
    JLabel labelPass;
    JLabel labelId;
    JLabel labelDepartment;
    JLabel labelEmailadd;
    JLabel labelPhonenum;
    JLabel labelMailingadd;
    
    JButton buttonDelete = new JButton("Delete");
    JButton buttonUpdate = new JButton("Edit");
    
    JScrollPane pane;
    
    Object[] rowData;
    
    Manager mEdit;
    Manager mDelete;
    
    public UpdateManagerr(){
        setSize(900,950);
        
        mEdit = null;
        mDelete = null;
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
        
        labelUserName = new JLabel("User Name: ");
        labelPass = new JLabel("User Name: ");
        labelId= new JLabel("ID: ");
        labelDepartment = new JLabel("Department: ");
        //labelId = new JLabel("ID : ");
        labelEmailadd = new JLabel("Email Address: ");
        labelPhonenum = new JLabel("Phone number : ");
        labelMailingadd = new JLabel("Mailing Address: ");
           
            textUserName = new JTextField();
            textPass = new JTextField();
            Id = new JTextField();
            Department = new JTextField();
            EmailAdd = new JTextField();
            Phonenum = new JTextField();
            Mailingadd = new JTextField();
            
            add(buttonDelete);
            add(buttonUpdate);
            
            
            labelUserName.setBounds(20, 220, 100, 25);
            labelPass.setBounds(20, 250, 100, 25);
            labelId.setBounds(20, 280, 100, 25);
            labelDepartment.setBounds(20, 310, 100, 25);
            labelEmailadd.setBounds(20, 340, 100, 25);
            labelPhonenum.setBounds(20, 370, 100, 25);
            labelMailingadd.setBounds(20, 400, 100, 25);
           
            textUserName.setBounds(130, 220, 100, 25);
            textPass.setBounds(130, 250, 100, 25);
            Id.setBounds(130, 280, 100, 25);
            Department.setBounds(130, 310, 100, 25);
            EmailAdd.setBounds(130, 340, 100, 25);
            Phonenum.setBounds(130, 370, 100, 25);
            Mailingadd.setBounds(130, 400, 100, 25);
        
            
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
            add(labelUserName);
            add(labelPass);
            add(labelId);
            add(labelDepartment);
            add(labelEmailadd);
            add(labelPhonenum);
            add(labelMailingadd);
            
            
            add(textUserName);
            add(textPass);
            add(Id);
            add(Department);
            add(EmailAdd);
            add(Phonenum);
            add(Mailingadd);
        
            
            
            rowData = new Object[7]; // set the rows according to the number of customers
            for(int i = 0; i < AutomativeCarSystem.allManager.size(); i++){
                rowData[0] = AutomativeCarSystem.allManager.get(i).getUsername();
                rowData[1] = AutomativeCarSystem.allManager.get(i).getPassword();
                rowData[2] = AutomativeCarSystem.allManager.get(i).getIdentityCard();
                rowData[3] = AutomativeCarSystem.allManager.get(i).getDepartment();
                rowData[4] = AutomativeCarSystem.allManager.get(i).getEmailAddress();
                rowData[5] = AutomativeCarSystem.allManager.get(i).getPhoneNumber();
                rowData[6] = AutomativeCarSystem.allManager.get(i).getMailingAddress();
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
                mEdit = AutomativeCarSystem.allManager.get(i);
                
                if(i>=0){
                   model.setValueAt(textUserName.getText(), i, 0);
                   model.setValueAt(textPass.getText(), i, 1);
                   model.setValueAt(Id.getText(), i, 2);
                   model.setValueAt(Department.getText(), i, 3);
                   model.setValueAt(EmailAdd.getText(), i, 4);
                   model.setValueAt(Phonenum.getText(), i, 5);
                   model.setValueAt(Mailingadd.getText(), i, 6);
       
                   
                   mEdit.setUsername(textUserName.getText());
                   mEdit.setPassword(textPass.getText());
                   mEdit.setIdentityCard(Id.getText());
                   mEdit.setDepartment(Department.getText());
                   mEdit.setEmailAddress(EmailAdd.getText());
                   mEdit.setPhoneNumber(Phonenum.getText());
                   mEdit.setMailingAddress(Mailingadd.getText());
                    System.out.println(mEdit.getEmailAddress());
                   
                   new printWriting();
                  //addData("manager");
                   JOptionPane.showMessageDialog(null,"Update Successfull!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Update not successfull");
                }
       
    }  if(ae.getSource()==buttonDelete){
        int i = table.getSelectedRow();
        if(i>=0){
            model.removeRow(i);
            AutomativeCarSystem.allManager.remove(i);
            new printWriting();
            JOptionPane.showMessageDialog(null,"Manager removed successfully");
            
        }else{
            JOptionPane.showMessageDialog(null,"Manager did not get removed");
        }
    }
          
}
     class Handler extends MouseAdapter{
           @Override
           public void mousePressed(MouseEvent mvt){
               int i = table.getSelectedRow();
                for(int j=0;j<AutomativeCarSystem.allManager.size();j++){ //checks the whole size of login 
                        if(AutomativeCarSystem.allManager.get(i).getUsername().equals(textUserName.getText())){ 
                            mEdit = AutomativeCarSystem.allManager.get(j); //assign login as the specific customer object
                            break;
                        }
                }
                
                 textUserName.setText(model.getValueAt(i, 0).toString());
                 textPass.setText(model.getValueAt(i, 1).toString());
                 Id.setText(model.getValueAt(i, 2).toString());
                 Department.setText(model.getValueAt(i, 3).toString()); 
                 EmailAdd.setText(model.getValueAt(i, 4).toString());
                 Phonenum.setText(model.getValueAt(i, 5).toString());
                 Mailingadd.setText(model.getValueAt(i, 6).toString());
                

           }
     }
}
           
       
    

        

