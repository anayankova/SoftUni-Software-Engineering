package m_NestedLoop_Exercise;

import java.util.Scanner;

public class TrainTheTrainer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String name = "";
        double total = 0;
        int count = 0;

        while (!name.equals("Finish")) {
            name = scanner.nextLine();
            if (name.equals("Finish")){
                break;
            }
            double average = 0;
            for (int i = 0; i < n; i++) {
                double evaluation = Double.parseDouble(scanner.nextLine());
                average += evaluation/n;
            }
            System.out.printf("%s - %.2f.", name,average);
            System.out.println();
            count ++;
            total += average;
        }
        double totalAverage = total/count;
        System.out.printf("Student's final assessment is %.2f.",totalAverage);
    }
}
