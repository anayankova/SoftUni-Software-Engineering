package m_NestedLoop_Exercise;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int first = 1; first <= n; first++) {
            for (int second = 1; second <= n; second++) {
                for (int third = 'a'; third < 'a' + l; third++) {
                    for (int forth = 'a'; forth < 'a' + l; forth++) {
                        for (int fifth = 1; fifth <= n; fifth++) {
                            if (fifth > first && fifth > second){
                                System.out.printf("%d%d%c%c%d ",first,second,third,forth,fifth);
                            }
                        }

                    }

                }


            }

        }

    }
}
