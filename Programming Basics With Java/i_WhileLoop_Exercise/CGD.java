package i_WhileLoop_Exercise;

import java.util.Scanner;

public class CGD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        //int division = b;
       // while (b != 0){

           // if (a > b){
             //   division = a % b;
              //  b /= division;
           // }else {
             //   division = b % a;
              //  a /= division;
           // }
       // }

        // := е оператор за присвояване на стойност
        //function gcd(a, b)
       // while b ≠ 0
       // var t := b
        //b := a mod b
        //a := t
        //return a

        while (b !=0){
            int division = b;
            b = a % b;
            a = division;
        }
        System.out.println(a);
    }
}
