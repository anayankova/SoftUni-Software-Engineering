package e_Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo4Reading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());
            list.add(number);
        }
        for (Integer aList : list) {
            System.out.println(aList);
        }

    }
}
