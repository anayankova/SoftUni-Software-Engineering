package f_ObjectsAndClasses;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dice dice = new Dice();
        //System.out.println(dice.getSides());
        //dice.setSides(2);
        //System.out.println(dice.getSides());
        //System.out.println(dice.getType());

        dice.roll();
        dice.roll();
        dice.roll();
        dice.roll();
        dice.roll();
        dice.roll();

    }

}
