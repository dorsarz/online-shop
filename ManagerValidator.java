public class ManagerValidator {
    public boolean passwordValidate(String pass){
        String password="84";
        if (pass.contains(password)){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean usernameValidate(String user){
        String username="84";
        if (user.contains(username)){
            return true;
        }
        else {
            return false;
        }
    }
}