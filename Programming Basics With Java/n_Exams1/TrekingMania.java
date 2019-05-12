package n_Exams1;

import java.util.Scanner;

public class TrekingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int groupMusala = 0;
        int groupMonblan = 0;
        int groupKilimandjaro = 0;
        int groupK2 = 0;
        int groupEverest = 0;

        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(scanner.nextLine());
            if (count <= 5) {
                groupMusala += count;
            } else if (count >= 6 && count <= 12) {
                groupMonblan += count;
            } else if (count >= 13 && count <= 25) {
                groupKilimandjaro += count;
            } else if (count >= 26 && count <= 40) {
                groupK2 += count;
            } else if (count >= 41) {
                groupEverest += count;
            }
        }

        int allPeople = groupEverest + groupK2 + groupKilimandjaro + groupMonblan + groupMusala;
        double percentMusala = groupMusala*1.0/allPeople*100;
        double percentMonblan = groupMonblan*1.0/allPeople*100;
        double percentKilimandjaro = groupKilimandjaro*1.0/allPeople*100;
        double percentK2 = groupK2*1.0/allPeople*100;
        double percentEverest = groupEverest*1.0/allPeople*100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%",percentMusala,percentMonblan,percentKilimandjaro,percentK2,percentEverest);

    }
}
