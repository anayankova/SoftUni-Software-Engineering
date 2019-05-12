package f_ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        Random rnd = new Random();
        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = rnd.nextInt(words.length);
            //TODO: Swap words[pos1] with words[pos2]
            words[pos1]=words[pos2];
        }
        System.out.println(String.join(System.lineSeparator(), words));


    }
}
