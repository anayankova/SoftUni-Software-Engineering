package d_Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        switch (text) {
            case "int": {
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                int result = getMax(a, b);
                System.out.println(result);
                break;
            }
            case "char": {
                char f = scanner.nextLine().charAt(0);
                char s = scanner.nextLine().charAt(0);
                char result = getMax(f, s);
                System.out.println(result);
                break;
            }
            case "string": {
                String t1 = scanner.nextLine();
                String t2 = scanner.nextLine();
                String result = getMax(t1, t2);
                System.out.println(result);
                break;
            }
        }

    }

    private static int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private static char getMax(char f, char s) {
        if (f > s) {
            return f;
        }
        return s;
    }

    private static String getMax(String t1, String t2) {
        if (t1.compareTo(t2) >= 0) {
            return t1;
        }
        return t2;
    }

}
