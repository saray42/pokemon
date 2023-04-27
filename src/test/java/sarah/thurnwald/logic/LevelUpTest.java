package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.*;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LevelUpTest {

    LevelUp levelUp = new LevelUp();

    HashMap<ExpType, LevelCalculator> levelCalculators = new HashMap<>(
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
                    new Attack("Shadow Punch", 60, PokemonType.GHOST, AttackCategory.PHYSICAL, 20, Integer.MAX_VALUE / 2),
                    new Attack("Shadow Claw", 70, PokemonType.GHOST, AttackCategory.PHYSICAL, 15, 100)
            )
    );

    List<PokemonType> gengarTypes = new ArrayList<>(
            List.of(
                    PokemonType.GHOST, PokemonType.POISON
            )
    );

    List<PokemonType> immunityTest = new ArrayList<>(
            List.of(
                    PokemonType.NORMAL, PokemonType.POISON
            )
    );

    Map<PokemonStats, Map<PokemonStatNames, Integer>> gengarStatsToCalculate = Map.of(
            PokemonStats.HP, Map.of(
                    PokemonStatNames.BASE, 60,
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.ATTACK, Map.of(
                    PokemonStatNames.BASE, 65,
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.DEFENSE, Map.of(
                    PokemonStatNames.BASE, 60,
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.SPECIALATTACK, Map.of(
                    PokemonStatNames.BASE, 130,
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.SPECIALDEFENSE, Map.of(
                    PokemonStatNames.BASE, 75,
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.SPEED, Map.of(
                    PokemonStatNames.BASE, 110,
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            )
    );
    LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

    StatCalculator statCalculator = new StatCalculator();

    Pokemon pokemonToLevelUp = new Pokemon(
            "Gengar",
            "Gengar",
            PokemonRace.GENGAR,
            PokemonOwnership.PLAYER_POKEMON,
            70,
            ExpType.MEDIUM_SLOW,
            levelCalculatorManager,
            250,
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
            gengarAttacks,
            gengarTypes
    );

    @Test
    void checkIfEligibleForLevelUp() {
        pokemonToLevelUp.setCurrentExp(pokemonToLevelUp.getExpForNextLevel());
        System.out.println(pokemonToLevelUp);
        levelUp.checkIfEligibleForLevelUp(pokemonToLevelUp, levelCalculatorManager, statCalculator);
        System.out.println(pokemonToLevelUp);
        assertEquals(71, pokemonToLevelUp.getLevel());
    }
}