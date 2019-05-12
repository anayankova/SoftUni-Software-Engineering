package f_ObjectsAndClasses;

import java.time.LocalDateTime;
import java.util.Random;

public class demo2 {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        double cosine = Math.cos(Math.PI);

        System.out.println(today);
        System.out.println(cosine);

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(101);

        System.out.println(randomNumber);



    }
}
