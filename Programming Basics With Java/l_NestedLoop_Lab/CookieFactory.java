package l_NestedLoop_Lab;

import java.util.Scanner;

public class CookieFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            boolean hasFlour = false;
            boolean hasSugar = false;
            boolean hasEggs = false;

            batch:
            while (true) {
                String product = scanner.nextLine();
                switch (product) {
                    case "Bake!":
                        if (hasEggs && hasFlour && hasSugar) {
                            System.out.println("Baking batch number " + i + "...");
                            break batch;
                        } else {
                            System.out.println("The batter should contain flour, eggs and sugar!");
                            break;
                        }
                    case "flour":
                        hasFlour = true;
                        break;
                    case "sugar":
                        hasSugar = true;
                        break;
                    case "eggs":
                        hasEggs = true;
                        break;
                    default:
                        break;

                }
            }

        }

    }
}
