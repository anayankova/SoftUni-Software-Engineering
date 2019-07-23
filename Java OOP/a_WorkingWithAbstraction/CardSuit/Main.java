package a_WorkingWithAbstraction.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardSuit[] enums = CardSuit.values();

        System.out.println("Card Suits:");

        for (CardSuit value : enums){
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(), value));
        }

    }
}
