package sarah.thurnwald.logic;

import sarah.thurnwald.data.Attack;
import sarah.thurnwald.data.AttackCategory;
import sarah.thurnwald.data.Pokemon;
import sarah.thurnwald.data.PokemonType;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import static sarah.thurnwald.data.PokemonType.*;

public class BattleSimulator {


    private final float WEAKNESS_MULTIPLIER = 2.f;

    private final float RESISTANCE_MULTIPLIER = 0.5f;

    private final float IMMUNITY_MULTIPLIER = 0.f;

    private final int RANDOM_MAX = 255;

    private final int RANDOM_MIN = 217;

    public void simulateBattle(LinkedHashMap<String, Pokemon> playerPokemon, LinkedHashMap<String, Pokemon> enemyPokemon, Scanner scanner) {

    }

    private int calculateDamage(Pokemon attackerPokemon, Pokemon defenderPokemon, Attack attack) {
        return (int) ((2 * attackerPokemon.getLevel() / 5 + 2) * checkAttackCategoryForAttacker(attackerPokemon, attack) * attack.getAttackDamage()) / checkAttackCategoryForDefender(defenderPokemon, attack) / 50)
        +2) *checkSameTypeAttackBonus(attackerPokemon, attack) * Y / 10) *randomNumberForDamage()) /255;
    }

    private int checkAttackCategoryForAttacker(Pokemon attacker, Attack attack) {
        return switch (attack.getAttackCategory()) {
            case SPECIAL -> attacker.getCurrentSpecialAttackStat();
            case PHYSICAL -> attacker.getCurrentAttackStat();
            case STATUS, NONE -> 0;
        };
    }

    private int checkAttackCategoryForDefender(Pokemon defender, Attack attack) {
        return switch (attack.getAttackCategory()) {
            case SPECIAL -> defender.getCurrentSpecialDefenseStat();
            case PHYSICAL -> defender.getCurrentDefenseStat();
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
        List<PokemonType> defenderWeaknessesTypeOne = List.of(getWeaknesses(defender.getPokemonTypes().get(0)));
        Optional<List<PokemonType>> defenderWeaknessesTypeTwo = Optional.of(List.of(getWeaknesses(defender.getPokemonTypes().get(1))));

        List<PokemonType> defenderResistanceTypeOne = List.of(getResistances(defender.getPokemonTypes().get(0)));
        Optional<List<PokemonType>> defenderResistanceTypeTwo = Optional.of(List.of(getResistances(defender.getPokemonTypes().get(1))));

        List<PokemonType> defenderImmunitiesTypeOne = List.of(getImmunities(defender.getPokemonTypes().get(0)));
        Optional<List<PokemonType>> defenderImmunitiesTypeTwo = Optional.of(List.of(getImmunities(defender.getPokemonTypes().get(1))));

        return 0.f;
    }

    private Optional<Float> calcModifier(List<PokemonType> modifierType, Attack attack) {
        /* for (PokemonType pokemonType : modifierType) {
            if (attack.getAttackType().equals(pokemonType)) return;
        } */
        return Optional.of(0.f);
    }

    private int randomNumberForDamage() {
        return (int) Math.floor(Math.random() * (RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MAX);
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
