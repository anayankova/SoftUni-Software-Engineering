package i_WhileLoop_Exercise;

import java.util.Scanner;

public class PreparationForExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxPoorGrades = Integer.parseInt(scanner.nextLine());
        boolean isFailed = false;
        String task = scanner.nextLine();

        int sumGrades = 0;
        int countTask = 0;
        String lastProblem = "";
        int countPoorGrades = 0;

        while (!task.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());

            sumGrades += grade;
            countTask++;
            lastProblem = task;

            if (grade <= 4) {
                countPoorGrades++;
            }

            if (countPoorGrades == maxPoorGrades) {
                System.out.printf("You need a break, %d poor grades.", countPoorGrades);
                isFailed = true;
                break;
            }

            task = scanner.nextLine();

        }
        if (!isFailed) {
            double average = sumGrades * 1.0 / countTask;
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Number of problems: %d%n", countTask);
            System.out.printf("Last problem: %s", lastProblem);

        }
    }
}
