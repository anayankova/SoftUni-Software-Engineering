package j_Exams;

import java.util.Scanner;

public class TronRacers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());


        String[][] matrix = new String[rows][rows];
        int firstRacerRow = 0;
        int firstRacerCol = 0;
        int secondRacerRow = 0;
        int secondRacerCol = 0;

        for (int i = 0; i < rows; i++) {
            String[] colData = scanner.nextLine().split("");

            for (int j = 0; j < rows; j++) {
                matrix[i][j] = colData[j];
                if (matrix[i][j].equals("f")) {
                    firstRacerRow = i;
                    firstRacerCol = j;
                } else if (matrix[i][j].equals("s")) {
                    secondRacerRow = i;
                    secondRacerCol = j;
                }
            }
        }
        boolean isDead = false;
        while (true) {

            if (isDead) {
                break;
            }
            String[] commands = scanner.nextLine().split("\\s+");
            String firstCommand = commands[0];
            String secondCommand = commands[1];

            switch (firstCommand) {
                case "down":
                    if (firstRacerRow + 1 > matrix.length - 1) {
                        firstRacerRow = -1;
                    }
                    if (matrix[firstRacerRow + 1][firstRacerCol].equals("s")) {
                        matrix[firstRacerRow + 1][firstRacerCol] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[firstRacerRow + 1][firstRacerCol] = "f";
                        firstRacerRow = firstRacerRow + 1;
                    }
                    break;
                case "up":
                    if (firstRacerRow - 1 < 0) {
                        firstRacerRow = matrix.length;
                    }
                    if (matrix[firstRacerRow - 1][firstRacerCol].equals("s")) {
                        matrix[firstRacerRow - 1][firstRacerCol] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[firstRacerRow - 1][firstRacerCol] = "f";
                        firstRacerRow = firstRacerRow - 1;
                    }
                    break;
                case "left":
                    if (firstRacerCol - 1 < 0) {
                        firstRacerCol = matrix[0].length;
                    }
                    if (matrix[firstRacerRow][firstRacerCol - 1].equals("s")) {
                        matrix[firstRacerRow][firstRacerCol - 1] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[firstRacerRow][firstRacerCol - 1] = "f";
                        firstRacerCol = firstRacerCol - 1;
                    }
                    break;
                case "right":
                    if (firstRacerCol + 1 > matrix.length - 1) {
                        firstRacerCol = -1;
                    }
                    if (matrix[firstRacerRow][firstRacerCol + 1].equals("s")) {
                        matrix[firstRacerRow][firstRacerCol + 1] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[firstRacerRow][firstRacerCol + 1] = "f";
                        firstRacerCol = firstRacerCol + 1;
                    }
                    break;
            }
            switch (secondCommand) {

                case "down":
                    if (isDead) {
                        break;
                    }
                    if (secondRacerRow + 1 > matrix.length - 1) {
                        secondRacerRow = -1;
                    }
                    if (matrix[secondRacerRow + 1][secondRacerCol].equals("f")) {
                        matrix[secondRacerRow + 1][secondRacerCol] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[secondRacerRow + 1][secondRacerCol] = "s";
                        secondRacerRow = secondRacerRow + 1;
                    }
                    break;
                case "up":
                    if (isDead) {
                        break;
                    }
                    if (secondRacerRow - 1 < 0) {
                        secondRacerRow = matrix.length;
                    }
                    if (matrix[secondRacerRow - 1][secondRacerCol].equals("f")) {
                        matrix[secondRacerRow - 1][secondRacerCol] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[secondRacerRow - 1][secondRacerCol] = "s";
                        secondRacerRow = secondRacerRow - 1;
                    }
                    break;
                case "left":
                    if (isDead) {
                        break;
                    }
                    if (secondRacerCol - 1 < 0) {
                        secondRacerCol = matrix[0].length;
                    }
                    if (matrix[secondRacerRow][secondRacerCol - 1].equals("f")) {
                        matrix[secondRacerRow][secondRacerCol - 1] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[secondRacerRow][secondRacerCol - 1] = "s";
                        secondRacerCol = secondRacerCol - 1;
                    }
                    break;
                case "right":
                    if (isDead) {
                        break;
                    }
                    if (secondRacerCol + 1 > matrix.length - 1) {
                        secondRacerCol = -1;
                    }
                    if (matrix[secondRacerRow][secondRacerCol + 1].equals("f")) {
                        matrix[secondRacerRow][secondRacerCol + 1] = "x";
                        isDead = true;
                        break;
                    } else {
                        matrix[secondRacerRow][secondRacerCol + 1] = "s";
                        secondRacerCol = secondRacerCol + 1;
                    }
                    break;
            }
        }
        printMatrix(matrix);


    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }

    }
}
