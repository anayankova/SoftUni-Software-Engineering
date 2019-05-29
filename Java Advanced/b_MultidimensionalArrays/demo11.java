package b_MultidimensionalArrays;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random ra = new Random();

        int[][] multiArray = new int[Integer.parseInt(scanner.nextLine())][];

        for (int row = 0; row <multiArray.length ; row++) {
            int start = Math.abs(ra.nextInt());

            multiArray[row] = IntStream.range(start,start+row+1).toArray();

        }
        String command;
        while (!"Stop".equalsIgnoreCase(command = scanner.nextLine())){
            int index = Integer.parseInt(command);

            System.out.println(multiArray
                    [Math.abs(index % multiArray.length)]
                    [Math.abs(index % multiArray.length)]);
        }

    }
}
