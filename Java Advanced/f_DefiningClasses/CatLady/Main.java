package f_DefiningClasses.CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        HashMap<String, Siamese> siameseCat = new HashMap<>();
        HashMap<String, Cymric> cymricCat = new HashMap<>();
        HashMap<String, StreetExtraordinaire> streetCat = new HashMap<>();

        while (!data.equals("End")){
            String[] tokens = data.split("\\s+");

            String breed = tokens[0];
            String name = tokens[1];
            double specialData = Double.parseDouble(tokens[2]);

            switch (breed){
                case "Siamese":
                    Siamese cat = new Siamese(name, specialData);
                    siameseCat.putIfAbsent(name, cat);
                    break;
                case "Cymric":
                    Cymric cat1 = new Cymric(name, specialData);
                    cymricCat.putIfAbsent(name, cat1);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire cat2 = new StreetExtraordinaire(name, specialData);
                    streetCat.putIfAbsent(name, cat2);
                    break;
            }


            data = scanner.nextLine();
        }

        String catName = scanner.nextLine();

        if(siameseCat.containsKey(catName)){
            Siamese cat = siameseCat.get(catName);
            System.out.println(String.format("Siamese %s %.2f", cat.getName(), (double)cat.getEarSize()));
        }else if(cymricCat.containsKey(catName)){
            Cymric cat1 = cymricCat.get(catName);
            System.out.println(String.format("Cymric %s %.2f", cat1.getName(), (double)cat1.getFurLength()));
        }else {
            StreetExtraordinaire cat2 = streetCat.get(catName);
            System.out.println(String.format("StreetExtraordinaire %s %.2f", cat2.getName(), (double)cat2.getDecibelsOfMeows()));
        }

    }
}
