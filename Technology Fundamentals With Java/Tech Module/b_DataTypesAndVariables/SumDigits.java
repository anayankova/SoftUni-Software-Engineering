package b_DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //String numberInput = reader.readLine();
        int number = Integer.parseInt(reader.readLine());

        int sum = 0;
        while (number > 0){
         sum += number % 10;
        number/=10;}
        System.out.println(sum);

        //for (int i = 0; i < numberInput.length(); i++) {
        //    sum += Integer.parseInt(String.valueOf(numberInput.charAt(i)));
        //}
        //System.out.println(sum);


    }
}
