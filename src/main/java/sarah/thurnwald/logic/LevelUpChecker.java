package sarah.thurnwald.logic;

import sarah.thurnwald.data.pokemon.Pokemon;
import sarah.thurnwald.data.pokemon.PokemonStats;
import sarah.thurnwald.logic.calculator.LevelCalculatorManager;
import sarah.thurnwald.logic.calculator.StatCalculator;

import java.util.List;

public class LevelUpChecker {

    public void checkIfEligible(Pokemon pokemon, LevelCalculatorManager levelCalculatorManager, StatCalculator statCalculator) {
        if (pokemon.getCurrentExp() >= pokemon.getExpForNextLevel() && pokemon.getLevel() < 100) {
            pokemon.setLevel(pokemon.getLevel() + 1);
            pokemon.setExpForNextLevel(levelCalculatorManager.calculateExpForLevel(pokemon.getExpType(), pokemon.getLevel() + 1));
            pokemon.updateStatsOnLevelUp(statCalculator.calculate(List.of(PokemonStats.values()), pokemon.getStatsToCalculate(), pokemon.getLevel(), pokemon.getNature()));
        }

        if (pokemon.getLevel() <= 100) {
            pokemon.setCurrentExp(levelCalculatorManager.calculateExpForLevel(pokemon.getExpType(), pokemon.getLevel()));
            pokemon.setExpForNextLevel(0);
        }
    }
}
