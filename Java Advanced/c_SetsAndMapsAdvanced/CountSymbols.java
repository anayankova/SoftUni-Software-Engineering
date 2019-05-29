package c_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if(!symbols.containsKey(symbol)){
                symbols.put(symbol, 1);
            }else {
                symbols.put(symbol, symbols.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> keyValuePair : symbols.entrySet()){
            System.out.printf("%c: %d time/s%n", keyValuePair.getKey(), keyValuePair.getValue());
        }

    }
}
