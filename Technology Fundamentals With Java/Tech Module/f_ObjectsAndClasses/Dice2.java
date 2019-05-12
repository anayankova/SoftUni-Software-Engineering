package f_ObjectsAndClasses;

public class Dice2 {
    private int sides; //this = Dice
    private String type;

    public Dice2(int sides, String type) {
        this.sides = sides;
        this.type = type;
    }

    public Dice2(){
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
}
