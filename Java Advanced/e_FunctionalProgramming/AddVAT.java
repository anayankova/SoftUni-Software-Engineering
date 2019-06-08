package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] prices = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVat = d -> 1.2 * d;

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(d -> System.out.printf("%.2f%n", d));


    }
}
