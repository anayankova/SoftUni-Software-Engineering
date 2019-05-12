package d_Methods;

public class ValueTypes {
    public static void main(String[] args) {
        int num = 5;
        increment(num, 15);
        System.out.println(num);
    }

    public static void increment(int num, int value) {
        num += value;
    }

}
