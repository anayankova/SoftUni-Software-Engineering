package i_WhileLoop_Exercise;

import java.util.Scanner;

public class CGD2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        //function gcd(a, b)
       // while a ≠ b
       // if a > b
       // a := a – b
       // else
       // b := b – a
       // return a


        while (a != b){
            if(a > b){
                a = a - b;
            }else{
                b = b -a;
            }
        }
        System.out.println(a);

    }
}
