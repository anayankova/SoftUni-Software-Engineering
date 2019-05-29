package b_MultidimensionalArrays;

import java.util.Arrays;

public class demo5 {
    public static void main(String[] args) {

        int[] someArr = {1, 2, 3, 4};
        int[][] someArr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        for (int row = 0; row < someArr2.length; row++) {
            System.out.println("Row: " + row);
            int[] r1 = someArr2[row];

            for (int col = 0; col < r1.length; col++) {
                System.out.print(" Col: "+ col);
            }
            System.out.println();
            System.out.println(Arrays.toString(r1));

        }

    }
}
