package i_TextProcessingAndRegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

         int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("[star]",Pattern.CASE_INSENSITIVE);

         while (n-- > 0){
             String encryptedMessage = scanner.nextLine();

             Matcher matcher = pattern.matcher(encryptedMessage);

             int countLetters = 0;
             while (matcher.find()){
                 countLetters++;
             }

             String decryptMessage = "";
             for (int i = 0; i < encryptedMessage.length(); i++) {
                 decryptMessage += String.valueOf(
                         Character.toChars(encryptedMessage.charAt(i) - countLetters));
             }

             String regex = "@([A-Za-z]+)(?:[^@!\\-:>]*):(\\d+)(?:[^@!\\-:>]*)!([A|D])!(?:[^@!\\-:>]*)->(\\d+)";
             Pattern patternPlanets = Pattern.compile(regex);

             Matcher matcherPlanets = patternPlanets.matcher(decryptMessage);

             while (matcherPlanets.find()){
                 String planetName = matcherPlanets.group(1);
                 String attackedType = matcherPlanets.group(3);

                 if(attackedType.equals("A")){
                     attackedPlanets.add(planetName);
                 }else {
                     destroyedPlanets.add(planetName);
                 }
             }
         }

        System.out.println(String.format("Attacked planets: %d",attackedPlanets.size()));
         attackedPlanets.stream()
                 .sorted(String::compareTo)
                 .forEach(e -> System.out.println(String.format("-> %s", e)));

        System.out.println(String.format("Destroyed planets: %d",destroyedPlanets.size()));
        destroyedPlanets.stream()
                .sorted(String::compareTo)
                .forEach(e -> System.out.println(String.format("-> %s", e)));



    }
}
