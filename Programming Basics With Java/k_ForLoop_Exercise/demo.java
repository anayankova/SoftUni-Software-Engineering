package k_ForLoop_Exercise;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        for (int i = 0 ; i <= word.length() ; i++){
            System.out.println(word.charAt(i));   //(word.length() -1) //взима предпоследния символ
        }


    }
}
