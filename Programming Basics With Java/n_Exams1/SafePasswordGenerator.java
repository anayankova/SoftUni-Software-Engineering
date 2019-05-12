package n_Exams1;

import java.util.Scanner;

public class SafePasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());
        int n = 1;
        boolean isXY = false;

        for (char A = 35; A <= 55; A++) {
            if (n >= count){
                break;
            }
            if (isXY){
                break;
            }
            for (char B = 64; B <= 96; B++) {
                if (n >= count){
                    break;
                }
                if (isXY){
                    break;
                }
                for (int x = 1; x <= a; x++) {
                    if (n >= count){
                        break;
                    }
                    if (isXY){
                        break;
                    }
                    for (int y = 1; y <= b; y++) {
                        System.out.printf("%c%c%d%d%c%c|", A, B, x, y, B, A);
                        if (n >= count){
                            break;
                        }
                        if (x == a && y == b ){
                            isXY = true;
                            break;
                        }
                        A++;
                        B++;
                        n++;
                        if (A > 55){
                            A = 35;
                        }
                        if (B > 96){
                            B = 64;
                        }

                    }

                }

            }

        }

    }

}

