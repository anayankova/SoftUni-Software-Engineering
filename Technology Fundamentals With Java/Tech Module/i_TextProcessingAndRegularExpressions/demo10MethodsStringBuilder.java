package i_TextProcessingAndRegularExpressions;

public class demo10MethodsStringBuilder {
    public static void main(String[] args) {
        //append(…) – appends the string representation of the argument

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Peter, how are you?");

        //length(…) – holds the length of the string in the buffer

        sb.append("Hello Peter, how are you?");
        System.out.println(sb.length()); // 25

        //setLength(0) – removes all characters

        //char At(int index) – return char on current index

        StringBuilder sb1 = new StringBuilder();
        sb1.append("Hello Peter, how are you?");
        System.out.println(sb1.charAt(1)); // e

        //insert(int index, String str) – inserts a stringat the specified character position

        sb1.insert(11, " Ivanov");
        System.out.println(sb1);
        // Hello Peter Ivanov, how are you?

        //replace(int startIndex, int endIndex, String str)

        //replaces the characters in a substring

        sb.append("Hello Peter, how are you?");
        sb.replace(6, 11, "George");

        //toString() - converts the value of this instance to a String

        String text = sb.toString();
        System.out.println(text);
         // Hello George, how are you?





    }
}
