import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main {
    private static final String USER_FILE = "manager.txt";
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int IsRunning = 1;
        while (IsRunning == 1) {
            menu();
            int Option = scanner.nextInt();
            switch(Option) {
                case 1:
                    System.out.println("-------------------------SIGN IN--------------------------");
                    break;
                case 2:
                    System.out.println("-------------------------SIGN UP--------------------------");
                    SignUp();
                    break;
                case 3:
                    System.out.println("Exit");
                    IsRunning = 0;
                    break;
            }
        }
    }
    public static void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("                 [1]. Sign in                   ");
        System.out.println("                 [2]. Sign up                   ");
        System.out.println("                 [3]. Exit                      ");
        System.out.println("------------------------------------------------");
        System.out.print("  Your option is: ");
    }

    public static boolean IsExistsInFile (String stringChecker) {           // kiem tra email da bi trung trong file hay chua
        try {
            FileReader fileReader = new FileReader("manager.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(stringChecker)) {
                    bufferedReader.close();
                    return true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    public static void SignUp() {
        String NickName;
        String Email;
        String Password;

        Scanner scanner = new Scanner(System.in);
        User user1 = new User();

        System.out.print(" Enter your nick name: ");
        NickName = scanner.nextLine();
        user1.setNickName(NickName);

        // nhap email nguoi dung
        System.out.print(" Enter your email: ");
        Email = scanner.nextLine();
        user1.setEmail(Email);      // nhap email cua nguoi dung
        while (IsExistsInFile(Email) == true) {
            System.out.println(" Error: This email has been used!!!");
            System.out.print(" Enter your email: ");
            Email = scanner.nextLine();
            user1.setEmail(Email);
        }
        while (Email.length() <= 0 || Email.length() >= 25) {
            System.out.println(" Error: Please enter the valid email!!!");
            System.out.print(" Enter your email: ");
            Email = scanner.nextLine();
            user1.setEmail(Email);
        }
        // end

        System.out.print(" Enter your password: ");
        Password = scanner.nextLine();
        user1.setPassword(Password);

        try {
            FileWriter file = new FileWriter("manager.txt");
            file.write("Nick name: " + NickName + "."  + "   ");
            file.write("Email: " + Email + "." + "   ");
            file.write("Password: " + Password + "." +  "   ");
            file.close();
            System.out.println("                 SIGN UP Successfully!!!             ");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}