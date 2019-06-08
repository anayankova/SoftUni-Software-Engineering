package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Predicate<String> isStartWithCapital = word -> Character.isUpperCase(word.charAt(0));

        List<String> capitalWords = Arrays.stream(words)
                .filter(isStartWithCapital)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());

        capitalWords.forEach(System.out::println);

    }
}
