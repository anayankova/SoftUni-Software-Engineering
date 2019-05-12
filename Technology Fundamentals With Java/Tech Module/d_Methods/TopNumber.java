package d_Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            String number = i+"";
            int count = 0;
            int sum = 0;
            int topNumber = 0;
            for (int j = 0; j < number.length() ; j++) {
                char symbol = number.charAt(j);
                int digit = Integer.parseInt(symbol+"");
                if (digit % 2 != 0){
                    count++;
                }
                sum +=digit;
            }
            if (sum % 8 == 0 && count > 0){
                topNumber = i;
                System.out.println(topNumber);
            }
        }

    }
}
