package j_Exams;

import java.util.Scanner;

public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] square = new char[n][];

        int rowStephen = 0;
        int colStephen = 0;
        int rowFirstBlackHole = 0;
        int colFirstBlackHole = 0;
        int rowSecondBlackHole = 0;
        int colSecondBlackHole = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            square[i] = line.toCharArray();
            if (line.contains("S")) {
                rowStephen = i;
                colStephen = line.indexOf("S");
            }
        }

        boolean isInVoid = false;

        int power = 0;

        while (power < 50 && !isInVoid) {

            String direction = scanner.next();

            if (direction.equals("up")) {
                square[rowStephen][colStephen] = '-';
                rowStephen--;
                if (rowStephen >= 0) {
                    if (power >= 50) {
                        square[rowStephen][colStephen] = 'S';
                    }

                    if (Character.isDigit(square[rowStephen][colStephen])) {
                        power += Integer.parseInt(square[rowStephen][colStephen] + "");
                        square[rowStephen][colStephen] = '-';
                    }
                    if (square[rowStephen][colStephen] == 'O') {
                        rowFirstBlackHole = rowStephen;
                        colFirstBlackHole = colStephen;

                        for (int i = 0; i < square.length; i++) {
                            for (int j = 0; j < square[i].length; j++) {
                                if (square[i][j] == 'O' && i != rowFirstBlackHole && j != colFirstBlackHole) {
                                    rowSecondBlackHole = i;
                                    colSecondBlackHole = j;
                                }
                            }
                        }
                        rowStephen = rowSecondBlackHole;
                        colStephen = colSecondBlackHole;
                        square[rowFirstBlackHole][colFirstBlackHole] = '-';
                    }

                }else {
                    isInVoid = true;
                }

            } else if (direction.equals("down")) {
                square[rowStephen][colStephen] = '-';
                rowStephen++;
                if (rowStephen < square.length) {
                    if (power >= 50) {
                        square[rowStephen][colStephen] = 'S';
                    }

                    if (Character.isDigit(square[rowStephen][colStephen])) {
                        power += Integer.parseInt(square[rowStephen][colStephen] + "");
                        square[rowStephen][colStephen] = '-';
                    }
                    if (square[rowStephen][colStephen] == 'O') {
                        rowFirstBlackHole = rowStephen;
                        colFirstBlackHole = colStephen;

                        for (int i = 0; i < square.length; i++) {
                            for (int j = 0; j < square[i].length; j++) {
                                if (square[i][j] == 'O' && i != rowFirstBlackHole && j != colFirstBlackHole) {
                                    rowSecondBlackHole = i;
                                    colSecondBlackHole = j;
                                }
                            }
                        }
                        rowStephen = rowSecondBlackHole;
                        colStephen = colSecondBlackHole;
                        square[rowFirstBlackHole][colFirstBlackHole] = '-';
                    }

                }else {
                    isInVoid = true;
                }
            }else if(direction.equals("left")){
                square[rowStephen][colStephen] = '-';
                colStephen--;
                if (colStephen >= 0) {
                    if (power >= 50) {
                        square[rowStephen][colStephen] = 'S';
                    }

                    if (Character.isDigit(square[rowStephen][colStephen])) {
                        power += Integer.parseInt(square[rowStephen][colStephen] + "");
                        square[rowStephen][colStephen] = '-';
                    }
                    if (square[rowStephen][colStephen] == 'O') {
                        rowFirstBlackHole = rowStephen;
                        colFirstBlackHole = colStephen;

                        for (int i = 0; i < square.length; i++) {
                            for (int j = 0; j < square[i].length; j++) {
                                if (square[i][j] == 'O' && i != rowFirstBlackHole && j != colFirstBlackHole) {
                                    rowSecondBlackHole = i;
                                    colSecondBlackHole = j;
                                }
                            }
                        }
                        rowStephen = rowSecondBlackHole;
                        colStephen = colSecondBlackHole;
                        square[rowFirstBlackHole][colFirstBlackHole] = '-';
                    }

                }else {
                    isInVoid = true;
                }
            }else if(direction.equals("right")){
                square[rowStephen][colStephen] = '-';
                colStephen++;
                if (colStephen < square.length) {
                    if (power >= 50) {
                        square[rowStephen][colStephen] = 'S';
                    }

                    if (Character.isDigit(square[rowStephen][colStephen])) {
                        power += Integer.parseInt(square[rowStephen][colStephen] + "");
                        square[rowStephen][colStephen] = '-';
                    }
                    if (square[rowStephen][colStephen] == 'O') {
                        rowFirstBlackHole = rowStephen;
                        colFirstBlackHole = colStephen;

                        for (int i = 0; i < square.length; i++) {
                            for (int j = 0; j < square[i].length; j++) {
                                if (square[i][j] == 'O' && i != rowFirstBlackHole && j != colFirstBlackHole) {
                                    rowSecondBlackHole = i;
                                    colSecondBlackHole = j;
                                }
                            }
                        }
                        rowStephen = rowSecondBlackHole;
                        colStephen = colSecondBlackHole;
                        square[rowFirstBlackHole][colFirstBlackHole] = '-';
                    }

                }else {
                    isInVoid = true;
                }
            }

        }

        if (power >= 50) {
            square[rowStephen][colStephen] = 'S';
        }

        if (power >= 50 || !isInVoid) {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
            System.out.printf("Star power collected: %d%n", power);
            printSquare(square);
        } else {
            System.out.println("Bad news, the spaceship went to the void.");
            System.out.printf("Star power collected: %d%n", power);
            printSquare(square);
        }


    }

    private static void printSquare(char[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }
}
