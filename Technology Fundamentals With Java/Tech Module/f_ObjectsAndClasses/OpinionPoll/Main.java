package f_ObjectsAndClasses.OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0){
            String[] data = reader.readLine().split("\\s+");

            Person person = new Person(data[0], Integer.parseInt(data[1]));
            people.add(person);
        }

        people.stream().filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e -> {
                    System.out.println(e.toString());
                } );
        //ArrayList<Person> result = new ArrayList<>();
       // for(Person person: people){
           // if (person.getAge() > 30){
               // result.add(person);
            //}
        }

    }

