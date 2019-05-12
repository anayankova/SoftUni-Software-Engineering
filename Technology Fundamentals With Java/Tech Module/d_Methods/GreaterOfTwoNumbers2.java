package d_Methods;

import java.util.Scanner;

public class GreaterOfTwoNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type){
            case "int": {
                int value1 = Integer.parseInt(scanner.nextLine());
                int value2 = Integer.parseInt(scanner.nextLine());
                int greater = Max(value1, value2);
                System.out.println(greater);
                break;
            }
            case "char":{
                char char1 ;
                char char2 ;
                char1 = scanner.nextLine().charAt(0);
                char2 = scanner.nextLine().charAt(0);
                char greater = Max(char1, char2);
                System.out.println(greater);
                break;
            }

            case "string":{
                String value1 = scanner.nextLine();
                String value2 = scanner.nextLine();
                String greater = Max(value1, value2);
                System.out.println(greater);
                break;
            }
        }
    }


    private static int Max(int int1, int int2) {
        if (int1 > int2){
            return int1;
        }
        return int2;
    }
    private static char Max(char char1, char char2) {
        if (char1 > char2){
            return char1;
        }
        return char2;
    }
    private static String Max(String str1, String str2) {
        int first = str1.compareTo(str2);
        if (first >= 0){
            return str1;
        }
        return str2;
    }
}