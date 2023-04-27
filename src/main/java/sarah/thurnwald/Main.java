package sarah.thurnwald;

import sarah.thurnwald.data.*;
import sarah.thurnwald.logic.LevelCalculatorManager;
import sarah.thurnwald.logic.StatCalculator;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
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

        List<PokemonType> gengarTypes = new ArrayList<>(
                List.of(
                        PokemonType.GHOST, PokemonType.POISON
                )
        );

        Map<PokemonStats, Map<PokemonStatNames, Integer>> gengarStatsToCalculate = new HashMap<>(Map.of(
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
        ));

        LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

        StatCalculator statCalculator = new StatCalculator();

        Pokemon gengar1 = new Pokemon(
                "Gengar",
                "Gengar",
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

        Pokemon gengar2 = new Pokemon(
                "Gengar",
                "Gengar",
                PokemonOwnership.PLAYER_POKEMON,
                60,
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

        Player lily = new Player("Lily", new Bag(), new ArrayList<>(List.of(gengar1, gengar2)), 100_000);

        System.out.println(lily);
    }
}