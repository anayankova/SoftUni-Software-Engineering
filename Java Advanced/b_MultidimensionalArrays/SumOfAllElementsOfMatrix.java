package b_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfAllElementsOfMatrix {
    public static void main(String[] args) {
        String sizes = "";
        int[][] matrix = matrixReader(sizes);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);

    }

    private static int[][] matrixReader(String sizes) {
        Scanner scanner = new Scanner(System.in);
        sizes = scanner.nextLine();
        int[] dimensions = Arrays.stream(sizes.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixSize = dimensions[0];

        int[][] matrix = new int[matrixSize][];

        for (int i = 0; i < matrixSize; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        return matrix;

    }
}
