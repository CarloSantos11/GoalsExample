package snapit.carlo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static snapit.carlo.FileInputOutput.*;

public class Menu {
    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        String option = "";

        while (!option.equals("q") && !option.equals("Q")) {
            System.out.println("Welcome to your goal tracker");
            System.out.println("----------------------------");
            System.out.println("What is your plan of action?");
            System.out.println();
            System.out.println("1. Add in new goals");
            System.out.println("2. View goals");

            option = input.next();

            try {
                takeOption(option);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public static void takeOption(String option) throws FileNotFoundException {
        switch (option){
            case "1":
                createGoals();
                break;
            case "2":
                readGoalsFromFile();
                break;
            default:
                System.out.println("Did you enter anything?");

        }
    }
}
