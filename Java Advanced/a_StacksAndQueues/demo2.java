package a_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("//s+"))
                .forEach(element -> stack.push(element));

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }


    }
}
