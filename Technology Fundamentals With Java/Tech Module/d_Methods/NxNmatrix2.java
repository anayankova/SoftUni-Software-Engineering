package d_Methods;

import java.util.Scanner;

public class NxNmatrix2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            System.out.println(newString(String.valueOf(n),n));
        }

    }

    private static String newString(String symbol, int count){
        String result = "";

        for (int i = 0; i <count ; i++) {
            result += symbol + " ";
        }
        return result.trim();
    }
}
