package c_Arrays;

public class demoForeach {
    public static void main(String[] args) {
        // int[] numbers = { 1, 2, 3, 4, 5 };
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;
        for (int number : numbers) {
            System.out.print(number + " ");
        }


    }
}
