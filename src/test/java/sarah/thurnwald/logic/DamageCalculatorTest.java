package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.*;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DamageCalculatorTest {

    DamageCalculator damageCalculator = new DamageCalculator();

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
    LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

    Pokemon attacker = new Pokemon(
            "Gengar",
            "Gengar",
            PokemonOwnership.PLAYER_POKEMON,
            70,
            ExpType.MEDIUM_SLOW,
            levelCalculatorManager,
            250,
            PokemonGender.FEMALE,
            PokemonNature.MILD,
            60,
            0,
            0,
            65,
            0,
            0,
            60,
            0,
            0,
            130,
            0,
            0,
            75,
            0,
            0,
            110,
            0,
            0,
            gengarAttacks,
            gengarTypes
    );

    Pokemon defender = new Pokemon(
            "Gengar",
            "Gengar",
            PokemonOwnership.PLAYER_POKEMON,
            70,
            ExpType.MEDIUM_SLOW,
            levelCalculatorManager,
            250,
            PokemonGender.FEMALE,
            PokemonNature.MILD,
            60,
            0,
            0,
            65,
            0,
            0,
            60,
            0,
            0,
            130,
            0,
            0,
            75,
            0,
            0,
            110,
            0,
            0,
            gengarAttacks,
            immunityTest
    );
    @Test
    void calculateDamage() {
        assertEquals(0, damageCalculator.calculate(attacker, defender, attacker.getAttacks().get(1)));
    }
}