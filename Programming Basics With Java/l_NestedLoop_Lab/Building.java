package l_NestedLoop_Lab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());

        for (int i = floors; i >= 1; i--) {
            for (int j = 0; j < rooms; j++) {
                if (i == floors) {
                    System.out.print("L" + i + j + " ");
                } else {
                    if (i % 2 == 0) {
                        System.out.print("O" + i + j + " ");
                    } else {
                        System.out.print("A" + i + j + " ");
                    }
                }
            }
            System.out.println();
        }

    }
}
