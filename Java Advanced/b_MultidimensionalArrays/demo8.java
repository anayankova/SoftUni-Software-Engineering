package b_MultidimensionalArrays;

import java.util.Arrays;

public class demo8 {
    public static void main(String[] args) {
        int[][] array = new int[3][4];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                System.out.print(array[row][col] = row + col);
                System.out.println(Arrays.toString(array[row]));

            }
        }

    }
}
