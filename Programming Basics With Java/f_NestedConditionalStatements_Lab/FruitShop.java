package f_NestedConditionalStatements_Lab;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        boolean isWeekDay = day.equals("Monday")
                || day.equals("Tuesday")
                || day.equals("Wednesday")
                || day.equals("Thursday")
                || day.equals("Friday");


        if (isWeekDay){
            if (fruit.equals("banana")){
                System.out.println(quantity*2.5);
            }else if (fruit.equals("apple")){
                System.out.println(quantity*1.2);
            }else if (fruit.equals("orange")){
                System.out.println(quantity*0.85);
            }else if (fruit.equals("grapefruit")) {
                System.out.println(quantity * 1.45);
            }else if (fruit.equals("kiwi")){
                System.out.println(quantity*2.7);
            }else if (fruit.equals("pineapple")){
                System.out.println(quantity*5.5);
            }else if (fruit.equals("grapes")){
                System.out.println(quantity*3.85);
            }else{
                System.out.println("error");
            }


        }else if(day.equals("Saturday") || day.equals("Sunday")){
            if (fruit.equals("banana")){
                System.out.println(quantity*2.7);
            }else if (fruit.equals("apple")){
                System.out.println(quantity*1.25);
            }else if (fruit.equals("orange")){
                System.out.println(quantity*0.90);
            }else if (fruit.equals("grapefruit")) {
                System.out.println(quantity * 1.60);
            }else if (fruit.equals("kiwi")){
                System.out.println(quantity*3);
            }else if (fruit.equals("pineapple")){
                System.out.println(quantity*5.6);
            }else if (fruit.equals("grapes")){
                System.out.println(quantity*4.2);
            }else{
                System.out.println("error");
            }
        }else {
            System.out.println("error");
        }

    }
}
