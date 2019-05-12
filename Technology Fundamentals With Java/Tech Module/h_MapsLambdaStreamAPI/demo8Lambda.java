package h_MapsLambdaStreamAPI;

public class demo8Lambda {
    public static void main(String[] args) {

        Func lamExp = str -> {
            System.out.println(str.length());
            return str.substring(0, str.length()/2);
        };

       System.out.println(lamExp.method("Asd Asd Asd"));

       String result = doMagic("Asd Asd Asd",str -> {
           System.out.println(str.length());
           return str.substring(0, str.length()/2);
       });

        System.out.println(result);

    }

    static String doMagic(String text, demo7Lambda.Func foo) {
        return foo.method(text);

    }

    @FunctionalInterface
    interface Func {
        String method(String pram);
    }
}
