import java.io.*;
import java.util.Scanner;


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
    }           // menu nguoi dung

    public static boolean IsExistsInFile (String stringChecker) {
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
    }   // kiem tra email da bi trung trong file hay chua
    public static void SignUp() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        String NickName;
        String Email;
        String Password;

        int IsValidNickName = 0;
        while (IsValidNickName == 0) {
            System.out.print(" Enter your nick name: ");
            NickName = scanner.nextLine();
            user.setNickName(NickName);
            if (IsExistsInFile(NickName) == true) {
                System.out.println(" Error: This nick name has been used!!!");
                IsValidNickName = 0;
            } else {
                try {
                    FileWriter fileWriter = new FileWriter("manager.txt", true);
                    BufferedWriter  bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(NickName + ", ");

                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(" Error: " + e.getMessage());
                }
                IsValidNickName = 1;
            }
        }

        int IsValidEmail = 0;
        while (IsValidEmail == 0) {
            System.out.print(" Enter your email: ");
            Email = scanner.nextLine();
            user.setEmail(Email);
            if (IsExistsInFile(Email) == true) {
                System.out.println(" Error: This email has been used!!!");
                IsValidEmail = 0;
            } else {
                try {
                    FileWriter fileWriter = new FileWriter("manager.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(Email + ", ");

                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(" Error: " + e.getMessage());
                }
                IsValidEmail = 1;
            }
        }

        int IsValidPassword = 0;
        while (IsValidPassword == 0) {
            System.out.print(" Enter your password: ");
            Password = scanner.nextLine();
            user.setPassword(Password);
            if (Password.length() <= 0) {
                System.out.println(" Error: Please enter your password!!!");
                IsValidPassword = 0;
            }
            if (Password.length() > 0 && Password.length() < 10) {
                System.out.println(" Error: Please create password that has more than 10 characters");
                IsValidPassword = 0;
            }
            if (Password.length() >= 10) {
                try {
                    FileWriter fileWriter = new FileWriter("manager.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(Password + ". ");
                    bufferedWriter.newLine();

                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(" Error: " + e.getMessage());
                }
                IsValidPassword = 1;
            }
        }

        System.out.println("                           SIGN UP SUCCESSFULLY                    ");

    }
}