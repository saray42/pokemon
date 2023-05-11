package sarah.thurnwald.logic.generator.factor;

import sarah.thurnwald.data.pokemon.PokemonType;

import java.util.List;

public interface PokemonFactors {
    List<PokemonType> generateFactor(PokemonType pokemonType);
}
