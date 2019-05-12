package i_TextProcessingAndRegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^>>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*?)!(?<quantity>\\d+)\\b";

        Pattern pattern = Pattern.compile(regex);

        String input = "";
        double productTotalPrice = 0.0;
        double totatPrice = 0.0;

        List<String> furnitureName = new ArrayList<>();

        while (!"Purchase".equalsIgnoreCase(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                productTotalPrice = price * quantity;

                totatPrice += productTotalPrice;

                furnitureName.add(furniture);
            }
        }

        System.out.println("Bought furniture:");

        for (String furniture : furnitureName) {
            System.out.println(furniture);
        }
        System.out.println(String.format("Total money spend: %.2f", totatPrice));

    }
}
