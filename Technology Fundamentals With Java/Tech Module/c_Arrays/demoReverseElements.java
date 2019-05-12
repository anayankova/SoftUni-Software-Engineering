package c_Arrays;

import java.util.Scanner;

public class demoReverseElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] elements = sc.nextLine().split(" ");
        for (int i = 0; i < elements.length / 2; i++){
            String oldElement = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = oldElement;
        }
        System.out.println(String.join(" ", elements));


    }
}
