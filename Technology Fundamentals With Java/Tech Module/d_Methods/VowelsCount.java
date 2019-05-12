package d_Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        System.out.println(vowelsCount(input, count));

    }

    static int vowelsCount(String input, int count){
        for (int i = 0; i < input.length() ; i++) {
            char symbol = input.toLowerCase().charAt(i);
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' ||
                symbol == 'o' || symbol == 'u' || symbol == 'y'){
                count++;
            }
        }
        return count;
    }
}
