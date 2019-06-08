package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String[] words = scanner.nextLine().split("\\s+");

        //Arrays.stream(words).forEach(word -> System.out.println(word));

        //Consumer<String> printer = word -> System.out.println(word);
        //
        //Arrays.stream(words).forEach(printer);

        Consumer<String> printer = System.out::println;
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);

    }
}
