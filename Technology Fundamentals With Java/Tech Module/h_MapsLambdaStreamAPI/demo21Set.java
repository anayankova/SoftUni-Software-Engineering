package h_MapsLambdaStreamAPI;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo21Set {
    public static void main(String[] args) {

        Set<Integer> someSet = new HashSet<>();
        List<Integer> someList = new ArrayList<>();

        for (int i = 0; i <500000 ; i++) {
            someList.add(i);
            someSet.add(i);
        }

        Instant start = Instant.now();
        System.out.println(someList.contains(300000));
        Instant stop = Instant.now();
        System.out.println(Duration.between(start,stop));

        Instant start1 = Instant.now();
        System.out.println(someSet.contains(300000));
        Instant stop1 = Instant.now();
        System.out.println(Duration.between(start1,stop1));

    }
}
