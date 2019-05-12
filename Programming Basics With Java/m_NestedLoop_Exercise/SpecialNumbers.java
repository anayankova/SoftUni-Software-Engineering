package m_NestedLoop_Exercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int first = 1; first <= 9 ; first++) {
            for (int second = 1; second <= 9 ; second++) {
                for (int third = 1; third <= 9 ; third++) {
                    for (int forth = 1; forth <= 9 ; forth++) {

                        boolean checkFirst = n % first == 0;
                        boolean checkSecond = n % second == 0;
                        boolean checkThird = n % third == 0;
                        boolean checkForth = n % forth == 0;

                        if (checkFirst && checkSecond && checkThird && checkForth){
                            System.out.printf("%d%d%d%d ",first,second,third,forth);
                        }

                    }

                }

            }

        }

    }
}
