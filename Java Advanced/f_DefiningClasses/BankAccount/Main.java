package f_DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        //BankAccount ba1 = new BankAccount();
        //BankAccount ba2 = new BankAccount();
        //BankAccount ba3 = new BankAccount();
        //BankAccount ba4 = new BankAccount();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens.length) {
                case 1:
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    System.out.println(String.format("Account ID%d created", bankAccount.getId()));
                    break;
                case 2:
                    double rate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(rate);
                    break;
                case 3:
                    int id = Integer.parseInt(tokens[1]);
                    if (!bankAccountMap.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount bk1 = bankAccountMap.get(id);
                        if ("Deposit".equalsIgnoreCase(tokens[0])) {
                            double amount = Double.parseDouble(tokens[2]);
                            bk1.deposit(amount);
                            System.out.println(String.format("Deposited %.0f to ID%d", amount, id));
                        } else {
                            int years = Integer.parseInt(tokens[2]);
                            System.out.println(String.format("%.2f", bk1.getInterest(years)));

                        }
                    }
                    break;
            }
        }

    }
}
