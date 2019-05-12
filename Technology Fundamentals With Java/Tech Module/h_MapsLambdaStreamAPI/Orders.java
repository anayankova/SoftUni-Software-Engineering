package h_MapsLambdaStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Double>> priceList = new LinkedHashMap<>();
        String line = reader.readLine();

        while (!line.equals("buy")){
            String[] product = line.split("\\s+");

            String productName = product[0];
            double price = Double.parseDouble(product[1]);
            double quantity = Double.parseDouble(product[2]);

            if (!priceList.containsKey(productName)){
                priceList.put(productName, new ArrayList<>());
                priceList.get(productName).add(price);
                priceList.get(productName).add(quantity);
            }else {
                priceList.get(productName).set(0, price);
                double oldQuantity = priceList.get(productName).get(1);
                priceList.get(productName).set(1, oldQuantity + quantity);
            }
            line = reader.readLine();
        }
        priceList.forEach((K, V) ->
                System.out.printf("%s -> %.2f\n",
                        K, V.get(0) * V.get(1)));
    }
}