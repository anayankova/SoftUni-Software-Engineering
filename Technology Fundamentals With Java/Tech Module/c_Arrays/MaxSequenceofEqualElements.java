package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();


        int maxCount = 0;
        int sequenceIndex = 0;
        int leftCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                        sequenceIndex = numbers[i];
                        leftCount = maxCount;
                    }
                } else {
                    break;
                }

            }
        }

        for (int i = 0; i <= maxCount; i++) {
            System.out.print(sequenceIndex + " ");
        }


    }
}
