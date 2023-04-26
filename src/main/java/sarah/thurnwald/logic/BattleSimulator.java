package sarah.thurnwald.logic;

import sarah.thurnwald.data.Attack;
import sarah.thurnwald.data.Pokemon;
import sarah.thurnwald.data.PokemonType;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import static sarah.thurnwald.data.PokemonType.*;

public class BattleSimulator {


    private final float WEAKNESS_MULTIPLIER = 2.f;

    private final float RESISTANCE_MULTIPLIER = 0.5f;

    private final float IMMUNITY_MULTIPLIER = 0.f;

    private final int RANDOM_MAX = 255;

    private final int RANDOM_MIN = 217;

    public void simulateBattle(LinkedHashMap<String, Pokemon> playerPokemon, LinkedHashMap<String, Pokemon> enemyPokemon, Scanner scanner) {

    }

    public int calculateDamage(Pokemon attackerPokemon, Pokemon defenderPokemon, Attack attack) {
        return (int) ((((((((2 * attackerPokemon.getLevel() / 5 + 2) * checkAttackCategory("attacker", attackerPokemon, attack) * attack.getAttackDamage()) / checkAttackCategory("defender", defenderPokemon, attack)) / 50) + 2) * checkSameTypeAttackBonus(attackerPokemon, attack)) * checkForTypeModifier(defenderPokemon, attack)) * randomNumberForDamage()) / 255;
    }

    private int checkAttackCategory(String pokemonPlace, Pokemon pokemon, Attack attack) {
        return switch (attack.getAttackCategory()) {
            case SPECIAL ->
                    pokemonPlace.equals("attacker") ? pokemon.getCurrentSpecialAttackStat() : pokemon.getCurrentSpecialDefenseStat();
            case PHYSICAL ->
                    pokemonPlace.equals("attacker") ? pokemon.getCurrentAttackStat() : pokemon.getCurrentDefenseStat();
            case STATUS, NONE -> 0;
        };
    }

    private float checkSameTypeAttackBonus(Pokemon attacker, Attack attack) {
        for (PokemonType pokemonType : attacker.getPokemonTypes()) {
            if (attack.getAttackType().equals(pokemonType)) return 1.5f;
        }
        return 1.0f;
    }

    private float checkForTypeModifier(Pokemon defender, Attack attack) {
        float firstMultiplier;
        float secondMultiplier;
        List<PokemonType> defenderWeaknessesTypeOne = List.of(getWeaknesses(defender.getPokemonTypes().get(0)));
        firstMultiplier = calcModifier(defenderWeaknessesTypeOne, attack.getAttackType(), WEAKNESS_MULTIPLIER);
        List<PokemonType> defenderWeaknessesTypeTwo = List.of(getWeaknesses(defender.getPokemonTypes().get(1)));
        secondMultiplier = calcModifier(defenderWeaknessesTypeTwo, attack.getAttackType(), WEAKNESS_MULTIPLIER);


        List<PokemonType> defenderResistanceTypeOne = List.of(getResistances(defender.getPokemonTypes().get(0)));
        if (firstMultiplier == 1)
            firstMultiplier = calcModifier(defenderResistanceTypeOne, attack.getAttackType(), RESISTANCE_MULTIPLIER);
        List<PokemonType> defenderResistanceTypeTwo = List.of(getResistances(defender.getPokemonTypes().get(1)));
        if (secondMultiplier == 1)
            secondMultiplier = calcModifier(defenderResistanceTypeTwo, attack.getAttackType(), RESISTANCE_MULTIPLIER);


        List<PokemonType> defenderImmunitiesTypeOne = List.of(getImmunities(defender.getPokemonTypes().get(0)));
        if (firstMultiplier == 1)
            firstMultiplier = calcModifier(defenderImmunitiesTypeOne, attack.getAttackType(), IMMUNITY_MULTIPLIER);
        List<PokemonType> defenderImmunitiesTypeTwo = List.of(getImmunities(defender.getPokemonTypes().get(1)));
        if (secondMultiplier == 1)
            secondMultiplier = calcModifier(defenderImmunitiesTypeTwo, attack.getAttackType(), IMMUNITY_MULTIPLIER);

        return firstMultiplier * secondMultiplier;
    }

