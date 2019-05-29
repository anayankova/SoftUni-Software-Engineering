package b_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rows][rows];

        List<String> firstDiagonal = new ArrayList<>();
        List<String> secondDiagonal = new ArrayList<>();


        for (int row = 0; row < rows; row++) {

            String[] strForCols = scanner.nextLine().split("\\s+");

            matrix[row] = strForCols;
        }


        for (int i = 0; i < rows; i++) {

            firstDiagonal.add(matrix[i][i]);

        }


        int counter = 0;

        for (int i = rows-1; i >= 0; i--) {

            secondDiagonal.add(matrix[i][counter]);
            counter++;
        }

        System.out.println(String.join(" ", firstDiagonal));
        System.out.println(String.join(" ", secondDiagonal));


    }
}
