package e_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstGamer = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondGamer = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstGamer.size() > 0 && secondGamer.size() > 0) {
            if (firstGamer.get(0) > secondGamer.get(0)) {
                firstGamer.add(firstGamer.get(0));
                firstGamer.add(secondGamer.get(0));
                firstGamer.remove(0);
                secondGamer.remove(0);
            } else if (firstGamer.get(0) < secondGamer.get(0)) {
                secondGamer.add(secondGamer.get(0));
                secondGamer.add(firstGamer.get(0));
                firstGamer.remove(0);
                secondGamer.remove(0);
            } else if (firstGamer.get(0).equals(secondGamer.get(0))) {
                firstGamer.remove(0);
                secondGamer.remove(0);
            }
        }
        if (firstGamer.size() > secondGamer.size()) {
            int Sum = 0;
            for (int i = 0; i < firstGamer.size(); i++) {
                Sum += firstGamer.get(i);
            }
            System.out.printf("First player wins! Sum: %d", Sum);
        } else {
            int Sum = 0;
            for (int i = 0; i < secondGamer.size(); i++) {
                Sum += secondGamer.get(i);
            }
            System.out.printf("Second player wins! Sum: %d", Sum);
        }

    }
}
