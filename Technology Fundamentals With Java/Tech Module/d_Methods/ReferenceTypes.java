package d_Methods;

public class ReferenceTypes {
    public static void main(String[] args) {
        int[] num = { 5 };
        increment(num, 15);
        System.out.println(num[0]);
    }

    public static void increment(int[] num, int value) {
        num[0] += value;
    }

}
