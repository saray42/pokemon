package sarah.thurnwald;

import sarah.thurnwald.data.Attack;
import sarah.thurnwald.data.ExpType;
import sarah.thurnwald.data.Pokemon;
import sarah.thurnwald.data.PokemonTypes;
import sarah.thurnwald.logic.LevelCalulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LevelCalulator levelCalulator = new LevelCalulator();
        Pokemon gengar = new Pokemon(
                "Gengar",
                "Gengar",
                70,
                ExpType.MEDIUMSLOW,
                levelCalulator.calculateLevel(ExpType.MEDIUMSLOW, 70),
                levelCalulator.calculateLevel(ExpType.MEDIUMSLOW, 71),
                60,
                31,
                252,
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
                new ArrayList<>(List.of(new Attack("Dark Pulse", 80, PokemonTypes.DARK), new Attack("Shadow Ball", 80, PokemonTypes.GHOST))),
                new PokemonTypes[]{PokemonTypes.GHOST, PokemonTypes.POISON});

        System.out.println(gengar);
    }
}