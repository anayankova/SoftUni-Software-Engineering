package a_StacksAndQueues;

import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(GetSumEven(data));


    }

    public static int GetSumEven(int[] array)
    {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        return sum;
    }
}
