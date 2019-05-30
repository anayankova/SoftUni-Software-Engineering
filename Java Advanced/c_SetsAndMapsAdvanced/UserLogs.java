package c_SetsAndMapsAdvanced;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";

        Map<String, Map<String, List<String>>> users = new TreeMap<>();

        while (!"end".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");

            String ip = data[0].substring(data[0].indexOf("=") + 1);
            String message = data[1].substring(data[1].indexOf("=") + 1);
            String user = data[2].substring(data[2].indexOf("=") + 1);

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>() {{
                    put(ip, new ArrayList<>() {{
                        add(message);
                    }});
                }});
            } else {
                if (!users.get(user).containsKey(ip)) {
                    users.get(user).put(ip, new ArrayList<>() {{
                        add(message);
                    }});
                } else {
                    users.get(user).get(ip).add(message);
                }
            }

        }


        users.forEach((user, ip) -> {
            System.out.println(user + ":");
            ip.forEach((ips, message) -> {

                if (counter == ip.size() - 1) {
                    System.out.printf("%s => %d.%n", ips, message.size());
                } else {

                    System.out.printf("%s => %d, ", ips, message.size());

                }
                counter++;
            });
            counter = 0;
        });

    }

    private static int counter = 0;
}


