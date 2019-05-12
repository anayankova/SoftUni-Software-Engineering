package h_MapsLambdaStreamAPI;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, List<Double>>>
                dragonsType = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            String type = data[0];
            String name = data[1];
            double damage = data[2].equals("null") ? 45 : Double.parseDouble(data[2]);
            double health = data[3].equals("null") ? 250 : Double.parseDouble(data[3]);
            double armor = data[4].equals("null") ? 10 : Double.parseDouble(data[4]);

            List<Double> stats = new ArrayList<>();
            stats.add(damage);
            stats.add(health);
            stats.add(armor);

            if(!dragonsType.containsKey(type)){
                dragonsType.put(type, new TreeMap<>());
            }

            if (!dragonsType.get(type).containsKey(name)){
                dragonsType.get(type).put(name, new ArrayList<>());
            }

            dragonsType.get(type).get(name).clear();
            dragonsType.get(type).get(name).addAll(stats);
        }

        dragonsType.forEach((key, value) -> {
            double armor = 0;
            double health = 0;
            double damage = 0;

            TreeMap<String, List<Double>> dragonsWithStats =
                    value;

            for (List<Double> stats : value.values()){
                damage += stats.get(0);
                health += stats.get(1);
                armor += stats.get(2);
            }

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", key,
                    damage / dragonsWithStats.size(),
                    health / dragonsWithStats.size(),
                    armor / dragonsWithStats.size()));

            dragonsWithStats.forEach((d, s) -> {
                System.out.println(String.format(
                        "-%s -> damage: %.0f, health: %.0f, armor: %.0f",
                        d, s.get(0), s.get(1), s.get(2)));
            });
        });



    }
}
