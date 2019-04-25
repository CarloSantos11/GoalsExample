package snapit.carlo;

import java.io.*;
import java.util.Scanner;

public class FileInputOutput {

    public static void  createGoals() {
        String goal = "";
        while (!goal.equals("q") && !goal.equals("Q")){
            goal = askForGoal();
            writeGoalToFile(goal);
        }
    }

    public static String askForGoal(){
        String goal = "";
        Scanner input = new Scanner(System.in);

        System.out.println("What is a goal");
        goal = input.nextLine();
        return goal;
    }

    public static void writeGoalToFile(String goal) {

        if(goal.equals("q") || goal.equals("Q")){
            return;
        }
        try {
            File f1 = new File("goals.txt");
            if(!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(goal);
            bw.newLine();
            bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readGoalsFromFile() throws FileNotFoundException {
        File f1 = new File("goals.txt");
        Scanner sc = new Scanner(f1);

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        System.out.println("\n\n");
    }
}
