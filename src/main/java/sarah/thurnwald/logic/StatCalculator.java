package sarah.thurnwald.logic;

import sarah.thurnwald.data.PokemonNature;
import sarah.thurnwald.data.PokemonStatNames;
import sarah.thurnwald.data.PokemonStats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sarah.thurnwald.data.PokemonStatNames.*;
import static sarah.thurnwald.data.PokemonStats.HP;
import static sarah.thurnwald.data.PokemonStats.NONE;

public class StatCalculator {
    public Map<PokemonStats, Integer> calculate(List<PokemonStats> pokemonStats, Map<PokemonStats, Map<PokemonStatNames, Integer>> statNumbers, int level, PokemonNature nature) {
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
