import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        int IsRunning = 1;
        while (IsRunning == 1) {
            menu();
            Scanner sc = new Scanner(System.in);
            int Option = sc.nextInt();
            switch(Option) {
                case 1:
                    System.out.println("Please sign in");
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


}