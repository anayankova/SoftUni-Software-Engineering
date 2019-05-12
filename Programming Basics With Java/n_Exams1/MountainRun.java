package n_Exams1;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeperMeter = Double.parseDouble(scanner.nextLine());

        double allSeconds = distance * timeperMeter;
        double minusSeconds = Math.floor(distance / 50) * 30;
        double totalSeconds = allSeconds + minusSeconds;

        if (totalSeconds < record){
            System.out.printf("Yes! The new record is %.2f seconds.", totalSeconds);
        }else{
            System.out.printf("No! He was %.2f seconds slower.",totalSeconds-record);
        }

    }
}
