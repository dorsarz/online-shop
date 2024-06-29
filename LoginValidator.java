import javax.swing.*;
import java.io.*;

public class LoginValidator {
    public boolean validPassword(String pass, File file, String usernameField) {
        boolean flag = false;
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {

                String[] splitInformation = line.split(":");
                if (usernameField.contains(splitInformation[2])) {

                    if (pass.contains(splitInformation[3])) {
                        flag = true;
                    }
                }
                line = bufferedReader.readLine();

            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return flag;
    }
}
