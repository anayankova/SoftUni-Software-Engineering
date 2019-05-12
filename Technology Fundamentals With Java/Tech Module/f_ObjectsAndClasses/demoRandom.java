package f_ObjectsAndClasses;

import java.util.Random;

public class demoRandom {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(110));
        System.out.println(random.nextInt(110));
        System.out.println(random.nextInt(200));

    }
}
