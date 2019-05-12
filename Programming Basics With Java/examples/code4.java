package examples;

import java.util.Scanner;

public class code4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char b = scanner.nextLine().charAt(0);

        String c = " ";
        System.out.println(a+c+a);

        char d = 'j';
        String e = "frozen";
        System.out.println(b);
        System.out.println(d);
        System.out.println(e.charAt(3));
        System.out.println(b+d+e.charAt(3));
        System.out.println(d+e.charAt(3));
        System.out.println('b'+d+e.charAt(3));
        System.out.println('b');
        System.out.println(+'b');
        System.out.println(+b);
        System.out.println('d');
        System.out.println(+d);
        System.out.println('e');
        System.out.println(+e.charAt(3));
        System.out.printf("%c+%c+%c",b,d,e.charAt(3) );

    }
}
