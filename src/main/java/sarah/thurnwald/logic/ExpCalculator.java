package sarah.thurnwald.logic;

import sarah.thurnwald.data.Pokemon;

public class ExpCalculator {

    public int calculateExp(Pokemon playerPokemon, Pokemon enemyPokemon) {
        return (int) Math.floor((double) ((enemyPokemon.getBasicExp() * enemyPokemon.getLevel()) / 5) * ((Math.pow(2 * enemyPokemon.getLevel() + 10, 2.5)) / (Math.pow(enemyPokemon.getLevel() + playerPokemon.getLevel() + 10, 2.5))) + 1);
    }

}