    private float calcModifier(List<PokemonType> modifierType, PokemonType attackType, float multiplier) {
        for (PokemonType pokemonType : modifierType) {
            if (attackType.equals(pokemonType)) return multiplier;
        }
        return 1;
    }

    private int randomNumberForDamage() {
        return (int) (Math.random() * (RANDOM_MAX - RANDOM_MIN + 1)) + RANDOM_MIN;
    }

    private PokemonType[] getWeaknesses(PokemonType pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> new PokemonType[]{FIGHTING};
            case FIRE -> new PokemonType[]{GROUND, ROCK};
            case WATER -> new PokemonType[]{GRASS, ELECTRIC};
            case GRASS -> new PokemonType[]{FLYING, POISON, BUG, FIRE, ICE};
            case ELECTRIC -> new PokemonType[]{GROUND};
            case ICE -> new PokemonType[]{FIGHTING, ROCK, STEEL, FIRE};
            case FIGHTING -> new PokemonType[]{FLYING, PSYCHIC, FAIRY};
            case POISON -> new PokemonType[]{GROUND, PSYCHIC};
            case GROUND -> new PokemonType[]{WATER, GRASS, ICE};
            case FLYING -> new PokemonType[]{ROCK, ELECTRIC, ICE};
            case PSYCHIC -> new PokemonType[]{BUG, GHOST, DARK};
            case BUG -> new PokemonType[]{ROCK, FLYING, FIRE};
            case ROCK -> new PokemonType[]{FIGHTING, GROUND, STEEL, WATER, GRASS};
            case GHOST -> new PokemonType[]{GHOST, DARK};
            case DARK -> new PokemonType[]{FIGHTING, BUG, FAIRY};
            case DRAGON -> new PokemonType[]{ICE, DRAGON, FAIRY};
            case STEEL -> new PokemonType[]{FIGHTING, GROUND, FIRE};
            case FAIRY -> new PokemonType[]{POISON, STEEL};
        };
    }

    private PokemonType[] getResistances(PokemonType pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> new PokemonType[]{};
            case FIRE -> new PokemonType[]{BUG, STEEL, FIRE, GRASS, ICE};
            case WATER -> new PokemonType[]{STEEL, FIRE, WATER, ICE};
            case GRASS -> new PokemonType[]{GROUND, WATER, GRASS, ELECTRIC};
            case ELECTRIC -> new PokemonType[]{FLYING, STEEL, ELECTRIC};
            case ICE -> new PokemonType[]{ICE};
            case FIGHTING -> new PokemonType[]{DARK, ROCK, BUG};
            case POISON -> new PokemonType[]{FIGHTING, POISON, BUG, GRASS, FAIRY};
            case GROUND -> new PokemonType[]{POISON, ROCK};
            case FLYING -> new PokemonType[]{FIGHTING, BUG, GRASS};
            case PSYCHIC -> new PokemonType[]{FIGHTING, PSYCHIC};
            case BUG -> new PokemonType[]{FIGHTING, GROUND, GRASS};
            case ROCK -> new PokemonType[]{NORMAL, FLYING, POISON, FIRE};
            case GHOST -> new PokemonType[]{POISON, BUG};
            case DARK -> new PokemonType[]{GHOST, DARK};
            case DRAGON -> new PokemonType[]{FIRE, WATER, GRASS, ELECTRIC};
            case STEEL -> new PokemonType[]{NORMAL, FLYING, ROCK, BUG, STEEL, GRASS, PSYCHIC, ICE, DRAGON, FAIRY};
            case FAIRY -> new PokemonType[]{FIGHTING, BUG, DARK};
        };
    }

    private PokemonType[] getImmunities(PokemonType pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> new PokemonType[]{GHOST};
            case GROUND -> new PokemonType[]{ELECTRIC};
            case FLYING -> new PokemonType[]{GROUND};
            case GHOST -> new PokemonType[]{NORMAL, FIGHTING};
            case DARK -> new PokemonType[]{PSYCHIC};
            case STEEL -> new PokemonType[]{POISON};
            case FAIRY -> new PokemonType[]{DRAGON};
            case FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, PSYCHIC, BUG, ROCK, DRAGON -> new PokemonType[]{};
        };
    }
}
