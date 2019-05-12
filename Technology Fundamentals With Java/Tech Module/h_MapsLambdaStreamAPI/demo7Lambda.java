package h_MapsLambdaStreamAPI;

public class demo7Lambda {
    public static void main(String[] args) {

        Func f = str -> "Hello, " + str;

        System.out.println(f.method("Ivan"));

        System.out.println(doMagic("Ivan", str -> str.substring(0, 2)));
        System.out.println(doMagic("Ananas", str -> str.replaceAll("a","S")));

    }

    static String doMagic(String text, Func foo){
        return foo.method(text);

    }

    @FunctionalInterface

    interface Func {
        String method (String pram);
    }
}
