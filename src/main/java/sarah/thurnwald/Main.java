package sarah.thurnwald;

import sarah.thurnwald.data.*;
import sarah.thurnwald.logic.LevelCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        LevelCalculator levelCalculator = new LevelCalculator();
        Pokemon gengar1 = new Pokemon(
                "Gengar",
                "Gengar",
                70,
                ExpType.MEDIUM_SLOW,
                levelCalculator.calculateLevel(ExpType.MEDIUM_SLOW, 70),
                levelCalculator.calculateLevel(ExpType.MEDIUM_SLOW, 71),
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
                60,
                ExpType.MEDIUM_SLOW,
                levelCalculator.calculateLevel(ExpType.MEDIUM_SLOW, 60),
                levelCalculator.calculateLevel(ExpType.MEDIUM_SLOW, 61),
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

        Player lily = new Player("Lily", UUID.randomUUID().toString(), new Bag(), new ArrayList<>(List.of(gengar1)), 100_000);

        lily.addPokemonToParty(gengar2);

        System.out.println(lily);

        lily.removePokemonFromParty(gengar1);

        System.out.println(lily);
    }
}