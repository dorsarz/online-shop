import javax.swing.*;
import java.awt.*;

public class Login {
    public void setLoginpanel(){
        JFrame userFrame = new JFrame();
        userFrame.setSize(1000,1000);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1000,1000);
        Font font=new Font("font",Font.BOLD,25);

        JLabel user=new JLabel("USER");
        Font font2=new Font("font",Font.BOLD,50);
        user.setFont(font2);
        user.setBounds(430,30,200,50);
        panel.add(user);

        JPanel panelBack=new JPanel();
        panelBack.setLayout(null);
        panelBack.setBounds(230,180,500,400);
        panelBack.setBackground(Color.lightGray);
        JLabel usernameLable=new JLabel("Username :");
        JLabel passwordLable=new JLabel("Password :");
        usernameLable.setFont(font);
        passwordLable.setFont(font);
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
        enterBut.setFont(font);
        enterBut.setBounds(200,250,200,30);
        enterBut.setFont(font);
        panelBack.add(enterBut);
        JButton backBut=new JButton("Back");
        backBut.setBounds(75,250,100,30);
        backBut.setFont(font);
        panelBack.add(backBut);
        panel.add(panelBack);
        userFrame.setVisible(true);
        userFrame.add(panel);
    }
}
