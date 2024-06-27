import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPanel extends JFrame{
    public void shopGUI(){
        JFrame frame=new JFrame("online shop");
        Dimension framesize=new Dimension(1000,1000);
        frame.setSize(framesize);
        JPanel mainPanel=new JPanel();
        mainPanel.setBounds(0,0,1000,1000);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.lightGray);
        Font font=new Font("font",Font.BOLD,25);
        JLabel welcomeText=new JLabel("WElCOME TO OUR ONLINE SHOP ♡");
        welcomeText.setBounds(280,60,500,300);
        welcomeText.setBackground(Color.black);
        welcomeText.setFont(font);
        mainPanel.add(welcomeText);

        JButton managerButton=new JButton("LOG IN AS MANAGER");
        managerButton.setFont(font);
        managerButton.setBounds(340,250,300,100);
        mainPanel.add(managerButton);
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager manager=new Manager(frame,mainPanel);
                frame.remove(mainPanel);
                manager.setFrame();
            }
        });

        JButton userButton=new JButton("LOG IN AS USER");
        userButton.setFont(font);
        userButton.setBounds(340,350,300,100);
        mainPanel.add(userButton);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login=new Login(frame,mainPanel);
                frame.remove(mainPanel);
                login.setLoginPanel();

            }
        });

        JButton signIn=new JButton("SIGN UP");
        signIn.setFont(font);
        signIn.setBounds(340,450,300,100);
        mainPanel.add(signIn);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                signIn signIn=new signIn(frame,mainPanel);
                frame.remove(mainPanel);
                signIn.signInGUI();
            }
        });


        frame.add(mainPanel);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
