package f_DefiningClasses.PokemonTrainer;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

   //private UnaryOperator<Pokemon> damagePokemon = pokemon ->
   //        new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth());

   //public void absentPokemonPenalty() {
   //    this.pokeCollection = this.pokeCollection
   //            .stream()
   //            .map(damagePokemon)
   //            .filter(pokemon -> pokemon.getHealth() > 0)
   //            .collect(Collectors.toList());
   //}

   //public int damagePokemon() {
   //    return this.health -= 10; //Pokemon class method
   //}

   //private Predicate<Pokemon> damageThenFilterDeadPokemon = pokemon -> pokemon.damagePokemon() > 0;

   //public void absentPokemonPenalty() {
   //    this.pokeCollection = this.pokeCollection
   //            .stream()
   //            .filter(damageThenFilterDeadPokemon)
   //            .collect(Collectors.toList());
   //}
}
