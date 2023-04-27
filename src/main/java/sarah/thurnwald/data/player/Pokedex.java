package sarah.thurnwald.data.player;

import sarah.thurnwald.data.pokemon.PokemonData;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pokedex {

    Map<PokemonData, Map<PokedexType, Boolean>> pokedexData;

    public Pokedex(Map<PokemonData, Map<PokedexType, Boolean>> pokedexData) {
        this.pokedexData = pokedexData;
    }

    public void setPokemonSeen(PokemonData pokemon) {
        pokedexData.put(pokemon, new LinkedHashMap<>(Map.of(PokedexType.SEEN, true, PokedexType.CAUGHT, false)));
    }

    public void setPokemonCaught(PokemonData pokemon) {
        pokedexData.put(pokemon, new LinkedHashMap<>(Map.of(PokedexType.SEEN, true, PokedexType.CAUGHT, true)));
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "pokedexData=" + pokedexData +
                '}';
    }
}
