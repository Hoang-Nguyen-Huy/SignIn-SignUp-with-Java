
import java.io.PrintStream;
import java.lang.String;
import java.util.Scanner;
public class User {
    private String NickName;
    private String Password;
    private String Email;
    private String Phone;
    public void setNickName(String NickName) {
        this.NickName = NickName;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
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
    public String getPhone () {
        return Phone;
    }
    public String getPassword () {
        return Password;
    }

}
