package f_DefiningClasses.PokemonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private  int num;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.num = 0;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
