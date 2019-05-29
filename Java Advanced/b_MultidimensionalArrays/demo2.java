package b_MultidimensionalArrays;

import java.util.Arrays;

public class demo2 {
    public static void main(String[] args) {

        int[][][] inArray = new int[5][5][5];

        for (int[][] ints : inArray) {
            for (int[] anInt : ints) {
                System.out.println(Arrays.toString(anInt));
            }
        }


    }
}
