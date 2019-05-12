package d_Methods;

public class demo6 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = a;
        b[0] = 10;
        doSomething(b);
        System.out.println(b[0]);
    }

    private static void doSomething(int[] b) {
        b = new int[3];
        b[0] = 20;
    }
}
