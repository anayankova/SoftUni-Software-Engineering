package e_FunctionalProgramming;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunctionWithMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random rand = new Random(0);

        int[][] matrix = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = rand.nextInt(1000);
            }

        }

        Function<int[], Integer> minNumber = arr -> {
            int min = Arrays.stream(arr).min().getAsInt();
            return min;
        };

        for (int r = 0; r < 10; r++) {
            System.out.println(minNumber.apply(matrix[r]));
        }


    }
}
