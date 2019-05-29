package a_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Stack;

public class demo1Stacks {
    public static void main(String[] args) {

        Stack<String> op = new Stack<>();

        ArrayDeque<Integer> stack1 = new ArrayDeque<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        Integer element1 = stack1.pop();
        Integer element2 = stack1.peek();

        System.out.println(element1);
        System.out.println(element2);


        ArrayDeque<Integer> stack2 = new ArrayDeque<>();

        stack2.push(2);

        int size = stack2.size();
        boolean isEmpty = stack2.isEmpty();
        boolean exists1 = stack2.contains(2);
        boolean exists2 = stack2.contains(3);

        System.out.println(size);
        System.out.println(isEmpty);
        System.out.println(exists1);
        System.out.println(exists2);

    }
}
