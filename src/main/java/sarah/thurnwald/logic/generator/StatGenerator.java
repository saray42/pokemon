package sarah.thurnwald.logic.generator;

import sarah.thurnwald.data.pokemon.Pokemon;
import sarah.thurnwald.data.pokemon.PokemonBaseStats;
import sarah.thurnwald.data.pokemon.PokemonData;
import sarah.thurnwald.data.pokemon.PokemonStats;

import java.util.Map;

public class StatGenerator {

    public Map<PokemonStats, Map<PokemonBaseStats, Integer>> generate(Pokemon pokemon, PokemonData pokemonData) {
        return Map.of(
                PokemonStats.HP, Map.of(
                        PokemonBaseStats.BASE, pokemonData.getHp(),
                        PokemonBaseStats.IV, pokemon.getHealthStatIv(),
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.ATTACK, Map.of(
                        PokemonBaseStats.BASE, pokemonData.getAttack(),
                        PokemonBaseStats.IV, pokemon.getAttackStatIv(),
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.DEFENSE, Map.of(
                        PokemonBaseStats.BASE, pokemonData.getDefense(),
                        PokemonBaseStats.IV, pokemon.getDefenseStatIv(),
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.SPECIALATTACK, Map.of(
                        PokemonBaseStats.BASE, pokemonData.getSpecialAttack(),
                        PokemonBaseStats.IV, pokemon.getSpecialAttackStatIv(),
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.SPECIALDEFENSE, Map.of(
                        PokemonBaseStats.BASE, pokemonData.getSpecialDefense(),
                        PokemonBaseStats.IV, pokemon.getSpecialDefenseStatIv(),
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.SPEED, Map.of(
                        PokemonBaseStats.BASE, pokemonData.getSpeed(),
                        PokemonBaseStats.IV, pokemon.getSpeedStatIv(),
                        PokemonBaseStats.EV, 0
                )
        );
    }
}
