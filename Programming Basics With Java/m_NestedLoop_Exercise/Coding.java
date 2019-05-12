package m_NestedLoop_Exercise;

import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String number = n + "";  //числото в стринг
        int length = number.length();  // колко реда да принтираме

        for (int i = 1; i <= length; i++) {
            char count = number.charAt(number.length() - i);
            int counter = Integer.parseInt(count + "");  //превръщаме char стринга и го парсваме към int
            char symbolToRepeat = (char) (33 + counter);  //числото counter + 33 в char

            if (counter ==0){
                System.out.println("ZERO");
                continue;  //продължи към следващия ред и той може да е 0
            }

            for (int j = 1; j <= counter ; j++) {
                System.out.print(symbolToRepeat);
            }
            System.out.println();

        }

    }
}
