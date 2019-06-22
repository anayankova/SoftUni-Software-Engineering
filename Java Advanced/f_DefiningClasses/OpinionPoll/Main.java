package f_DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person p = new Person(name, age);

            people.add(p);

        }

        people.stream().filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.println(String.format("%s - %d", person.getName(), person.getAge())));

    }
}
