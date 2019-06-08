package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = str -> System.out.println("Sir " + str);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);

    }
}
