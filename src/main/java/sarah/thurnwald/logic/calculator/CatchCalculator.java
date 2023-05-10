package sarah.thurnwald.logic.calculator;

import sarah.thurnwald.data.pokeball.Pokeball;
import sarah.thurnwald.data.pokemon.Pokemon;

public class CatchCalculator {
    public float calculateCatchRate(Pokemon wildPokemon, Pokeball pokeball) {
        float x = (((3 * wildPokemon.getMaxHealthStat() - 2 * wildPokemon.getCurrentHealthStat())
                * wildPokemon.getData().getCatchRate() * pokeball.getCatchRate()) / 3 * wildPokemon.getMaxHealthStat());
        return (float) Math.floor((Math.pow(x / 255, (double) 3 / 4)) / 10);
    }
}
