package f_NestedConditionalStatements_Lab;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        if(town.equals("Sofia")){
            if(product.equals("coffee")){
                System.out.println(quantity*0.5);
            }else if (product.equals("water")){
                System.out.println(quantity*0.8);
            }else if(product.equals("sweets")){
                System.out.println(quantity*1.45);
            }else if(product.equals("beer")){
                System.out.println(quantity*1.2);
            }else if(product.equals("peanuts")){
                System.out.println(quantity*1.6);
            }
        }else if(town.equals("Varna")){
            if(product.equals("coffee")){
                System.out.println(quantity*0.45);
            }else if (product.equals("water")){
                System.out.println(quantity*0.7);
            }else if(product.equals("sweets")){
                System.out.println(quantity*1.35);
            }else if(product.equals("beer")){
                System.out.println(quantity*1.1);
            }else if(product.equals("peanuts")){
                System.out.println(quantity*1.55);
            }

        }else if(town.equals("Plovdiv")){
            if(product.equals("coffee")){
                System.out.println(quantity*0.4);
            }else if (product.equals("water")){
                System.out.println(quantity*0.7);
            }else if(product.equals("sweets")){
                System.out.println(quantity*1.30);
            }else if(product.equals("beer")){
                System.out.println(quantity*1.15);
            }else if(product.equals("peanuts")){
                System.out.println(quantity*1.5);
            }
        }

    }
}
