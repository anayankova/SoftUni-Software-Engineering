package examples;

public class LibrariesSimpleCalculations {
    public static void main(String[] args) {

        //int number1 = 3;
        //double number2 = 4.5;
        //char symbol = '@';
        //String text = "hello";
        //Date today = new Date();

        /*
         * %s -> String
         * %d -> int,Integer
         * %f -> double,float
         * %c -> char
         * %.2f -> round to the second sign
         * %.15f -> round to the fifteenth sign
         * %n or \n -> a new line , нов ред
         * %02d -> int 2 -> 02; int 20 -> 20
         */

        //%c character
        //%d decimal (integer) number (base 10)
        //%e exponential floating-point number
        //%f floating-point number
        //%i integer (base 10)
        //%o octal number (base 8)
        //%s a string of characters
        //%u unsigned decimal (integer) number
        //%x number in hexadecimal (base 16)
        //%% print a percent sign
        //\% print a percent sign

        /*
         * Math.ceil(number) -> round down
         * Math.floor(number) -> round up
         * Math.round(number) -> round 5.6 -> 6 ; 5.4 -> 5
         * Math.pow(num1,num2) -> grade number
         * Math.abs -> абсолютна стойност
         * Math.max(num1,num2) -> bigger number
         * Math.min(num1,num2) -> smaller number
         */

        //double result = Math.ceil(19.01);
        //System.out.println(result);               //резултат 20.0
        //double res = Math.floor(19.01);
        //System.out.println(res);                  //резултат 19.0
        //double re = 19.566666;
        //System.out.printf("%.2f%n", re);          //резултат 19,57
        //double reg = 19.566666;
        //System.out.printf("%.4f%n", reg);         //резултат 19,5667
        //double a = 22.22;
        //System.out.println((int)a);               //резултат 22

        //int a = 25;
        //int i = a / 4;      // извършваме т.нар. целочислено деление:
        //                    // резултатът от тази операция ще бъде 6 – дробната част се отрязва,
        //                    // тъй като извършваме деление с цели числа
        //int f = a / 4.0;    // 6.25 – дробно деление. Изрично сме указали числото 4 да се интерпретира
        //                    // като дробно, като сме добавили десетичната точка, следвана от нула
        //int error = a / 0;  // Грешка: целочислено деление на 0

        //int a = 25;
        //System.out.println(a / 4);  // Целочислен резултат: 6
        //System.out.println(a / 0);  // Грешка: деление на 0

        //int a = 15;
        //System.out.println(a / 2.0);        // Дробен резултат: 7.5
        //System.out.println(a / 0.0);     // Резултат: Infinity
        //System.out.println(-a / 0.0);    // Резултат: -Infinity
        //System.out.println(0.0 / 0.0);   // Резултат: NaN (Not a Number), т.е. резултатът
        //                                 // от операцията не е валидна числена стойност

        //int a=7;
        //int b=5;
        //int product = a%b;                //резултат 2 (остатък)


    }
}
