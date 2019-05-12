package j_FinalExams;

import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> bandsWithMembers = new LinkedHashMap<>();
        Map<String, Long> bandsWithPlayedTime = new LinkedHashMap<>();
        long totalTime = 0;

        String inputLine = "";

        while (!(inputLine = scanner.nextLine()).equals("start of concert")) {
            String[] inputParameters = inputLine.split("\\;\\s+");

            String command = inputParameters[0];
            String bandName = inputParameters[1];

            if (command.equals("Add")) {
                if (!bandsWithMembers.containsKey(bandName)) {
                    bandsWithMembers.put(bandName, new ArrayList<>());
                }

                String[] bandMembers = inputParameters[2].split("\\,\\s+");

                for (int i = 0; i < bandMembers.length; i++) {
                    if (!bandsWithMembers.get(bandName).contains(bandMembers[i])) {
                        bandsWithMembers.get(bandName).add(bandMembers[i]);
                    }
                }

            } else if (command.equals("Play")) {
                if (!bandsWithPlayedTime.containsKey(bandName)) {
                    bandsWithPlayedTime.put(bandName, 0L);
                }
                int playTime = Integer.parseInt(inputParameters[2]);
                totalTime += playTime;
                long oldPlayTime = bandsWithPlayedTime.get(bandName);
                bandsWithPlayedTime.put(bandName, oldPlayTime + playTime);
            }
        }

        System.out.println(String.format("Total time: %d", totalTime));

        bandsWithPlayedTime.entrySet().stream()
                .sorted((band1, band2) -> {
                    if(band2.getValue() > band1.getValue()){
                        return  1;
                    }else if (band2.getValue() < band1.getValue()){
                        return -1;
                    }else{
                        return band1.getKey().compareTo(band2.getKey());
                    }
                })
                .forEach(band -> {
                    System.out.println(String.format("%s -> %d", band.getKey(), band.getValue()));
                });

        String requestedBand = scanner.nextLine();
        System.out.println(requestedBand);

        bandsWithMembers.get(requestedBand)
                .forEach(member -> System.out.println("=> " + member));

    }
}
