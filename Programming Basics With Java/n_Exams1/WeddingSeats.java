package n_Exams1;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char sections = scanner.nextLine().charAt(0);
        int rows = Integer.parseInt(scanner.nextLine());
        int seats = Integer.parseInt(scanner.nextLine());
        int n = 0;
        int sum = 0;

        for (char i = 'A'; i <= sections; i++) {
            for (int j = 1; j <= rows + n; j++) {
                if (j % 2 == 0) {
                    seats += 2;
                }
                for (char k = 'a'; k <= 'a' + seats - 1; k++) {
                    System.out.printf("%s%d%s%n", i, j, k);
                    sum++;
                }
                if (j % 2 == 0) {
                    seats -= 2;
                }
            }
            n++;
        }
        System.out.println(sum);
    }
}
