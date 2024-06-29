import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login {
    private JFrame frame;
    private JPanel mainPanel;
    private File file;
    public Login(JFrame frame, JPanel mainPanel, File file){
        this.frame=frame;
        this.mainPanel=mainPanel;
        this.file=file;
    }
    public void setLoginPanel(){
        frame.repaint();
        frame.revalidate();
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
        enterBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] users = new String[0];
                Font errorFont = new Font("font", Font.ITALIC, 10);
                String pass=passwordText.getText();
                String username=usernameText.getText();
                LoginValidator login=new LoginValidator();
                boolean flag = false;
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        String[] splitInformation = line.split(":");
                        if (username.equals(splitInformation[2])) {
                            if (pass.equals(splitInformation[3])) {
                                flag = true;
                                users=splitInformation;
                            }
                        }
                        line = bufferedReader.readLine();

                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(flag){
                    Shop shop=new Shop(users,file);
                    frame.remove(panel);
                    shop.main();
                    frame.repaint();
                    frame.revalidate();
                }
                else {
                    JLabel error = new JLabel("Your password is wrong!");
                    error.setBounds(289,173,200,30);
                    error.setFont(errorFont);
                    panelBack.add(error);
                    panelBack.repaint();
                    panelBack.revalidate();
                }

            }
        });
        panelBack.add(enterBut);
        JButton backBut=new JButton("Back");
        backBut.setBounds(75,250,100,30);
        backBut.setFont(font);
        panelBack.add(backBut);
        backBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                frame.add(mainPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        panel.add(panelBack);
        frame.setVisible(true);
        frame.add(panel);
    }
}
