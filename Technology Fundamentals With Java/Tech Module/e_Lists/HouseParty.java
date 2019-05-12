package e_Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String str = "";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            str = scanner.nextLine();
            String[] input = str.split(" ");

            if (!input[2].equals("not")){
                if (!list.contains(input[0])) {
                    list.add(input[0]);
                }else {
                    System.out.printf("%s is already in the list!%n",input[0]);
                }
            }else {
                if (!list.contains(input[0])){
                    System.out.printf("%s is not in the list!%n",input[0]);
                }else {
                    list.remove(input[0]);
                }
            }

        }

        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }

    }
}
