package b_MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        int row = 0, col = 0;
        int primarySum = 0;
        while (row < size && col < size){
            primarySum += matrix[row][col];
            row++;
            col++;
        }

        row--;
        col=0;

        int secondarySum = 0;
        while (row >= 0 && col < size){
            secondarySum += matrix[row][col];
            row--;
            col++;
        }

        System.out.println(Math.abs(primarySum - secondarySum));

    }
}
