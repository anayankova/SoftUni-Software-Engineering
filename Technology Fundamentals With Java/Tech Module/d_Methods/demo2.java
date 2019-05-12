package d_Methods;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        printNumbers(5, 10);
        System.out.println();
        printStudent("Petur", 15,5.50);
    }

    static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", i);
        }
    }
    static void printStudent(String name, int age, double grade) {
        System.out.printf("Student: %s; Age: %d, Grade: %.2f\n",
                name, age, grade);
    }


}
