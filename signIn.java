import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signIn {
     private JFrame frame;
     private JPanel mainPanel;
     public signIn(JFrame frame,JPanel mainPanel){
         this.frame=frame;
         this.mainPanel=mainPanel;
     }
     public void signInGUI(){
         frame.repaint();
         frame.revalidate();
         Font font=new Font("font",Font.BOLD,20);
         JPanel signInPanel=new JPanel();
         signInPanel.setBounds(0,0,1000,1000);
         signInPanel.setLayout(null);
         signInPanel.setBackground(Color.white);
         JPanel backPanel=new JPanel();
         backPanel.setBounds(240,120,500,600);
         backPanel.setLayout(null);
         backPanel.setBackground(Color.lightGray);
         signInPanel.add(backPanel);

         JLabel firstNameLabel=new JLabel("First name:");
         firstNameLabel.setBounds(40,10,200,50);
         firstNameLabel.setFont(font);
         backPanel.add(firstNameLabel);

         JTextField firstNameField=new JTextField();
         firstNameField.setBounds(200,5,250,50);
         backPanel.add(firstNameField);

         JLabel lastNameLabel=new JLabel("Last Name: ");
         lastNameLabel.setBounds(40,60,200,50);
         lastNameLabel.setFont(font);
         backPanel.add(lastNameLabel);

         JTextField lastNameField=new JTextField();
         lastNameField.setBounds(200,55,250,50);
         backPanel.add(lastNameField);

         JLabel username=new JLabel("User Name: ");
         username.setBounds(40,110,200,100);
         username.setFont(font);
         backPanel.add(username);

         JTextField usernameField=new JTextField();
         usernameField.setBounds(200,105,250,100);
         backPanel.add(usernameField);

         JLabel password=new JLabel("Password: ");
         password.setBounds(40,210,200,100);
         password.setFont(font);
         backPanel.add(password);

         JTextField passwordField=new JTextField();
         passwordField.setBounds(200,205,250,100);
         backPanel.add(passwordField);

         JLabel phoneNumber=new JLabel("Phone Number: ");
         phoneNumber.setFont(font);
         phoneNumber.setBounds(40,310,200,100);
         backPanel.add(phoneNumber);

         JTextField numberField=new JTextField();
         numberField.setBounds(200,305,250,100);
         backPanel.add(numberField);

         JLabel address=new JLabel("address: ");
         address.setFont(font);
         address.setBounds(40,410,200,100);
         backPanel.add(address);

         JTextField addressField=new JTextField();
         addressField.setBounds(200,405,250,100);
         backPanel.add(addressField);

         JButton enter=new JButton("Enter");
         enter.setFont(font);
         enter.setBounds(200,510,250,30);
         backPanel.add(enter);

         JButton back=new JButton("Back");
         back.setFont(font);
         back.setBounds(40,510,150,30);
         backPanel.add(back);
         back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.remove(signInPanel);
                 frame.add(mainPanel);
                 frame.revalidate();
                 frame.repaint();
             }
         });

         frame.add(signInPanel);
         frame.setLayout(null);
         frame.setVisible(true);
     }
}
