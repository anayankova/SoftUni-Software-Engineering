package j_Exams;

import java.util.Scanner;

public class HelensAbduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[rows][];

        int parisRow = 0;
        int parisCol = 0;
        int helenaRow = 0;
        int helenaCol = 0;


        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();
            if (line.contains("P")) {
                parisRow = i;
                parisCol = line.indexOf("P");
            } else if (line.contains("H")) {
                helenaRow = i;
                helenaCol = line.indexOf("H");
            }
        }

        boolean isAbducted = false;

        while (energy > 0 && !isAbducted) {

            energy--;

            String direction = scanner.next();
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            field[row][col] = 'S';

            if (direction.equals("up") && canMove(parisRow - 1, parisCol, field)) {
                field[parisRow][parisCol] = '-';
                parisRow--;
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (field[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }

                field[parisRow][parisCol] = 'P';

            } else if (direction.equals("down") && canMove(parisRow + 1, parisCol, field)) {
                field[parisRow][parisCol] = '-';
                parisRow++;
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (field[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }

                field[parisRow][parisCol] = 'P';

            } else if (direction.equals("left") && canMove(parisRow, parisCol - 1, field)) {
                field[parisRow][parisCol] = '-';
                parisCol--;
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (field[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }

                field[parisRow][parisCol] = 'P';

            } else if (direction.equals("right") && canMove(parisRow, parisCol + 1, field)) {
                field[parisRow][parisCol] = '-';
                parisCol++;
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                } else if (field[parisRow][parisCol] == 'H') {
                    isAbducted = true;
                }

                field[parisRow][parisCol] = 'P';

            }
        }

        if (isAbducted) {
            field[parisRow][parisCol] = '-';
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        } else {
            field[parisRow][parisCol] = 'X';
            System.out.println(String.format("Paris died at %d;%d", parisRow, parisCol));
        }

        printField(field);

    }

    private static boolean canMove(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }

    private static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
