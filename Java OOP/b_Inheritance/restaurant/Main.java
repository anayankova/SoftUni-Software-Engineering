package b_Inheritance.restaurant;

public class Main {
    public static void main(String[] args) {
        Cake cake = new Cake("Parking");
        System.out.println(cake.getCalories());
        System.out.println(cake.getGrams());
        System.out.println(cake.getName());
        System.out.println(cake.getPrice());

    }
}
