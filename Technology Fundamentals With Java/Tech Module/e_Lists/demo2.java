package e_Lists;

import java.util.ArrayList;
import java.util.List;

public class demo2 {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();

        nums.add(5);
        nums.add(10);
        nums.add(2);
        nums.remove(Integer.valueOf(10));
        nums.add(0,-5);
        for (int i = 0; i < nums.size() ; i++) {
            System.out.print(nums.get(i)+" ");
        }



    }
}
