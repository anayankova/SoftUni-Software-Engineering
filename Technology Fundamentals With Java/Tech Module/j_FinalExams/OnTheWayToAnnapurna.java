package j_FinalExams;

import java.util.*;
import java.util.stream.Collectors;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        Map<String, List<String>> listOfStores = new HashMap<>();

        while (!(input = scanner.nextLine()).equals("END")){
            String[] data = input.split("\\-\\>");

            String command = data[0];
            String store = data[1];
            //String[] items = data[2].split(",");

            if(command.equals("Add")){
                List<String> items = Arrays.stream(data[2].split(",")).collect(Collectors.toList());
                listOfStores.putIfAbsent(store, new ArrayList<>());
                listOfStores.get(store).addAll(items);
            }else {
                listOfStores.remove(store);
            }

        }

        System.out.println("Stores list:");

        listOfStores.entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue().size(),
                            e1.getValue().size());
                    if (sort == 0) {
                        sort = e2.getKey().compareTo(e1.getKey());
                    }
                    return sort;
                })
                .forEach(kvp -> {
                    System.out.println(String.format("%s", kvp.getKey()));

                    kvp.getValue().forEach(u -> {
                        System.out.println(String.format("<<%s>>", u));
                    });
                });

    }
}
