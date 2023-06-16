
import java.io.PrintStream;
import java.lang.String;
import java.util.Scanner;
public class User {
    private String NickName;
    private String Password;
    private String Email;
    public void setNickName(String NickName) {
        this.NickName = NickName;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getNickName () {
        return NickName;
    }
    public String getEmail () {
        return Email;
    }
    public String getPassword () {
        return Password;
    }

}
