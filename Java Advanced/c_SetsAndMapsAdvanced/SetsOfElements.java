package c_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int first = data[0];
        int second = data[1];

        Set<Integer> firstElements = new LinkedHashSet<>();
        Set<Integer> secondElements = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            firstElements.add(input);
        }

        for (int i = 0; i < second; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            secondElements.add(input);
        }

        for(Integer element : firstElements){
            if(secondElements.contains(element)){
                System.out.print(element + " ");
            }
        }

    }
}
