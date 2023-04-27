package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.data.attack.AttackCategory;
import sarah.thurnwald.data.pokemon.*;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpCalculatorTest {

    ExpCalculator expCalculator = new ExpCalculator();

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

    Map<PokemonStats, Map<PokemonStatNames, Integer>> gengarStatsToCalculate = Map.of(
            PokemonStats.HP, Map.of(
                    PokemonStatNames.BASE, PokemonData.GENGAR.getHp(),
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.ATTACK, Map.of(
                    PokemonStatNames.BASE, PokemonData.GENGAR.getAttack(),
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.DEFENSE, Map.of(
                    PokemonStatNames.BASE, PokemonData.GENGAR.getDefense(),
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.SPECIALATTACK, Map.of(
                    PokemonStatNames.BASE, PokemonData.GENGAR.getSpecialAttack(),
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.SPECIALDEFENSE, Map.of(
                    PokemonStatNames.BASE, PokemonData.GENGAR.getSpecialDefense(),
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            ),
            PokemonStats.SPEED, Map.of(
                    PokemonStatNames.BASE, PokemonData.GENGAR.getSpeed(),
                    PokemonStatNames.IV, 0,
                    PokemonStatNames.EV, 0
            )
    );

    LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

    StatCalculator statCalculator = new StatCalculator();

    Pokemon playerPokemon = new Pokemon(
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

    Pokemon defeatedPokemon = new Pokemon(
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
    void calculateExp() {
        assertEquals(3501, expCalculator.calculateExp(playerPokemon, defeatedPokemon));
    }
}