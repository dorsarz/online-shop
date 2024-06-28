import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signIn {
    private JFrame frame;
    private JPanel mainPanel;
    JPanel boxerror=new JPanel();
    JPanel backPanel=new JPanel();
    JTextField lastNameField=new JTextField();
    JTextField firstNameField=new JTextField();
    JTextField usernameField=new JTextField();
    JTextField passwordField=new JTextField();
    JTextField numberField=new JTextField();
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
        backPanel.setBounds(200,120,700,600);
        backPanel.setLayout(null);
        backPanel.setBackground(Color.lightGray);
        signInPanel.add(backPanel);

        JLabel firstNameLabel=new JLabel("First name:");
        firstNameLabel.setBounds(40,10,200,50);
        firstNameLabel.setFont(font);
        backPanel.add(firstNameLabel);


        firstNameField.setBounds(200,5,250,50);
        backPanel.add(firstNameField);

        JLabel lastNameLabel=new JLabel("Last Name: ");
        lastNameLabel.setBounds(40,60,200,50);
        lastNameLabel.setFont(font);
        backPanel.add(lastNameLabel);


        lastNameField.setBounds(200,55,250,50);
        backPanel.add(lastNameField);

        JLabel username=new JLabel("User Name: ");
        username.setBounds(40,110,200,100);
        username.setFont(font);
        backPanel.add(username);


        usernameField.setBounds(200,105,250,100);
        backPanel.add(usernameField);

        JLabel password=new JLabel("Password: ");
        password.setBounds(40,210,200,100);
        password.setFont(font);
        backPanel.add(password);

        passwordField.setBounds(200,205,250,100);
        backPanel.add(passwordField);

        JLabel phoneNumber=new JLabel("Phone Number: ");
        phoneNumber.setFont(font);
        phoneNumber.setBounds(40,310,200,100);
        backPanel.add(phoneNumber);

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


        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backPanel.remove(boxerror);
                backPanel.repaint();
                backPanel.revalidate();
                boxerror.setLayout(null);
                boxerror.setBackground(Color.lightGray);
                boxerror.setBounds(400,0,300,600);
                setFullnameError();
                setPhoneError();
                SetpasswordError();
                SetAdressError();

                backPanel.add(boxerror);

            }
        });
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

    private void setPhoneError() {
        Font errorFont = new Font("font", Font.ITALIC, 10);
        SignUpValidator signUp=new SignUpValidator();
        String number=numberField.getText();
        int numlength=number.length();
        boolean phonelength=signUp.phonelength(numlength);
        boolean phonecorrect=signUp.phonecorrectness(number);
        if(numlength==0){
            JLabel numberError=new JLabel("Please fill in the blank! ");
            numberError.setBounds(65,305,300,30);
            numberError.setFont(errorFont);
            boxerror.add(numberError);
            boxerror.revalidate();
            boxerror.repaint();
        }
        else {
        if(phonecorrect){
            if(!phonelength){
                JLabel numberError=new JLabel("phoneNumber`s length must be 11");
                numberError.setBounds(65,305,300,30);
                numberError.setFont(errorFont);
                boxerror.add(numberError);
                boxerror.revalidate();
                boxerror.repaint();
            }

        }
        else {
            JLabel numberError=new JLabel("This number is Invalid");
            numberError.setBounds(65,305,300,30);
            numberError.setFont(errorFont);
            boxerror.add(numberError);
            boxerror.revalidate();
            boxerror.repaint();
        }}
    }

    public void setFullnameError(){
        String name=firstNameField.getText();
        String last=lastNameField.getText();
        int namelen=name.length();
        int lastlen=last.length();
        SignUpValidator signUp=new SignUpValidator();
        boolean namelength= signUp.namelength(namelen);
        boolean namecorrectness=signUp.nameCorrectness(name);
        boolean lastlength=signUp.lastnamelength(lastlen);
        boolean lastcorrectness=signUp.lastnameCorrectness(last);
        Font errorFont = new Font("font", Font.ITALIC, 10);
        if(namelen==0){
            JLabel numberError=new JLabel("Please fill in the blank! ");
            numberError.setBounds(65,5,350,30);
            numberError.setFont(errorFont);
            boxerror.add(numberError);
            boxerror.revalidate();
            boxerror.repaint();
        }
        else {

        if(namelength){
            if (!namecorrectness){
                JLabel error=new JLabel("Your firstname must contains Alphabet only!");
                error.setBounds(65,5,350,30);
                error.setFont(errorFont);
                boxerror.add(error);
                boxerror.revalidate();
                boxerror.repaint();
            }
        }
        else {
            JLabel error=new JLabel("Your firstname`s length must be between 3-12!");
            error.setBounds(65,5,350,30);
            error.setFont(errorFont);
            boxerror.add(error);
            boxerror.revalidate();
            boxerror.repaint();
        }}
        if(lastlen==0){
            JLabel numberError=new JLabel("Please fill in the blank! ");
            numberError.setBounds(65, 55, 350, 30);
            numberError.setFont(errorFont);
            boxerror.add(numberError);
            boxerror.revalidate();
            boxerror.repaint();
        }
        else {
            if (lastlength) {
                if (!lastcorrectness) {
                    JLabel error = new JLabel("Your lastname must contains Alphabet only!");
                    error.setBounds(65, 55, 350, 30);
                    error.setFont(errorFont);
                    boxerror.add(error);
                    boxerror.revalidate();
                    boxerror.repaint();
                }
            } else {
                JLabel error = new JLabel("Your lastname`s length must be between 3-12!");
                error.setBounds(65, 55, 350, 30);
                error.setFont(errorFont);
                boxerror.add(error);
                boxerror.revalidate();
                boxerror.repaint();
            }
        }
    }
    public void SetusernameError(){

    }
    public void SetpasswordError(){
        Font errorFont = new Font("font", Font.ITALIC, 10);
        SignUpValidator signUp=new SignUpValidator();
        String pass= passwordField.getText();
        int passlen=pass.length();
        boolean passwordlen=signUp.passwordlength(passlen);
        boolean passwordcorrect=signUp.passwordCorrectness(pass);
        if (passlen == 0) {
            JLabel numberError=new JLabel("Please fill in the blank! ");
            numberError.setBounds(65, 205, 350, 30);
            numberError.setFont(errorFont);
            boxerror.add(numberError);
            boxerror.revalidate();
            boxerror.repaint();
        }
        else {
            if (passwordlen) {
                if (!passwordcorrect) {
                    JLabel error = new JLabel("Your password is so simple!");
                    error.setBounds(65, 205, 350, 30);
                    error.setFont(errorFont);
                    boxerror.add(error);
                    boxerror.revalidate();
                    boxerror.repaint();
                }
            } else {
                JLabel error = new JLabel("Your password`s length must be between 8-25");
                error.setBounds(65, 205, 350, 30);
                error.setFont(errorFont);
                boxerror.add(error);
                boxerror.revalidate();
                boxerror.repaint();
            }
        }
    }
    public void SetAdressError(){
        Font errorFont = new Font("font", Font.ITALIC, 10);
        JLabel numberError=new JLabel("Please fill in the blank! ");
        numberError.setBounds(65, 410, 350, 30);
        numberError.setFont(errorFont);
        boxerror.add(numberError);
        boxerror.revalidate();
        boxerror.repaint();
    }

}
