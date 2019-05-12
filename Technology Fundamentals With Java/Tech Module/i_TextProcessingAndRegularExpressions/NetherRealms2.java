package i_TextProcessingAndRegularExpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s*");

        Pattern patternAlphabet = Pattern.compile("[^\\d\\-+*\\/.]");
        Pattern patternDigits = Pattern.compile("[-+]?\\d*\\.?\\d+");

        List<Demon> demons = new ArrayList<>();

        for (String text : input) {
            text = text.trim();

            Matcher mathAlphabet = patternAlphabet.matcher(text);
            Matcher matchDigits = patternDigits.matcher(text);

            int healthSum = 0;
            double damage = 0.0;

            while (mathAlphabet.find()) {
                healthSum += mathAlphabet.group(0).charAt(0);
            }

            while (matchDigits.find()) {
                damage += Double.parseDouble(matchDigits.group());
            }

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '*') {
                    damage *= 2;
                } else if (text.charAt(i) == '/') {
                    if (damage != 0) {
                        damage /= 2;
                    }
                }
            }

            Demon demon = null;
            if (text.length() > 1) {
                demon = new Demon(text, healthSum, damage);
            }
            demons.add(demon);
        }
        demons.stream().sorted(Comparator.comparing(Demon::getName))
                .forEach(System.out::println);
    }
}

class Demon {
    private String name;
    private Integer health;
    private Double damage;

    public Demon(String name, Integer health, Double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public Double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return String.format("%s - %d health, %.2f damage", this.getName(),
                this.getHealth(), this.getDamage());
    }
}

