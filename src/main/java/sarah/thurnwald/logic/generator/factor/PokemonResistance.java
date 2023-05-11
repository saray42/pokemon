package sarah.thurnwald.logic.generator.factor;

import sarah.thurnwald.data.pokemon.PokemonType;

import java.util.List;

import static sarah.thurnwald.data.pokemon.PokemonType.*;

public class PokemonResistance implements PokemonFactors {
    @Override
    public List<PokemonType> generateFactor(PokemonType pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> List.of();
            case FIRE -> List.of(BUG, STEEL, FIRE, GRASS, ICE);
            case WATER -> List.of(STEEL, FIRE, WATER, ICE);
            case GRASS -> List.of(GROUND, WATER, GRASS, ELECTRIC);
            case ELECTRIC -> List.of(FLYING, STEEL, ELECTRIC);
            case ICE -> List.of(ICE);
            case FIGHTING -> List.of(DARK, ROCK, BUG);
            case POISON -> List.of(FIGHTING, POISON, BUG, GRASS, FAIRY);
            case GROUND -> List.of(POISON, ROCK);
            case FLYING -> List.of(FIGHTING, BUG, GRASS);
            case PSYCHIC -> List.of(FIGHTING, PSYCHIC);
            case BUG -> List.of(FIGHTING, GROUND, GRASS);
            case ROCK -> List.of(NORMAL, FLYING, POISON, FIRE);
            case GHOST -> List.of(POISON, BUG);
            case DARK -> List.of(GHOST, DARK);
            case DRAGON -> List.of(FIRE, WATER, GRASS, ELECTRIC);
            case STEEL -> List.of(NORMAL, FLYING, ROCK, BUG, STEEL, GRASS, PSYCHIC, ICE, DRAGON, FAIRY);
            case FAIRY -> List.of(FIGHTING, BUG, DARK);
        };
    }
}
