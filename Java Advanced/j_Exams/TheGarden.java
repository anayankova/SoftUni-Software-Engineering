package j_Exams;

import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] vegetables = new String[n][];

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmedVegetables = 0;

        for (int i = 0; i < n; i++) {
            vegetables[i] = scanner.nextLine().split("\\s+");
        }

        String line = scanner.nextLine();
        while (!line.equals("End of Harvest")) {
            String[] data = line.split("\\s+");

            String command = data[0];
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);
            String direction = "";
            if (data.length == 4) {
                direction = data[3];
            }

            if (!invalidCoordinates(vegetables, row, col)) {
                if (command.equals("Harvest")) {

                    if (vegetables[row][col].equals("L")) {
                        lettuce++;
                        vegetables[row][col] = " ";
                    } else if (vegetables[row][col].equals("C")) {
                        carrots++;
                        vegetables[row][col] = " ";
                    } else if (vegetables[row][col].equals("P")) {
                        potatoes++;
                        vegetables[row][col] = " ";
                    } else {
                        break;
                    }
                } else if (command.equals("Mole")) {

                    if (!vegetables[row][col].equals(" ")) {
                        harmedVegetables++;
                        vegetables[row][col] = " ";
                    }

                    if (direction.equals("up")) {
                        row -= 2;
                        while (row >= 0) {
                            if (!vegetables[row][col].equals(" ")) {
                                harmedVegetables++;
                                vegetables[row][col] = " ";
                            }
                            row -= 2;
                        }
                    } else if (direction.equals("down")) {
                        row += 2;
                        while (row <= vegetables.length - 1) {
                            if (!vegetables[row][col].equals(" ")) {
                                harmedVegetables++;
                                vegetables[row][col] = " ";
                            }
                            row += 2;
                        }
                    } else if (direction.equals("left")) {
                        col -= 2;
                        while (col >= 0) {
                            if (!vegetables[row][col].equals(" ")) {
                                harmedVegetables++;
                                vegetables[row][col] = " ";
                            }
                            col -= 2;
                        }
                    } else if (direction.equals("right")) {
                        col += 2;
                        while (col <= vegetables[row].length - 1) {
                            if (!vegetables[row][col].equals(" ")) {
                                harmedVegetables++;
                                vegetables[row][col] = " ";
                            }
                            col += 2;
                        }
                    }
                }
            }

            line = scanner.nextLine();
        }

        for (int i = 0; i < vegetables.length; i++) {
            for (int j = 0; j < vegetables[i].length; j++) {
                System.out.print(vegetables[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmedVegetables);


    }

    private static boolean invalidCoordinates(String[][] vegetables, int row, int col) {
        return row >= vegetables.length || col >= vegetables[row].length;
    }
}
