package c_SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();
        String guestId = scanner.nextLine();

        while (!guestId.equals("PARTY")) {
            if (Character.isDigit(guestId.charAt(0))) {
                vip.add(guestId);
            }else {
                regular.add(guestId);
            }
            guestId = scanner.nextLine();
        }
//TODO: Remove the guests who came to the party
        while (!guestId.equals("END")){
            vip.remove(guestId);
            regular.remove(guestId);
            guestId= scanner.nextLine();
        }
//TODO: Print results
        System.out.println(vip.size()+regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);

    }
}
