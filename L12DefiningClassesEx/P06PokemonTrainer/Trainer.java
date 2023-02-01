package L12DefiningClassesEx.P06PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonCollection;

    public Trainer(String name, List<Pokemon> pokemonCollection) {
        this.name = name;
        this.badges = 0;
        this.pokemonCollection = pokemonCollection;
    }

    public int getBadges() {
        return this.badges;
    }

    public void executionOfCommand(String command) {
        if (exists(command)) {
            this.badges++;
        } else {
            for (int i = 0; i < pokemonCollection.size(); i++) {
                pokemonCollection.get(i).setHealth(pokemonCollection.get(i).getHealth() - 10);
                if (pokemonCollection.get(i).getHealth() <= 0) {
                    pokemonCollection.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean exists(String command) {
        for (Pokemon pokemon : pokemonCollection) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemonCollection.size());
    }
}
