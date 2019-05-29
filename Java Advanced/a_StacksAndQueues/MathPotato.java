package a_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            //if (isPrime(cycle)) {
            //    System.out.println("Prime " + queue.peek());
            //} else {
            //    System.out.println("Removed " + queue.poll());
            //}
            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }
}
