package sarah.thurnwald.logic.generator.factor;

import sarah.thurnwald.data.pokemon.PokemonType;

import java.util.List;

import static sarah.thurnwald.data.pokemon.PokemonType.*;

public class PokemonImmunity implements PokemonFactors {
    @Override
    public List<PokemonType> generateFactor(PokemonType pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> List.of(GHOST);
            case GROUND -> List.of(ELECTRIC);
            case FLYING -> List.of(GROUND);
            case GHOST -> List.of(NORMAL, FIGHTING);
            case DARK -> List.of(PSYCHIC);
            case STEEL -> List.of(POISON);
            case FAIRY -> List.of(DRAGON);
            case FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, PSYCHIC, BUG, ROCK, DRAGON -> List.of();
        };
    }
}
