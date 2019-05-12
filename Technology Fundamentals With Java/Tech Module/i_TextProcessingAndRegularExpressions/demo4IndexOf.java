package i_TextProcessingAndRegularExpressions;

public class demo4IndexOf {
    public static void main(String[] args) {

        //indexOf() - returns the first match index or -1

        String fruits = "banana, apple, kiwi, banana, apple";
        System.out.println(fruits.indexOf("banana"));    // 0
        System.out.println(fruits.indexOf("orange"));    // -1

        //lastIndexOf() - finds the last occurrence

        String fruits1 = "banana, apple, kiwi, banana, apple";
        System.out.println(fruits1.lastIndexOf("banana")); // 21
        System.out.println(fruits1.lastIndexOf("orange")); // -1



    }
}
