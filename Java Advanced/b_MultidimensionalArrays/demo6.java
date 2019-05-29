package b_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class demo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = new int[(int) Math.ceil(row * 1.5)];
            System.out.println(Arrays.toString(matrix[row] ));

        }

    }
}
