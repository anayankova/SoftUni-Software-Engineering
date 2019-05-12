package i_TextProcessingAndRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split(",\\s*");

        Map<String, List<Double>> validDemon = new TreeMap<>();

        for (String s : demons) {
            s = s.trim();
            validDemon.put(s, new ArrayList<>());
        }

        for (String s : validDemon.keySet()) {

            double health = 0;
            double damage = 0;

            Pattern patternDigits = Pattern.compile("[-+]?\\d*\\.?\\d+");
            Matcher matchDigits = patternDigits.matcher(s);

            while (matchDigits.find()) {
                damage += Double.parseDouble(matchDigits.group());
            }

            for (int i = 0; i < s.length(); i++) {
                char symbol = s.charAt(i);

                if (!Character.isDigit(symbol) && symbol != '+' && symbol != '-'
                        && symbol != '*' && symbol != '/' && symbol != '.') {
                    health += symbol;
                    //damage += Double.parseDouble(symbol + "");
                }
                if (symbol == '*') {
                    damage *= 2;
                } else if (symbol == '/') {
                    if (damage != 0) {
                        damage /= 2;
                    }
                }
            }
            validDemon.get(s).add(health);
            validDemon.get(s).add(damage);
        }

        validDemon.entrySet().forEach(e ->
                System.out.println(String.format("%s - %.0f health, %.2f damage"
                        , e.getKey(), e.getValue().get(0), e.getValue().get(1))));


    }
}
