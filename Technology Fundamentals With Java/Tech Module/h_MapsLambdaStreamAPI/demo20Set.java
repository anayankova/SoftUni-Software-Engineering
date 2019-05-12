package h_MapsLambdaStreamAPI;

import java.util.HashSet;
import java.util.Set;

public class demo20Set {
    public static void main(String[] args) {
        Set<Integer> someSet = new HashSet<>();

        someSet.add(1);
        someSet.add(2);
        someSet.add(3);
        someSet.add(1);
        someSet.add(1);

        someSet.contains(2);

        System.out.println(someSet);

    }
}
