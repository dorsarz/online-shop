import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager extends JFrame {
    private JFrame frame;
    private JPanel mainPanel;
    public Manager(JFrame frame,JPanel mainPanel){
        this.frame=frame;
        this.mainPanel=mainPanel;
    }
    public void setFrame(){
        frame.revalidate();
        frame.repaint();
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1000,1000);
        Font font1=new Font("font",Font.BOLD,25);
        JLabel manage=new JLabel("MANAGER");
        Font font2=new Font("font",Font.BOLD,40);
        manage.setFont(font2);
        manage.setBounds(400,30,250,60);
        panel.add(manage);

        JPanel panelBack=new JPanel();
        panelBack.setLayout(null);
        panelBack.setBounds(230,180,500,400);
        panelBack.setBackground(Color.lightGray);
        JLabel usernameLable=new JLabel("Username :");
        JLabel passwordLable=new JLabel("Password :");
        usernameLable.setFont(font1);
        passwordLable.setFont(font1);
        usernameLable.setBounds(50,80,200,30);
        passwordLable.setBounds(50,173,200,30);
        panelBack.add(usernameLable);
        panelBack.add(passwordLable);

        JTextField usernameText=new JTextField(" ");
        JTextField passwordText=new JTextField(" ");
        usernameText.setBounds(200,75,200,50);
        passwordText.setBounds(200,170,200,50);
        panelBack.add(usernameText);
        panelBack.add(passwordText);

        JButton enterBut=new JButton("Enter");
        enterBut.setFont(font1);
        enterBut.setBounds(200,250,200,30);
        enterBut.setFont(font1);
        enterBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass= passwordText.getText();
                String username= passwordText.getText();
                ManagerValidator managerValidator=new ManagerValidator();
                boolean password=managerValidator.passwordValidate(pass);
                boolean user=managerValidator.passwordValidate(username);

            }
        });
        panelBack.add(enterBut);

        JButton backBut=new JButton("Back");
        backBut.setBounds(75,250,100,30);
        backBut.setFont(font1);
        panelBack.add(backBut);
        backBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.repaint();
                frame.revalidate();
                frame.add(mainPanel);

            }
        });

        panel.add(panelBack);
       frame.setVisible(true);
       frame.add(panel);

    }


}