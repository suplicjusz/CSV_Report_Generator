package service;

import java.util.Scanner;

public class CustomerService {

    public static boolean tryAgain = true;

    public static void setTryAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to try again, enter \"y\", else enter whatever:");
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            CustomerService.tryAgain = true;
        } else {
            CustomerService.tryAgain = false;
        }
    }

    public static String chooseInputPath() {
        System.out.println("Enter \"x\" to generate report about ItemX");
        System.out.println("Enter \"y\" to generate report about ItemY");
        System.out.println("Enter path to generate report about another item");
        String pathToItemX = "src\\main\\resources\\ItemX.csv";
        String pathToItemY = "src\\main\\resources\\ItemY.csv";
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        String path;
        if (option.equals("x")) {
            path = pathToItemX;
        } else if (option.equals("y")) {
            path = pathToItemY;
        } else {
            path = option;
        }
        return path;
    }

    public static String chooseOutputPath() {
        System.out.println("If you want to save report as CSV file, enter the path with name of the new file:");
        System.out.println("For ex. C:\\Users\\yourUserName\\Downloads\\new.csv");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
