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
                ExpType.MEDIUMSLOW,
                levelCalculator.calculateLevel(ExpType.MEDIUMSLOW, 70),
                levelCalculator.calculateLevel(ExpType.MEDIUMSLOW, 71),
                PokemonGender.FEMALE,
                PokemonNature.RASH,
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
                                new Attack("Dark Pulse", 80, PokemonTypes.DARK, AttackCategory.SPECIAL, 15, 100),
                                new Attack("Shadow Ball", 80, PokemonTypes.GHOST, AttackCategory.SPECIAL, 15, 100),
                                new Attack("Shadow Punch", 60, PokemonTypes.GHOST, AttackCategory.PHYSICAL, 20, Integer.MAX_VALUE / 2),
                                new Attack("Shadow Claw", 70, PokemonTypes.GHOST, AttackCategory.PHYSICAL, 15, 100)
                        )
                ),
                new PokemonTypes[]{PokemonTypes.GHOST, PokemonTypes.POISON});

        System.out.println(gengar);
    }
}