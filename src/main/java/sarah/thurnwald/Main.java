package sarah.thurnwald;

import sarah.thurnwald.data.*;
import sarah.thurnwald.logic.LevelCalculatorManager;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.*;

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

        LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);
        Scanner scanner = new Scanner(System.in);

        Pokemon gengar1 = new Pokemon(
                "Gengar",
                "Gengar",
                PokemonOwnership.PLAYER_POKEMON,
                70,
                ExpType.MEDIUM_SLOW,
                levelCalculatorManager.calculateLevel(ExpType.MEDIUM_SLOW, 70),
                levelCalculatorManager.calculateLevel(ExpType.MEDIUM_SLOW, 71),
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
                new ArrayList<>(
                        List.of(
                                new Attack("Dark Pulse", 80, PokemonType.DARK, AttackCategory.SPECIAL, 15, 100),
                                new Attack("Shadow Ball", 80, PokemonType.GHOST, AttackCategory.SPECIAL, 15, 100),
                                new Attack("Shadow Punch", 60, PokemonType.GHOST, AttackCategory.PHYSICAL, 20, Integer.MAX_VALUE / 2),
                                new Attack("Shadow Claw", 70, PokemonType.GHOST, AttackCategory.PHYSICAL, 15, 100)
                        )
                ),
                new ArrayList<>(
                        List.of(
                                PokemonType.GHOST, PokemonType.POISON
                        )
                )
        );

        Pokemon gengar2 = new Pokemon(
                "Gengar",
                "Gengar",
                PokemonOwnership.PLAYER_POKEMON,
                60,
                ExpType.MEDIUM_SLOW,
                levelCalculatorManager.calculateLevel(ExpType.MEDIUM_SLOW, 60),
                levelCalculatorManager.calculateLevel(ExpType.MEDIUM_SLOW, 61),
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
                new ArrayList<>(
                        List.of(
                                new Attack("Dark Pulse", 80, PokemonType.DARK, AttackCategory.SPECIAL, 15, 100),
                                new Attack("Shadow Ball", 80, PokemonType.GHOST, AttackCategory.SPECIAL, 15, 100),
                                new Attack("Shadow Punch", 60, PokemonType.GHOST, AttackCategory.PHYSICAL, 20, Integer.MAX_VALUE / 2),
                                new Attack("Shadow Claw", 70, PokemonType.GHOST, AttackCategory.PHYSICAL, 15, 100)
                        )
                ),
                new ArrayList<>(
                        List.of(
                                PokemonType.GHOST, PokemonType.POISON
                        )
                )
        );

        Player lily = new Player("Lily", UUID.randomUUID().toString(), new Bag(), new ArrayList<>(List.of(gengar1, gengar2)), 100_000);

        lily.removePokemonFromParty(gengar2);

        System.out.println(lily.getParty());
    }
}