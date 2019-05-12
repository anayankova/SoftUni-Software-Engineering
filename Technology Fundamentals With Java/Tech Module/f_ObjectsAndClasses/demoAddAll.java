package f_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demoAddAll {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(7,8,9));

        list1.addAll(list2);

        System.out.println(list1.toString().replaceAll("[\\[\\],]",""));

    }
}
