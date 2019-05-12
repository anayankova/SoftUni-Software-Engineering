package k_ForLoop_Exercise;

import java.util.Scanner;

public class WeddingPresents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        int gifts = Integer.parseInt(scanner.nextLine());

        int groupA = 0;
        int groupB = 0;
        int groupV = 0;
        int groupG = 0;

        for (int i = 1; i <= gifts; i++) {
            String group = scanner.nextLine();

            if (group.equals("A")) {
                groupA++;
            } else if (group.equals("B")) {
                groupB++;
            } else if (group.equals("V")) {
                groupV++;
            } else if (group.equals("G")) {
                groupG++;
            }
        }

        double percentMoney = groupA * 1.0 / gifts * 100;
        double percentMachines = groupB * 1.0 / gifts * 100;
        double percentVouchers = groupV * 1.0 / gifts * 100;
        double percentOthers = groupG * 1.0 / gifts * 100;
        double percentPresents = gifts * 1.0 / guests * 100;

        System.out.printf("%.2f%%%n",percentMoney);
        System.out.printf("%.2f%%%n",percentMachines);
        System.out.printf("%.2f%%%n",percentVouchers);
        System.out.printf("%.2f%%%n",percentOthers);
        System.out.printf("%.2f%%%n",percentPresents);

    }
}
