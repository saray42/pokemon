package sarah.thurnwald.logic.generator;

import sarah.thurnwald.data.player.PokedexType;
import sarah.thurnwald.data.pokemon.PokemonData;

import java.util.LinkedHashMap;
import java.util.Map;

public class PokedexGenerator {
    public Map<PokemonData, Map<PokedexType, Boolean>> generate() {
        LinkedHashMap<PokemonData, Map<PokedexType, Boolean>> pokedexData = new LinkedHashMap<>();

        PokemonData[] pokemonDataArray = PokemonData.values();
        for (PokemonData pokemonData : pokemonDataArray) {
            pokedexData.put(pokemonData, new LinkedHashMap<>(Map.of(PokedexType.CAUGHT, false, PokedexType.SEEN, false)));
        }

        return pokedexData;
    }
}
