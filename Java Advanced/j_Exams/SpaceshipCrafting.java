package j_Exams;

import java.util.*;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> items = new ArrayDeque<>();

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("Aluminium", 0);
        materials.put("Carbon fiber", 0);
        materials.put("Glass", 0);
        materials.put("Lithium", 0);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquids::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(items::push);

        while (liquids.size() > 0 && items.size() > 0) {
            int firstLiquid = liquids.peek();
            int lastItem = items.peek();

            int sum = firstLiquid + lastItem;

            if (sum == 25) {
                materials.put("Glass", materials.get("Glass") + 1);
                liquids.poll();
                items.pop();
            } else if (sum == 50) {
                materials.put("Aluminium", materials.get("Aluminium") + 1);
                liquids.poll();
                items.pop();
            } else if (sum == 75) {
                materials.put("Lithium", materials.get("Lithium") + 1);
                liquids.poll();
                items.pop();
            } else if (sum == 100) {
                materials.put("Carbon fiber", materials.get("Carbon fiber") + 1);
                liquids.poll();
                items.pop();
            } else {
                liquids.poll();
                lastItem += 3;
                items.pop();
                items.addFirst(lastItem);
            }

        }

        if (liquids.isEmpty() && items.isEmpty()) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
            System.out.println("Liquids left: none");
            System.out.println("Physical items left: none");
            materials.forEach((key, value) -> System.out.println(String.format("%s: %d", key, value)));
        }else if(!items.isEmpty()) {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
            System.out.println("Liquids left: none");
            System.out.print("Physical items left: ");
            if(items.size() > 1) {
                while (items.size() > 1) {
                    System.out.print(items.pop());
                    System.out.print(", ");
                }
            }
            System.out.print(items.pop());
            System.out.println();
            materials.forEach((key, value) -> System.out.println(String.format("%s: %d", key, value)));
        }

    }
}
