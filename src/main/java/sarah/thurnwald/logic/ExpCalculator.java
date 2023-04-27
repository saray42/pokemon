package sarah.thurnwald.logic;

import sarah.thurnwald.data.pokemon.Pokemon;

public class ExpCalculator {

    public int calculateExp(Pokemon playerPokemon, Pokemon defeatedPokemon) {
        return (int) Math.floor((double) ((defeatedPokemon.getBasicExp() * defeatedPokemon.getLevel()) / 5) * ((Math.pow(2 * defeatedPokemon.getLevel() + 10, 2.5)) / (Math.pow(defeatedPokemon.getLevel() + playerPokemon.getLevel() + 10, 2.5))) + 1);
    }

}
