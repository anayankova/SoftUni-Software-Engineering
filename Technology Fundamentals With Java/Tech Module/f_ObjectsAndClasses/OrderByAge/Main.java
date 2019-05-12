package f_ObjectsAndClasses.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        List<Person> people = new ArrayList<>();

        while (!"End".equals(input)){
            String[] data = scanner.nextLine().split("\\s+");
            input = data[0];
            if (input.equals("End")){
                break;
            }

            Person person = new Person(data[0], data[1], Integer.parseInt(data[2]));
            people.add(person);

        }

        people.stream().sorted(Comparator.comparingInt(Person::getAge))
                .forEach(e -> {
                    System.out.println(e.toString());
                } );

    }
}
