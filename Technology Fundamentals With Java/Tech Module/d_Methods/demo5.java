package d_Methods;

public class demo5 {
    public static void main(String[] args) {

        int a = 5;
        int b = a;
        doSomething(b);
        System.out.println(b);

    }

    private static void doSomething(int b) {
        b++;
        System.out.println(b);
    }
}
