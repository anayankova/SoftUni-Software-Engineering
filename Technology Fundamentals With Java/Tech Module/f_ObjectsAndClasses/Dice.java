package f_ObjectsAndClasses;

import java.util.Random;

public class Dice {
    private int sides;
    private String type;

    public Dice() {
        System.out.println("My constructor");
        this.sides = 4;
        this.type = "A";
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void roll(){
        Random random = new Random();
        System.out.println(random.nextInt(this.sides));
    }
}
