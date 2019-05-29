package b_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = new int[5];
            for (int col = 0; col < 5 ; col++)
                matrix[row][col] = row;
            System.out.println(Arrays.toString(matrix[row] ));

        }

    }
}
