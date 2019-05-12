package d_Methods;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(a,b,c));

    }

    static int sum(int a,int b){
        return a + b;
    }

    static int subtract(int a,int b, int c){
        return sum(a,b)-c;
    }


}
