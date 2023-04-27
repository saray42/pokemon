package sarah.thurnwald.data.pokemon;

import java.util.List;

import static sarah.thurnwald.data.pokemon.ExpType.*;
import static sarah.thurnwald.data.pokemon.PokemonType.*;

public enum PokemonData {

    LILY("Lily", 999, 999, 999, 999, 999, 999, 999, ERRATIC, List.of(FAIRY, DRAGON), 9999),
    GASTLY("Gastly", 30, 35, 30, 100, 35, 80, 25, MEDIUM_SLOW, List.of(GHOST, POISON), 62),
    HAUNTER("Haunter", 45, 50, 45, 115, 55, 95, 40, MEDIUM_SLOW, List.of(GHOST, POISON), 142),
    GENGAR("Gengar", 60, 65, 60, 130, 75, 110, 999, MEDIUM_SLOW, List.of(GHOST, POISON), 250);


    private final String name;
    private final int hp;
    private final int attack;
    private final int defense;
    private final int specialAttack;
    private final int specialDefense;
    private final int speed;
    private final int evolveLevel;
    private final ExpType expType;
    private final List<PokemonType> pokemonTypes;
    private final int basicExp;

    PokemonData(String name, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, int evolveLevel, ExpType expType, List<PokemonType> pokemonTypes, int basicExp) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.evolveLevel = evolveLevel;
        this.expType = expType;
        this.pokemonTypes = pokemonTypes;
        this.basicExp = basicExp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEvolveLevel() {
        return evolveLevel;
    }

    public List<PokemonType> getPokemonTypes() {
        return pokemonTypes;
    }

    public String getName() {
        return name;
    }

    public ExpType getExpType() {
        return expType;
    }

    public int getBasicExp() {
        return basicExp;
    }
}
