package sarah.thurnwald.logic.calculator;

import sarah.thurnwald.data.pokemon.PokemonBaseStats;
import sarah.thurnwald.data.pokemon.PokemonNature;
import sarah.thurnwald.data.pokemon.PokemonStats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sarah.thurnwald.data.pokemon.PokemonBaseStats.*;
import static sarah.thurnwald.data.pokemon.PokemonStats.HP;
import static sarah.thurnwald.data.pokemon.PokemonStats.NONE;

public class StatCalculator {
    public Map<PokemonStats, Integer> calculate(List<PokemonStats> pokemonStats, Map<PokemonStats, Map<PokemonBaseStats, Integer>> statNumbers, int level, PokemonNature nature) {
        HashMap<PokemonStats, Integer> calculatedStats = new HashMap<>();

        pokemonStats.stream().filter(pokemonStat -> !pokemonStat.equals(NONE)).forEach(pokemonStat -> {
            if (pokemonStat.equals(HP)) {
                calculatedStats.put(pokemonStat, ((2 * statNumbers.get(pokemonStat).get(BASE) + statNumbers.get(pokemonStat).get(IV) + statNumbers.get(pokemonStat).get(EV) / 4 + 100) * level) / 100 + 10);
            } else {
                {
                    calculatedStats.put(pokemonStat, (int) ((((2 * statNumbers.get(pokemonStat).get(BASE) + statNumbers.get(pokemonStat).get(IV) + statNumbers.get(pokemonStat).get(EV) / 4) * level) / 100 + 5) * getNatureMultiplier(pokemonStat, nature)));
                }
            }
        });

        return calculatedStats;
    }

    private float getNatureMultiplier(PokemonStats pokemonStat, PokemonNature nature) {
        if (pokemonStat.equals(nature.getIncreaseStat())) return 1.1f;
        if (pokemonStat.equals(nature.getDecreaseStat())) return 0.9f;
        return 1.0f;
    }
}
