package sarah.thurnwald;

import sarah.thurnwald.data.*;
import sarah.thurnwald.logic.LevelCalculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LevelCalculator levelCalculator = new LevelCalculator();
        Pokemon gengar = new Pokemon(
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

        System.out.println(gengar);
    }
}