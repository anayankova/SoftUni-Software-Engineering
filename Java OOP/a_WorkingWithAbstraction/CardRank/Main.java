package a_WorkingWithAbstraction.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank[] enums = CardRank.values();

        System.out.println("Card Ranks:");

        for (CardRank value : enums){
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(), value));
        }

    }
}
