package j_Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waves = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> defenders = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> attackers = new ArrayDeque<>();

        for (int i = 1; i <= waves && !defenders.isEmpty(); i++) {

            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .forEach(attackers::push);

            if (i % 3 == 0) {
                int additionalDefender = Integer.parseInt(scanner.nextLine());
                defenders.offer(additionalDefender);
            }

            while (!defenders.isEmpty() && !attackers.isEmpty()) {

                int attacker = attackers.pop();

                int defender = defenders.poll();

                if (attacker > defender) {
                    attacker -= defender;
                    attackers.push(attacker);
                } else if (attacker < defender) {
                    defender -= attacker;
                    defenders.addFirst(defender);
                }

            }

        }

        if (defenders.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.printf("Warriors left: %s%n", String.join(", ", attackers.toString())
                    .replaceAll("\\[|\\]", ""));
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.printf("Plates left: %s%n", String.join(", ", defenders.toString())
                    .replaceAll("\\[|\\]", ""));
        }

    }
}
