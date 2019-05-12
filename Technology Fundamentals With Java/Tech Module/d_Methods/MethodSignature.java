package d_Methods;

public class MethodSignature {
    public static void main(String[] args) {
        print(5);
        print("5");
        print("5", 5);

    }

    public static void print(String text) {
        System.out.println("STRING");
    }

    public static void print(int number) {
        System.out.println("INT");
    }

    public static void print(String text, int number) {
        System.out.println("STRING AND INT");
    }


}
