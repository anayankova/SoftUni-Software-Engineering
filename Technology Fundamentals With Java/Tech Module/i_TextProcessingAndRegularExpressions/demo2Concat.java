package i_TextProcessingAndRegularExpressions;

public class demo2Concat {
    public static void main(String[] args) {
        String text = "Hello" + ", " + "world!";
         // "Hello, world!"
        String text1 = "Hello, ";
        text1 += "John"; // "Hello, John"
        String greet = "Hello, ";
        String name = "John";
        String result = greet.concat(name);
        System.out.println(result); // "Hello, John"



    }
}
