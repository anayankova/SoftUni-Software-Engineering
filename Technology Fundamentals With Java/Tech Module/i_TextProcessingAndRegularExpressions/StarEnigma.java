package i_TextProcessingAndRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = "";
        String result = "";
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            input = scanner.nextLine();
            int count = 0;
            for (int k = 0; k < input.length(); k++) {
                if (input.charAt(k) == 'S' || input.charAt(k) == 'T' ||
                        input.charAt(k) == 'A' || input.charAt(k) == 'R' ||
                        input.charAt(k) == 's' || input.charAt(k) == 't' ||
                        input.charAt(k) == 'a' || input.charAt(k) == 'r'){
                    count++;
                }
            }
            for (int i = 0; i < input.length(); i++) {
                result = input.replace(input.charAt(i), (char) (input.charAt(i) - count));
                sb.append(result.charAt(i));
            }
            list.add(sb.toString());
            sb.setLength(0);
        }

        String regex = "@(?<name>[A-Z][a-z]+)\\d*?:(?<population>\\d+)!(?<type>[AD])!->(?<soldierCount>\\d+)";

        //@(?<name>[A-Z][a-z]+)\d*?(?:[^@\-!:>]*):(?<population>\d+)(?:[^@\-!:>]*)!(?<type>[AD])(?:[^@\-!:>]*)!->(?<soldierCount>\d+)(?:[^@\-!:>]*)

        Pattern pattern = Pattern.compile(regex);

        Map<String,String> attackedPlanet = new TreeMap<>();
        Map<String,String> destroyedPlanet = new TreeMap<>();

        for (String s : list) {
            Matcher matcher = pattern.matcher(s);

            if(matcher.find()){
                String name = matcher.group("name");
                String population = matcher.group("population");
                String type = matcher.group("type");
                int soldierCount = Integer.parseInt(matcher.group("soldierCount"));

                if(type.equals("A")){
                    attackedPlanet.put(name,type);
                }else if (type.equals("D")){
                    destroyedPlanet.put(name,type);
                }
            }

        }

        System.out.println(String.format("Attacked planets: %d",attackedPlanet.size()));
        for (String e : attackedPlanet.keySet()) {
            System.out.println(String.format("-> %s", e));
        }
        System.out.println(String.format("Destroyed planets: %d",destroyedPlanet.size()));
        for (String e : destroyedPlanet.keySet()) {
            System.out.println(String.format("-> %s", e));
        }


    }
}
