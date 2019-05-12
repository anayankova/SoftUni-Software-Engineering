package e_Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputData.length ; i++) {
            numbers.add(Integer.parseInt(inputData[i]));
        }

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!"end".equals(input)){
            String[] data = input.split(" ");

            if (data.length == 2){
                int num = Integer.parseInt(data[1]);
                numbers.add(num);
            }else {
                int num = Integer.parseInt(data[0]);

                for (int i = 0; i < numbers.size() ; i++) {
                    int currentElement = numbers.get(i);

                    if (currentElement + num <= maxCapacity){
                        numbers.set(i, currentElement + num);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]",""));

    }
}
