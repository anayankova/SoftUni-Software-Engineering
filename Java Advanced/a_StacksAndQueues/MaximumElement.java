package a_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];

            switch (command){
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                    numbers.push(element);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(numbers.stream().max(Integer::compareTo).get());
                    break;
            }
        }


    }
}
