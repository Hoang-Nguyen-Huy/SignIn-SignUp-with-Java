import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
                    SignIn(scanner);
                    break;
                case 2:
                    System.out.println("Please sign up");
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

    public  static void SignIn (Scanner scanner) {
        System.out.println(" Enter your nick name: ");
        String userName = scanner.nextLine();
        System.out.print(" Enter your password: ");
        String password = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter(USER_FILE, true);
            fileWriter.write(userName + " " + password + "\n");
            fileWriter.close();
            System.out.println("     Sign in succcessfully.");
        } catch (IOException e) {
            System.out.println("     Error: Can not save user information!!!");
        }
    }

}