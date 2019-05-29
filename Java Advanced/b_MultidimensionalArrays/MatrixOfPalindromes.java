package b_MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        generateMatrix(matrix, rows, cols);

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void generateMatrix(String[][] matrix, int rows, int cols) {
        char word = 'a';
        char middleWord = 'a';
        String palindrom = "";
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                palindrom = "" + word + middleWord + word;
                matrix[r][c] = palindrom;
                middleWord++;
            }
            word++;
            middleWord = word;

        }

    }
}
