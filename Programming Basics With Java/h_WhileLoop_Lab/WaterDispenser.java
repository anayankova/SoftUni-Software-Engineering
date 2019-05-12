package h_WhileLoop_Lab;

import java.util.Scanner;

public class WaterDispenser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int volume = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int num = 0;
        int count = 0;

        while (true){
            String input = scanner.nextLine();
            switch (input){
                case "Easy":
                    num = 50;
                    break;
                case "Medium":
                    num = 100;
                    break;
                case "Hard":
                    num = 200;
                    break;
            }
            sum += num;
            count++;
            if (volume == sum){
                System.out.printf("The dispenser has been tapped %d times.",count);
                break;
            }else if (sum > volume){
                int difference = sum - volume;
                System.out.printf("%dml has been spilled.",difference);
                break;
            }
        }

    }
}
