import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class SignUpValidator {
    public boolean namelength(int name){
        int min=3;int max=12;
            if(name >=min&& name <=max){
                return true;
            }
           else {return false;}
    }

    public boolean nameCorrectness(String name){
        boolean flag = true;
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                flag = false;
            }
        }
        if (flag) {
            return true;
        } else {
            return false;
        }

    }


    public boolean lastnamelength(int name){
        int min=3;int max=12;
        if(name >=min&& name<=max){
            return true;
        }
        else {return false;}
    }
    public boolean lastnameCorrectness(String name){
        boolean flag = true;
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                flag = false;
            }
        }
        if (flag) {
            return true;
        } else {
            return false;
        }
    }
    public boolean userNameCorrectness(String name){
                return true;
    }
    public boolean usernamelength(int name){
        int min=3;int max=20;
        if(name >=min && name<=max){
            return true;
        }
        else {return false;}
    }
    public boolean usernamerepeat(String name, File file, JTextField usernameField){
        boolean flag=true;
        try {
            FileReader reader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line=bufferedReader.readLine();
            while (line!=null){
                String[] splitInformation=line.split(":");
                if(usernameField.getText().equals(splitInformation[2])){
                    flag=false;
                }
                line = bufferedReader.readLine();

            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if (flag){
            return  true;
        }
        else {
            return false;
        }
    }
    public boolean passwordlength(int name){
        int min=8;int max=25;
        if(name >=min&& name<=max){
            return true;
        }
        else {return false;}
    }
    public boolean passwordCorrectness(String password){
        boolean flag = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i))) {
                flag = true;
            }
        }
        if(flag){
            flag=false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    flag = true;
                }
            }
        }
        if(flag){
            flag=false;
            char[]pass=password.toCharArray();
            for (int i = 0; i < password.length(); i++) {
                if (pass[i]=='!'||pass[i]=='@'||pass[i]=='%'||pass[i]=='&'||pass[i]=='*'||pass[i]=='.'||pass[i]=='_'||pass[i]=='-') {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean phonecorrectness(String number){
        if(number.startsWith("09")){
            return true;
        }
        else {
            return false;}
    }
    public boolean phonelength(int numbere){
        if(numbere==11){
            return true;
        }
        else {return false;}
    }







}
