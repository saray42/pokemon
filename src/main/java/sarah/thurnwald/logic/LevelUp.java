package sarah.thurnwald.logic;

import sarah.thurnwald.data.Pokemon;
import sarah.thurnwald.data.PokemonStatNames;
import sarah.thurnwald.data.PokemonStats;

import java.util.List;
import java.util.Map;

public class LevelUp {

    public void checkIfEligibleForLevelUp(Pokemon pokemon, LevelCalculatorManager levelCalculatorManager, StatCalculator statCalculator) {
        Map<PokemonStats, Map<PokemonStatNames, Integer>> statsToCalculate = Map.of(
                PokemonStats.HP, Map.of(
                        PokemonStatNames.BASE, pokemon.getRace().getHp(),
                        PokemonStatNames.IV, pokemon.getHealthStatIv(),
                        PokemonStatNames.EV, pokemon.getHealthStatEv()
                ),
                PokemonStats.ATTACK, Map.of(
                        PokemonStatNames.BASE, pokemon.getRace().getAttack(),
                        PokemonStatNames.IV, pokemon.getAttackStatIv(),
                        PokemonStatNames.EV, pokemon.getAttackStatEv()
                ),
                PokemonStats.DEFENSE, Map.of(
                        PokemonStatNames.BASE, pokemon.getRace().getDefense(),
                        PokemonStatNames.IV, pokemon.getDefenseStatIv(),
                        PokemonStatNames.EV, pokemon.getDefenseStatEv()
                ),
                PokemonStats.SPECIALATTACK, Map.of(
                        PokemonStatNames.BASE, pokemon.getRace().getSpecialAttack(),
                        PokemonStatNames.IV, pokemon.getSpecialAttackStatIv(),
                        PokemonStatNames.EV, pokemon.getSpecialAttackStatEv()
                ),
                PokemonStats.SPECIALDEFENSE, Map.of(
                        PokemonStatNames.BASE, pokemon.getRace().getSpecialDefense(),
                        PokemonStatNames.IV, pokemon.getSpecialDefenseStatIv(),
                        PokemonStatNames.EV, pokemon.getSpecialDefenseStatEv()
                ),
                PokemonStats.SPEED, Map.of(
                        PokemonStatNames.BASE, pokemon.getRace().getSpeed(),
                        PokemonStatNames.IV, pokemon.getSpeedStatIv(),
                        PokemonStatNames.EV, pokemon.getSpeedStatEv()
                )
        );

        if (pokemon.getCurrentExp() >= pokemon.getExpForNextLevel() && pokemon.getLevel() < 100) {
            pokemon.setLevel(pokemon.getLevel() + 1);
            pokemon.setExpForNextLevel(levelCalculatorManager.calculateExpForLevel(pokemon.getExpType(), pokemon.getLevel() + 1));
            pokemon.updateStatsOnLevelUp(statCalculator.calculate(List.of(PokemonStats.values()), statsToCalculate, pokemon.getLevel(), pokemon.getNature()));
        }

        if (pokemon.getLevel() == 100) {
            pokemon.setCurrentExp(levelCalculatorManager.calculateExpForLevel(pokemon.getExpType(), pokemon.getLevel()));
            pokemon.setExpForNextLevel(0);
        }
    }
}
