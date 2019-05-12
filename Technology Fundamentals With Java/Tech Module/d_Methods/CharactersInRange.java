package d_Methods;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstInput = scanner.nextLine().charAt(0);
        char secondInput = scanner.nextLine().charAt(0);
        charactersInRange(firstInput,secondInput);

    }

    static void charactersInRange(char firstInput, char secondInput){
        if (firstInput < secondInput) {
            for (char i = firstInput; i < secondInput; i++) {
                if (i == firstInput) {
                    continue;
                } else {
                    System.out.print(i + " ");
                }
            }
        }else {
            for (char i = secondInput; i < firstInput; i++) {
                if (i == secondInput) {
                    continue;
                } else {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
