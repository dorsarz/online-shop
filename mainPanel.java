import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class mainPanel extends JFrame{
    File file=new File("information.txt");
    public void shopGUI(){
        JFrame frame=new JFrame("online shop");
        Dimension framesize=new Dimension(1000,1000);
        frame.setSize(framesize);
        JPanel mainPanel=new JPanel();
        mainPanel.setSize(framesize);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.lightGray);
        Font font=new Font("font",Font.BOLD,25);
        JLabel welcomeText=new JLabel("WElCOME TO OUR ONLINE SHOP ♡");
        welcomeText.setBounds(280,60,500,300);
        welcomeText.setBackground(Color.black);
        welcomeText.setFont(font);
        mainPanel.add(welcomeText);

        // add a new panel to log in a manager
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
        // add a new panel to log in a user
        JButton userButton=new JButton("LOG IN AS USER");
        userButton.setFont(font);
        userButton.setBounds(340,350,300,100);
        mainPanel.add(userButton);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login=new Login(frame,mainPanel,file);
                frame.remove(mainPanel);
                login.setLoginPanel();

            }
        });
        // add a new panel to signing up
        JButton signIn=new JButton("SIGN UP");
        signIn.setFont(font);
        signIn.setBounds(340,450,300,100);
        mainPanel.add(signIn);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                signIn signIn=new signIn(frame,mainPanel,file);
                frame.remove(mainPanel);
                try {
                    signIn.signInGUI();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        frame.add(mainPanel);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
