package f_ObjectsAndClasses;

public class Main2 {
    public static void main(String[] args) {
        Dice2 dice = new Dice2(); //take this without args
        Dice2 dice1 = new Dice2(4,"A"); // take this with args
        Dice2 dice2 = new Dice2(5,"B");
        Dice2 dice3 = new Dice2(6,"C");
        System.out.println(dice1.getType());
        System.out.println(dice2.getType());
        System.out.println(dice3.getType());

    }
}
