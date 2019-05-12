package c_Arrays;

public class demo1 {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
            //numbers[i] = 1;
            System.out.println(numbers[i]);

        numbers[5] = numbers[2] + numbers[7];
        //numbers[10] = 1; // ArrayIndexOutOfBoundsException
        numbers[9] = 1;
        System.out.println(numbers[9]);



    }
}
