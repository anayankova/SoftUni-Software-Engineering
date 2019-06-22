package f_DefiningClasses.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input;

        while (!"Tournament".equals(input = bfr.readLine())) {

            String[] trainerData = input.split(" ");
            String name = trainerData[0];

            Trainer trainer;
            if (trainers.containsKey(name)) {
                trainer = trainers.get(name);
            } else {
                trainer = new Trainer(name);
            }

            String pokeName = trainerData[1];
            String element = trainerData[2];
            int health = Integer.parseInt(trainerData[3]);

            Pokemon pokemon = new Pokemon(pokeName, element, health);
           // trainer.addPokemon(pokemon);
            trainers.put(name, trainer);
        }

       // while (!"End".equals(input = bfr.readLine())) {
//
       //     for (Trainer trainer : trainers.values()) {
       //         boolean pokemonNotFound = true;
       //         for (Pokemon pokemon : trainer.getPokeCollection()) {
       //             if (pokemon.getElement().equals(input)) {
       //                 pokemonNotFound = false;
       //                 break;
       //             }
       //         }
       //         if (pokemonNotFound) {
       //             trainer.absentPokemonPenalty();
       //         } else {
       //             trainer.awardBadge();
       //         }
       //     }
//
       // }
       // trainers.values()
       //         .stream()
       //         .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
       //         .forEach(trainer -> System.out.println(trainer.printTrainer()));
    }
}
