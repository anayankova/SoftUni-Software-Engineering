package examples;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        //System.out.println(a%10==a); // едноцифрено число
        //System.out.println(a%10!=a && a%100==a); // двуцифрено число
        System.out.println(a%10!=a && a%100!=a && a%1000==a); //трицифрено число
    }
}
