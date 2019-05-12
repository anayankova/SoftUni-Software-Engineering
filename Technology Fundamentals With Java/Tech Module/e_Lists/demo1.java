package e_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(
                Arrays.asList(10, 20, 30, 40, 50, 60));
        nums.remove(2);
        nums.remove(Integer.valueOf(40));
        nums.add(100);
        nums.add(0, -100);
        for (int i = 0; i < nums.size(); i++)
            System.out.print(nums.get(i) + " ");


    }
}
