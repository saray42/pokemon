package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.data.attack.AttackCategory;
import sarah.thurnwald.data.pokemon.*;
import sarah.thurnwald.logic.calculator.LevelCalculatorManager;
import sarah.thurnwald.logic.calculator.StatCalculator;
import sarah.thurnwald.logic.calculator.levelcalculator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LevelUpTest {

    LevelUpChecker levelUp = new LevelUpChecker();

    Map<ExpType, LevelCalculator> levelCalculators = new HashMap<>(
            Map.of(
                    ExpType.ERRATIC, new CalculateErratic(),
                    ExpType.FAST, new CalculateFast(),
                    ExpType.MEDIUM_FAST, new CalculateMediumFast(),
                    ExpType.MEDIUM_SLOW, new CalculateMediumSlow(),
                    ExpType.SLOW, new CalculateSlow(),
                    ExpType.FLUCTUATING, new CalculateFluctuating()
            )
    );

    List<Attack> gengarAttacks = new ArrayList<>(
            List.of(
                    new Attack("Dark Pulse", 80, PokemonType.DARK, AttackCategory.SPECIAL, 15, 100),
                    new Attack("Shadow Ball", 80, PokemonType.GHOST, AttackCategory.SPECIAL, 15, 100),
                    new Attack("Shadow Punch", 60, PokemonType.GHOST, AttackCategory.PHYSICAL, 20, -1),
                    new Attack("Shadow Claw", 70, PokemonType.GHOST, AttackCategory.PHYSICAL, 15, 100)
            )
    );

    Map<PokemonStats, Map<PokemonBaseStats, Integer>> gengarStatsToCalculate = Map.of(
            PokemonStats.HP, Map.of(
                    PokemonBaseStats.BASE, PokemonData.GENGAR.getHp(),
                    PokemonBaseStats.IV, 0,
                    PokemonBaseStats.EV, 0
            ),
            PokemonStats.ATTACK, Map.of(
                    PokemonBaseStats.BASE, PokemonData.GENGAR.getAttack(),
                    PokemonBaseStats.IV, 0,
                    PokemonBaseStats.EV, 0
            ),
            PokemonStats.DEFENSE, Map.of(
                    PokemonBaseStats.BASE, PokemonData.GENGAR.getDefense(),
                    PokemonBaseStats.IV, 0,
                    PokemonBaseStats.EV, 0
            ),
            PokemonStats.SPECIALATTACK, Map.of(
                    PokemonBaseStats.BASE, PokemonData.GENGAR.getSpecialAttack(),
                    PokemonBaseStats.IV, 0,
                    PokemonBaseStats.EV, 0
            ),
            PokemonStats.SPECIALDEFENSE, Map.of(
                    PokemonBaseStats.BASE, PokemonData.GENGAR.getSpecialDefense(),
                    PokemonBaseStats.IV, 0,
                    PokemonBaseStats.EV, 0
            ),
            PokemonStats.SPEED, Map.of(
                    PokemonBaseStats.BASE, PokemonData.GENGAR.getSpeed(),
                    PokemonBaseStats.IV, 0,
                    PokemonBaseStats.EV, 0
            )
    );

    LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

    StatCalculator statCalculator = new StatCalculator();

    Pokemon pokemonToLevelUp = new Pokemon(
            PokemonData.GENGAR,
            PokemonOwnership.PLAYER_POKEMON,
            70,
            levelCalculatorManager,
            PokemonGender.FEMALE,
            PokemonNature.MILD,
            statCalculator.calculate(List.of(PokemonStats.values()), gengarStatsToCalculate, 70, PokemonNature.MILD),
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            gengarAttacks
    );

    @Test
    void checkIfEligibleForLevelUp() {
        pokemonToLevelUp.setCurrentExp(pokemonToLevelUp.getExpForNextLevel() + 1000);
        levelUp.checkIfEligible(pokemonToLevelUp, levelCalculatorManager, statCalculator);
        assertEquals(71, pokemonToLevelUp.getLevel());
    }
}