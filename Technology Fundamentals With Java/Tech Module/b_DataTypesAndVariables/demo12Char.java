package b_DataTypesAndVariables;

public class demo12Char {
    public static void main(String[] args) {
        char ch = 'a';
        System.out.printf("The code of '%c' is: %d%n", ch, (int) ch);
        ch = 'b';
        System.out.printf("The code of '%c' is: %d%n", ch, (int) ch);
        ch = 'A';
        System.out.printf("The code of '%c' is: %d%n", ch, (int) ch);
        ch = 'щ';  // Cyrillic letter 'sht'
        System.out.printf("The code of '%c' is: %d%n", ch, (int) ch);


    }
}
