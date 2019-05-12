package n_Exams1;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int men = Integer.parseInt(scanner.nextLine());
        int women = Integer.parseInt(scanner.nextLine());
        int tables = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 1; i <= men; i++) {
            if (tables == count) {
                break;
            }
            for (int j = 1; j <= women; j++) {
                System.out.printf("(%d <-> %d) ", i, j);
                count++;
                if (tables == count) {
                    break;
                }
            }
        }

    }
}