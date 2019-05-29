package a_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        String input = "";

        while (!"Home".equals(input = scanner.nextLine())) {
            if ("back".equals(input)) {
                if (history.size() > 1) {
                    forwardPages.push(history.pop());
                    System.out.println(history.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals(input)) {
                if (!forwardPages.isEmpty()) {
                    System.out.println(forwardPages.peek());
                    history.push(forwardPages.pop());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                history.push(input);
                System.out.println(input);
                forwardPages.clear();
            }
        }

    }
}
