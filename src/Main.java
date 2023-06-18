import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;



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
                    SignIn();
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
        String Phone;

        int IsValidNickName = 0;
        while (IsValidNickName == 0) {
            System.out.print(" Enter your nick name: ");
            NickName = scanner.nextLine();
            user.setNickName(NickName);
            if (IsExistsInFile(NickName) == true) {
                System.out.println(" Error: This nick name has been used!!!");
                IsValidNickName = 0;
            } else if (NickName.contains(" ")) {
                System.out.println(" Error: This nick name is not valid!!!");
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

        int IsValidPhone = 0;
        while (IsValidPhone == 0) {
            System.out.print(" Enter your phone: ");
            Phone = scanner.nextLine();
            user.setPhone(Phone);
            if (IsExistsInFile(Phone) == true) {
                System.out.println(" Error: This phone has been used!!!");
                IsValidPhone = 0;
            } else if (Phone.length() <= 0) {
                System.out.println(" Error: Please enter your phone number!!!");
                IsValidPhone = 0;
            } else if (Phone.length() > 11) {
                System.out.println(" Error: The phone number can't have more than 11 numbers");
                IsValidPhone = 0;
            } else {
                try {
                    FileWriter fileWriter = new FileWriter("manager.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(Phone + ", ");

                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(" Error: " + e.getMessage());
                }
                IsValidPhone = 1;
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

                    bufferedWriter.write(Password + " ");
                    bufferedWriter.newLine();

                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(" Error: " + e.getMessage());
                }
                IsValidPassword = 1;
            }
        }

        System.out.println("                           SIGN UP SUCCESSFULLY                    ");

    }   // dang ki tao tai khoan

    public static boolean login(String username, String password) {
        try {
            FileReader fileReader = new FileReader("manager.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userInfo = line.split(", ");

                String storedUsername = userInfo[0];
                String storedPassword = userInfo[3];

                if (storedUsername.trim().equals(username) && storedPassword.trim().equals(password)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        return false;
    }   // kiem tra nick name va password co dung hay khong

    public static void SignIn () {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        String username;
        String password;
        int IsSignIn = 0;
        while (IsSignIn == 0) {

                System.out.print(" Enter your username: ");         // nhap user name
                username = scanner.nextLine();
                user.setNickName(username);
                while (username.contains(" ")) {
                    System.out.println(" Error: This nick name is not valid!!!");
                    System.out.print(" Enter your username: ");
                    username = scanner.nextLine();
                    user.setNickName(username);
                }
                while(username.length() <= 0) {
                    System.out.println(" Error: Please enter your nick name!!!");
                    System.out.print(" Enter your username: ");
                    username = scanner.nextLine();
                    user.setNickName(username);
                }


                System.out.print(" Enter your password: ");
                password = scanner.nextLine();
                user.setPassword(password);

                while (password.length() <= 0) {
                    System.out.println(" Error: Please enter the your password!!!");
                    System.out.print(" Enter your password: ");
                    password = scanner.nextLine();
                    user.setPassword(password);
                }

            if (login(username, password)) {            // kiem tra username va password
                System.out.println(" Sign in successfully!!");
                IsSignIn = 1;
            } else {
                System.out.println(" Check your user name and password again !!!!");
                IsSignIn = 0;
            }
        }
    }    // dang nhap
}