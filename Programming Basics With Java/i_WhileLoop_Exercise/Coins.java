package i_WhileLoop_Exercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = Double.parseDouble(scanner.nextLine());
        double totalSum = Math.round(sum * 100);
        int countCoins = 0;

        while (totalSum > 0){
            if (totalSum >= 200){
                countCoins++;
                totalSum -= 200;
            }else if(totalSum >= 100){
                countCoins++;
                totalSum -= 100;
            }else if(totalSum >= 50){
                countCoins++;
                totalSum -= 50;
            }else if (totalSum >= 20){
                countCoins++;
                totalSum -= 20;
            }else if(totalSum >= 10){
                countCoins++;
                totalSum -=10;
            }else if(totalSum >= 5){
                countCoins++;
                totalSum -= 5;
            }else if (totalSum >= 2){
                countCoins++;
                totalSum -= 2;
            }else if (totalSum >= 1){
                countCoins++;
                totalSum -=1;
            }
        }
        System.out.println(countCoins);

    }
}
