package sarah.thurnwald.logic;

import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.data.pokemon.Pokemon;
import sarah.thurnwald.data.pokemon.PokemonType;

import java.util.List;

import static sarah.thurnwald.data.pokemon.PokemonType.*;

public class DamageCalculator {

    private final float WEAKNESS_MULTIPLIER = 2.f;

    private final float RESISTANCE_MULTIPLIER = 0.5f;

    private final float IMMUNITY_MULTIPLIER = 0.f;

    private final int RANDOM_MAX = 255;

    private final int RANDOM_MIN = 217;

    public int calculate(Pokemon attackerPokemon, Pokemon defenderPokemon, Attack attack) {
        return (int) ((((((((2 * attackerPokemon.getLevel() / 5 + 2)
                * checkAttackCategory("attacker", attackerPokemon, attack) * attack.getAttackDamage())
                / checkAttackCategory("defender", defenderPokemon, attack))
                / 50) + 2) * checkSameTypeAttackBonus(attackerPokemon, attack))
                * checkForTypeModifier(defenderPokemon, attack)) * randomNumberForDamage()) / 255;
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
            if (attack.getAttackType().equals(pokemonType)) {
                return 1.5f;
            }
        }
        return 1.0f;
    }

    private float checkForTypeModifier(Pokemon defender, Attack attack) {
        float firstMultiplier;
        float secondMultiplier;
        List<PokemonType> defenderWeaknessesTypeOne = getWeaknesses(defender.getPokemonTypes().get(0));
        firstMultiplier = calcModifier(defenderWeaknessesTypeOne, attack.getAttackType(), WEAKNESS_MULTIPLIER);
        List<PokemonType> defenderWeaknessesTypeTwo = getWeaknesses(defender.getPokemonTypes().get(1));
        secondMultiplier = calcModifier(defenderWeaknessesTypeTwo, attack.getAttackType(), WEAKNESS_MULTIPLIER);


        List<PokemonType> defenderResistanceTypeOne = getResistances(defender.getPokemonTypes().get(0));
        if (firstMultiplier == 1) {
            firstMultiplier = calcModifier(defenderResistanceTypeOne, attack.getAttackType(), RESISTANCE_MULTIPLIER);
        }
        List<PokemonType> defenderResistanceTypeTwo = getResistances(defender.getPokemonTypes().get(1));
        if (secondMultiplier == 1) {
            secondMultiplier = calcModifier(defenderResistanceTypeTwo, attack.getAttackType(), RESISTANCE_MULTIPLIER);
        }

        List<PokemonType> defenderImmunitiesTypeOne = getImmunities(defender.getPokemonTypes().get(0));
        if (firstMultiplier == 1) {
            firstMultiplier = calcModifier(defenderImmunitiesTypeOne, attack.getAttackType(), IMMUNITY_MULTIPLIER);
        }
        List<PokemonType> defenderImmunitiesTypeTwo = getImmunities(defender.getPokemonTypes().get(1));
        if (secondMultiplier == 1) {
            secondMultiplier = calcModifier(defenderImmunitiesTypeTwo, attack.getAttackType(), IMMUNITY_MULTIPLIER);
        }
        return firstMultiplier * secondMultiplier;
    }

    private float calcModifier(List<PokemonType> modifierTypeList, PokemonType attackType, float multiplier) {
        for (PokemonType pokemonType : modifierTypeList) {
            if (attackType.equals(pokemonType)) return multiplier;
        }
        return 1.f;
    }

    private int randomNumberForDamage() {
        return (int) (Math.random() * (RANDOM_MAX - RANDOM_MIN + 1)) + RANDOM_MIN;
    }

    private List<PokemonType> getWeaknesses(PokemonType pokemonType) {
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

    private List<PokemonType> getResistances(PokemonType pokemonType) {
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

    private List<PokemonType> getImmunities(PokemonType pokemonType) {
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
