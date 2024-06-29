import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Profile {
    private Frame frame;
    private File file;
    private String username;
    Profile(Frame frame,File file,String username){
        this.frame=frame;
        this.file=file;
        this.username=username;
    }

    public void setprofile(){
        JPanel profilepanel=new JPanel();
        profilepanel.setBounds(0,0,1000,1000);
        frame.add(profilepanel);
        frame.repaint();
        frame.revalidate();

        String[]user = new String[0];
       try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitInformation = line.split(":");
                if (username.equals(splitInformation[2])) {
                  user=splitInformation;

                }
                line = bufferedReader.readLine();

            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {

            JPanel profilePanel=new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBounds(0,0,1000,1000);
        frame.add(profilePanel);
        profilePanel.setLayout(new GridLayout(7,2));
        JLabel username= new JLabel("Username:");
        profilePanel.add(username);
        JLabel usernamefield=new JLabel(user[2]);
        profilePanel.add(usernamefield);
        JLabel name=new JLabel("Name:");
        profilePanel.add(name);
        JLabel namefield=new JLabel(user[0]);
        profilePanel.add(namefield);
        JLabel lastname=new JLabel("Lastname:");
        profilePanel.add(lastname);
        JLabel lastnamefield=new JLabel(user[1]);
        profilePanel.add(lastnamefield);
        JLabel phoneNumber=  new JLabel("phoneNumber:");
           profilePanel.add(phoneNumber);
        JLabel phoneNumberfield=  new JLabel(user[4]);
           profilePanel.add(phoneNumberfield);
        JLabel adress= new JLabel(" Adress:");
           profilePanel.add(adress);
        JLabel adressfield= new JLabel(user[5]);
           profilePanel.add(adressfield);
        JLabel wallet=new JLabel("Wallet:");
           profilePanel.add(wallet);
        JLabel walletfield=new JLabel("100");
           profilePanel.add(walletfield);
        JButton changepass=new JButton("Changepassword");

        changepass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader(file);
                    FileWriter writer=new FileWriter(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        String[] splitInformation = line.split(":");
                        if (username.equals(splitInformation[2])) {
                            BufferedWriter bufferedWriter=new BufferedWriter(writer);

                        }
                        line = bufferedReader.readLine();

                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
           profilePanel.add(changepass);
        JButton back=new JButton("Back");
           profilePanel.add(back);

    }



}}
