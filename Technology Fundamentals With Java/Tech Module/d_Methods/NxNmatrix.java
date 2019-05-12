package d_Methods;

import java.util.Scanner;

public class NxNmatrix {
    public static void main(String[] args) {
        printMatrix();

    }

    static void printMatrix() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
