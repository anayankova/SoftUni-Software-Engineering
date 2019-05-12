package d_Methods;

import java.util.Scanner;

public class GreaterOfTwoValues2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        switch (text) {
            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(a, b));
                break;
            case "char":
                char f = scanner.nextLine().charAt(0);
                char s = scanner.nextLine().charAt(0);
                System.out.println(getMax(f, s));
                break;
            case "string":
                String t1 = scanner.nextLine();
                String t2 = scanner.nextLine();
                System.out.println(getMax(t1,t2));
                break;
        }

    }

    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static char getMax(char f, char s) {
        if (f > s) {
            return f;
        }
        return s;
    }

    public static String getMax(String t1, String t2) {
        if (t1.compareTo(t2) >= 0) {
            return t1;
        }
        return t2;
    }

}
