package m_NestedLoop_Exercise;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());

        for (int first = a; first <= b; first++) {
            for (int second = a; second <= b; second++) {
                for (int third = c; third <= d; third++) {
                    for (int forth = c; forth <= d; forth++) {

                        boolean check1 = first + forth == second + third;
                        boolean check2 = first != second && third != forth;

                        if (check1 && check2) {
                            System.out.println(first + "" + second);
                            System.out.println(third + "" + forth);
                            System.out.println();
                        }

                    }

                }

            }

        }

    }
}
