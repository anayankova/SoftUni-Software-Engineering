package c_Arrays;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");
        //String[] maxArr;

        //if (firstArr.length >= secondArr.length){
        //    maxArr = firstArr;
        //}else {
        //   maxArr = secondArr;
        //}

        for (String aSecondArr : secondArr) {
            for (String aFirstArr : firstArr) {
                if (aSecondArr.equals(aFirstArr)) {
                    System.out.print(aSecondArr+" ");
                }
            }
        }


    }
}
