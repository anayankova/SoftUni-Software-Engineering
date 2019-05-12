package e_Lists;

import java.util.*;
import java.util.stream.Collectors;


public class PokemonDontGo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sumOfRemovedElements = 0;
        while (numbers.size() > 0) {
            int indexInput = Integer.parseInt(scanner.nextLine());
            int valueHolder = 0;

            if (indexInput < 0) {
                valueHolder = numbers.get(0);
                numbers.remove(0);
                numbers.add(0, numbers.get(numbers.size() - 1));
            } else if (indexInput >= numbers.size()) {
                valueHolder = numbers.get(numbers.size() - 1);
                numbers.remove(numbers.size() - 1);
                numbers.add(numbers.size() , numbers.get(0));
            } else {
                valueHolder = numbers.get(indexInput);
                numbers.remove(indexInput);
            }
            sumOfRemovedElements += valueHolder;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) <= valueHolder) {
                    numbers.set(i, numbers.get(i) + valueHolder);
                } else {
                    numbers.set(i, numbers.get(i) - valueHolder);
                }
            }


        }
        System.out.println(sumOfRemovedElements);

    }
}