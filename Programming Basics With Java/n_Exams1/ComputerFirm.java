package n_Exams1;

import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int units = 0;
        double sales = 0;
        double rating = 0;

        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
                units = num % 10;
                switch (units){
                    case 2:
                        sales += Math.floor(num*0.0/10);
                        rating += units;
                        break;
                    case 3:
                        sales += Math.floor(num*0.5/10);
                        rating += units;
                        break;
                    case 4:
                        sales += Math.floor(num*0.7/10);
                        rating += units;
                        break;
                    case 5:
                        sales += Math.floor(num*0.85/10);
                        rating += units;
                        break;
                    case 6:
                        sales += Math.floor(num*1.0/10);
                        rating += units;
                        break;
                        default:
                            break;
                }
        }
        System.out.printf("%.2f%n%.2f",sales,rating/n);

    }
}
