package g_MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> quests = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = "";

        while (!"Retire!".equals(input = scanner.nextLine())) {
            List<String> data = Arrays.stream(input.split(" - "))
                    .collect(Collectors.toList());
            String command = data.get(0);

            switch (command) {
                case "Start":
                    if (!quests.contains(data.get(1))) {
                        quests.add(data.get(1));
                    }
                    break;
                case "Complete":
                    quests.remove(data.get(1));
                    break;
                case "Side Quest":
                    List<String> sideQuest = Arrays.stream(data.get(1).split(":"))
                            .collect(Collectors.toList());
                    if (quests.contains(sideQuest.get(0)) && !quests.contains(sideQuest.get(1))) {
                        int indexOfTheQuest = quests.indexOf(sideQuest.get(0));
                        quests.add(indexOfTheQuest + 1,sideQuest.get(1));
                    }
                    break;
                case "Renew":
                    if (quests.contains(data.get(1))) {
                        quests.remove(data.get(1));
                        quests.add(data.get(1));
                    }
                    break;
            }
        }

        System.out.println(quests.toString().replaceAll("[\\[\\]]", ""));

    }
}
