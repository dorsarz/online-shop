import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Profile {
    private Frame frame;
    private File file;
    private String username;
    private JPanel mainPanel;

    Profile(Frame frame, File file, String username,JPanel mainPanel) {
        this.frame = frame;
        this.file = file;
        this.username = username;
        this.mainPanel=mainPanel;
    }

    public void setprofile() {
        frame.repaint();
        frame.revalidate();
        JPanel profilePanel = new JPanel();
        ArrayList<String> user=new ArrayList<>();
        String[] splitInformation = null;
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            // for personal information we read each line in file and using an array list to having them then write them in panel
            while (line != null) {
                splitInformation = line.split(":");
                if (username.contains(splitInformation[2])) {
                    for (int i = 0; i <splitInformation.length ; i++) {
                        user.add(i,splitInformation[i]);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
        }

        profilePanel.setBounds(0, 0, 1000, 1000);
        profilePanel.setLayout(new GridLayout(7, 2));
        JLabel username = new JLabel("Username:");
        profilePanel.add(username);
        JLabel usernamefield = new JLabel(user.get(2));
        profilePanel.add(usernamefield);
        JLabel name = new JLabel("Name:");
        profilePanel.add(name);
        JLabel namefield = new JLabel(user.get(0));
        profilePanel.add(namefield);
        JLabel lastname = new JLabel("Lastname:");
        profilePanel.add(lastname);
        JLabel lastnamefield = new JLabel(user.get(1));
        profilePanel.add(lastnamefield);
        JLabel phoneNumber = new JLabel("phoneNumber:");
        profilePanel.add(phoneNumber);
        JLabel phoneNumberfield = new JLabel(user.get(4));
        profilePanel.add(phoneNumberfield);
        JLabel adress = new JLabel(" Adress:");
        profilePanel.add(adress);
        JLabel adressfield = new JLabel(user.get(5));
        profilePanel.add(adressfield);
        JLabel wallet = new JLabel("Wallet:");
        profilePanel.add(wallet);
        JLabel walletfield = new JLabel("100");
        profilePanel.add(walletfield);
        JButton changepass = new JButton("Changepassword");

        //TODO

//        changepass.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    FileReader reader = new FileReader(file);
//                    FileWriter writer = new FileWriter(file);
//                    BufferedReader bufferedReader = new BufferedReader(reader);
//                    String line = bufferedReader.readLine();
//                    while (line != null) {
//                        String[] splitInformation = line.split(":");
//                        if (username.equals(splitInformation[2])) {
//                            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//                        }
//                        line = bufferedReader.readLine();
//
////                    }
//                } catch (FileNotFoundException ex) {
//                    throw new RuntimeException(ex);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });

        profilePanel.add(changepass);
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(profilePanel);
                frame.add(mainPanel);
                frame.repaint();
                frame.revalidate();
            }
        });
        profilePanel.add(back);
        frame.add(profilePanel);
        frame.setVisible(true);
    }
}




