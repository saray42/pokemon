package sarah.thurnwald.logic.generator.factor;

import sarah.thurnwald.data.pokemon.PokemonType;

import java.util.List;

import static sarah.thurnwald.data.pokemon.PokemonType.*;

public class PokemonWeakness implements PokemonFactors {

    @Override
    public List<PokemonType> generateFactor(PokemonType pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> List.of(FIGHTING);
            case FIRE -> List.of(GROUND, ROCK);
            case WATER -> List.of(GRASS, ELECTRIC);
            case GRASS -> List.of(FLYING, POISON, BUG, FIRE, ICE);
            case ELECTRIC -> List.of(GROUND);
            case ICE -> List.of(FIGHTING, ROCK, STEEL, FIRE);
            case FIGHTING -> List.of(FLYING, PSYCHIC, FAIRY);
            case POISON -> List.of(GROUND, PSYCHIC);
            case GROUND -> List.of(WATER, GRASS, ICE);
            case FLYING -> List.of(ROCK, ELECTRIC, ICE);
            case PSYCHIC -> List.of(BUG, GHOST, DARK);
            case BUG -> List.of(ROCK, FLYING, FIRE);
            case ROCK -> List.of(FIGHTING, GROUND, STEEL, WATER, GRASS);
            case GHOST -> List.of(GHOST, DARK);
            case DARK -> List.of(FIGHTING, BUG, FAIRY);
            case DRAGON -> List.of(ICE, DRAGON, FAIRY);
            case STEEL -> List.of(FIGHTING, GROUND, FIRE);
            case FAIRY -> List.of(POISON, STEEL);
        };
    }
}
