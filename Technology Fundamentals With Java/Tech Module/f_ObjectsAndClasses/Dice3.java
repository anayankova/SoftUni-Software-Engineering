package f_ObjectsAndClasses;

import java.util.Random;

public class Dice3 {
    public int sides;
    public int roll() {
        Random rnd = new Random();
        int sides = rnd.nextInt(this.sides + 1);
        return sides;
    }

    public Dice3() {
        this.sides = 6;
    }

    public Dice3(int sides) {
        this.sides = sides;
    }



}
