package f_DefiningClasses.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> persons = new HashMap<>();
        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String entity = tokens[1];
            if (!persons.containsKey(name)) {
                persons.put(name, new Person(name));
            }

            switch (entity) {
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    persons.get(name).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    persons.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(tokens[2], tokens[3]);
                    persons.get(name).addParent(parent);
                    break;
                case "children":
                    Child child = new Child(tokens[2], tokens[3]);
                    persons.get(name).addChild(child);
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    persons.get(name).setCar(car);
                    break;
            }
        }

        String google = reader.readLine();
        Person person = persons.get(google);
        System.out.println(person.getName());
        System.out.println("Company:");
        if (person.getCompany() != null){
            System.out.printf("%s %s %.2f%n",
                    person.getCompany().getName(),
                    person.getCompany().getDepartment(),
                    person.getCompany().getSalary());
        }
        System.out.println("Car:");
        if (person.getCar() != null){
            System.out.printf("%s %d%n",
                    person.getCar().getModel(),
                    person.getCar().getSpeed());
        }
        System.out.println("Pokemon:");
        if (person.getPokemons().size() > 0){
            for (Pokemon pokemon : person.getPokemons()) {
                System.out.printf("%s %s%n",
                        pokemon.getName(),
                        pokemon.getType());
            }
        }
        System.out.println("Parents:");
        if (person.getParents().size() > 0){
            for (Parent parent : person.getParents()) {
                System.out.printf("%s %s%n",
                        parent.getName(),
                        parent.getBirthdy());
            }
        }
        System.out.println("Children:");
        if (person.getChildren().size() > 0){
            for (Child child : person.getChildren()) {
                System.out.printf("%s %s%n",
                        child.getName(),
                        child.getBirthdy());
            }
        }

    }
}
