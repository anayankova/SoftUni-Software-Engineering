package f_ObjectsAndClasses;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        //Collections.shuffle(words);
        //System.out.println(String.join(System.lineSeparator(),words));

        while (!words.isEmpty()){
            Random random = new Random();
            int randomIndex = random.nextInt(words.size());
            String word = words.get(randomIndex);
            System.out.println(word);
            words.remove(randomIndex);
        }

    }
}
