package sarah.thurnwald.data;

import sarah.thurnwald.logic.LevelCalculatorManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static sarah.thurnwald.data.PokemonStats.*;

public class Pokemon {

    private String name;

    private String customName;

    private PokemonRace race;

    private PokemonOwnership ownership;

    private final String id = UUID.randomUUID().toString();

    private int level;

    private final ExpType expType;

    private int currentExp;

    private int expForNextLevel;

    private int basicExp;

    private PokemonGender gender;

    private PokemonNature nature;

    private int maxHealthStat;

    private int currentHealthStat;

    private int healthStatIv;

    private int healthStatEv;

    private int maxAttackStat;

    private int currentAttackStat;

    private int attackStatIv;

    private int attackStatEv;

    private int maxDefenseStat;

    private int currentDefenseStat;

    private int defenseStatIv;

    private int defenseStatEv;

    private int maxSpecialAttackStat;

    private int currentSpecialAttackStat;

    private int specialAttackStatIv;

    private int specialAttackStatEv;

    private int maxSpecialDefenseStat;

    private int currentSpecialDefenseStat;

    private int specialDefenseStatIv;

    private int specialDefenseStatEv;

    private int maxSpeedStat;

    private int currentSpeedStat;

    private int speedStatIv;

    private int speedStatEv;

    private List<Attack> attacks = new ArrayList<Attack>(4);

    private List<PokemonType> pokemonTypes = new ArrayList<PokemonType>(2);

    public Pokemon(String name, String customName, PokemonRace race, PokemonOwnership ownership, int level, ExpType expType, LevelCalculatorManager levelCalculator, int basicExp, PokemonGender gender, PokemonNature nature, Map<PokemonStats, Integer> calculatedStats, int healthStatIv, int healthStatEv, int attackStatIv, int attackStatEv, int defenseStatIv, int defenseStatEv, int specialAttackStatIv, int specialAttackStatEv, int specialDefenseStatIv, int specialDefenseStatEv, int speedStatIv, int speedStatEv, List<Attack> attacks, List<PokemonType> pokemonTypes) {
        this.name = name;
        this.customName = customName;
        this.race = race;
        this.ownership = ownership;
        this.level = level;
        this.expType = expType;
        this.currentExp = levelCalculator.calculateExpForLevel(expType, level);
        this.expForNextLevel = levelCalculator.calculateExpForLevel(expType, level + 1);
        this.basicExp = basicExp;
        this.gender = gender;
        this.nature = nature;
        this.maxHealthStat = calculatedStats.get(HP);
        this.currentHealthStat = calculatedStats.get(HP);
        this.healthStatIv = healthStatIv;
        this.healthStatEv = healthStatEv;
        this.maxAttackStat = calculatedStats.get(ATTACK);
        this.currentAttackStat = calculatedStats.get(ATTACK);
        this.attackStatIv = attackStatIv;
        this.attackStatEv = attackStatEv;
        this.maxDefenseStat = calculatedStats.get(DEFENSE);
        this.currentDefenseStat = calculatedStats.get(DEFENSE);
        this.defenseStatIv = defenseStatIv;
        this.defenseStatEv = defenseStatEv;
        this.maxSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        this.currentSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        this.specialAttackStatIv = specialAttackStatIv;
        this.specialAttackStatEv = specialAttackStatEv;
        this.maxSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        this.currentSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        this.specialDefenseStatIv = specialDefenseStatIv;
        this.specialDefenseStatEv = specialDefenseStatEv;
        this.maxSpeedStat = calculatedStats.get(SPEED);
        this.currentSpeedStat = calculatedStats.get(SPEED);
        this.speedStatIv = speedStatIv;
        this.speedStatEv = speedStatEv;
        this.attacks.addAll(attacks);
        this.pokemonTypes.addAll(pokemonTypes);
    }

    public void updateStatsOnLevelUp(Map<PokemonStats, Integer> calculatedStats) {
        maxHealthStat = calculatedStats.get(HP);
        currentHealthStat = currentHealthStat + calculatedStats.get(HP) - maxHealthStat;
        maxAttackStat = calculatedStats.get(ATTACK);
        currentAttackStat = calculatedStats.get(ATTACK);
        maxDefenseStat = calculatedStats.get(DEFENSE);
        currentDefenseStat = calculatedStats.get(DEFENSE);
        maxSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        currentSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        maxSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        currentSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        maxSpeedStat = calculatedStats.get(SPEED);
        currentSpeedStat = calculatedStats.get(SPEED);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public PokemonRace getRace() {
        return race;
    }

    public void setRace(PokemonRace race) {
        this.race = race;
    }

    public PokemonOwnership getOwnership() {
        return ownership;
    }

    public void setOwnership(PokemonOwnership ownership) {
        this.ownership = ownership;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ExpType getExpType() {
        return expType;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getExpForNextLevel() {
        return expForNextLevel;
    }

    public void setExpForNextLevel(int expForNextLevel) {
        this.expForNextLevel = expForNextLevel;
    }

    public int getBasicExp() {
        return basicExp;
    }

    public void setBasicExp(int basicExp) {
        this.basicExp = basicExp;
    }

    public PokemonGender getGender() {
        return gender;
    }

    public void setGender(PokemonGender gender) {
        this.gender = gender;
    }

    public PokemonNature getNature() {
        return nature;
    }

    public void setNature(PokemonNature nature) {
        this.nature = nature;
    }

    public int getMaxHealthStat() {
        return maxHealthStat;
    }

    public void setMaxHealthStat(int maxHealthStat) {
        this.maxHealthStat = maxHealthStat;
    }

    public int getCurrentHealthStat() {
        return currentHealthStat;
    }

    public void setCurrentHealthStat(int currentHealthStat) {
        this.currentHealthStat = currentHealthStat;
    }

    public int getHealthStatIv() {
        return healthStatIv;
    }

    public void setHealthStatIv(int healthStatIv) {
        this.healthStatIv = healthStatIv;
    }

    public int getHealthStatEv() {
        return healthStatEv;
    }

    public void setHealthStatEv(int healthStatEv) {
        this.healthStatEv = healthStatEv;
    }

    public int getMaxAttackStat() {
        return maxAttackStat;
    }

    public void setMaxAttackStat(int maxAttackStat) {
        this.maxAttackStat = maxAttackStat;
    }

    public int getCurrentAttackStat() {
        return currentAttackStat;
    }

    public void setCurrentAttackStat(int currentAttackStat) {
        this.currentAttackStat = currentAttackStat;
    }

    public int getAttackStatIv() {
        return attackStatIv;
    }

    public void setAttackStatIv(int attackStatIv) {
        this.attackStatIv = attackStatIv;
    }

    public int getAttackStatEv() {
        return attackStatEv;
    }

    public void setAttackStatEv(int attackStatEv) {
        this.attackStatEv = attackStatEv;
    }

    public int getMaxDefenseStat() {
        return maxDefenseStat;
    }

    public void setMaxDefenseStat(int maxDefenseStat) {
        this.maxDefenseStat = maxDefenseStat;
    }

    public int getCurrentDefenseStat() {
        return currentDefenseStat;
    }

    public void setCurrentDefenseStat(int currentDefenseStat) {
        this.currentDefenseStat = currentDefenseStat;
    }

    public int getDefenseStatIv() {
        return defenseStatIv;
    }

    public void setDefenseStatIv(int defenseStatIv) {
        this.defenseStatIv = defenseStatIv;
    }

    public int getDefenseStatEv() {
        return defenseStatEv;
    }

    public void setDefenseStatEv(int defenseStatEv) {
        this.defenseStatEv = defenseStatEv;
    }

    public int getMaxSpecialAttackStat() {
        return maxSpecialAttackStat;
    }

    public void setMaxSpecialAttackStat(int maxSpecialAttackStat) {
        this.maxSpecialAttackStat = maxSpecialAttackStat;
    }

    public int getCurrentSpecialAttackStat() {
        return currentSpecialAttackStat;
    }

    public void setCurrentSpecialAttackStat(int currentSpecialAttackStat) {
        this.currentSpecialAttackStat = currentSpecialAttackStat;
    }

    public int getSpecialAttackStatIv() {
        return specialAttackStatIv;
    }

    public void setSpecialAttackStatIv(int specialAttackStatIv) {
        this.specialAttackStatIv = specialAttackStatIv;
    }

    public int getSpecialAttackStatEv() {
        return specialAttackStatEv;
    }

    public void setSpecialAttackStatEv(int specialAttackStatEv) {
        this.specialAttackStatEv = specialAttackStatEv;
    }

    public int getMaxSpecialDefenseStat() {
        return maxSpecialDefenseStat;
    }

    public void setMaxSpecialDefenseStat(int maxSpecialDefenseStat) {
        this.maxSpecialDefenseStat = maxSpecialDefenseStat;
    }

    public int getCurrentSpecialDefenseStat() {
        return currentSpecialDefenseStat;
    }

    public void setCurrentSpecialDefenseStat(int currentSpecialDefenseStat) {
        this.currentSpecialDefenseStat = currentSpecialDefenseStat;
    }

    public int getSpecialDefenseStatIv() {
        return specialDefenseStatIv;
    }

    public void setSpecialDefenseStatIv(int specialDefenseStatIv) {
        this.specialDefenseStatIv = specialDefenseStatIv;
    }

    public int getSpecialDefenseStatEv() {
        return specialDefenseStatEv;
    }

    public void setSpecialDefenseStatEv(int specialDefenseStatEv) {
        this.specialDefenseStatEv = specialDefenseStatEv;
    }

    public int getMaxSpeedStat() {
        return maxSpeedStat;
    }

    public void setMaxSpeedStat(int maxSpeedStat) {
        this.maxSpeedStat = maxSpeedStat;
    }

    public int getCurrentSpeedStat() {
        return currentSpeedStat;
    }

    public void setCurrentSpeedStat(int currentSpeedStat) {
        this.currentSpeedStat = currentSpeedStat;
    }

    public int getSpeedStatIv() {
        return speedStatIv;
    }

    public void setSpeedStatIv(int speedStatIv) {
        this.speedStatIv = speedStatIv;
    }

    public int getSpeedStatEv() {
        return speedStatEv;
    }

    public void setSpeedStatEv(int speedStatEv) {
        this.speedStatEv = speedStatEv;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<PokemonType> getPokemonTypes() {
        return pokemonTypes;
    }

    public void setPokemonTypes(List<PokemonType> pokemonTypes) {
        this.pokemonTypes = pokemonTypes;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", customName='" + customName + '\'' +
                ", race=" + race +
                ", ownership=" + ownership +
                ", id='" + id + '\'' +
                ", level=" + level +
                ", expType=" + expType +
                ", currentExp=" + currentExp +
                ", expForNextLevel=" + expForNextLevel +
                ", basicExp=" + basicExp +
                ", gender=" + gender +
                ", nature=" + nature +
                ", maxHealthStat=" + maxHealthStat +
                ", currentHealthStat=" + currentHealthStat +
                ", healthStatIv=" + healthStatIv +
                ", healthStatEv=" + healthStatEv +
                ", maxAttackStat=" + maxAttackStat +
                ", currentAttackStat=" + currentAttackStat +
                ", attackStatIv=" + attackStatIv +
                ", attackStatEv=" + attackStatEv +
                ", maxDefenseStat=" + maxDefenseStat +
                ", currentDefenseStat=" + currentDefenseStat +
                ", defenseStatIv=" + defenseStatIv +
                ", defenseStatEv=" + defenseStatEv +
                ", maxSpecialAttackStat=" + maxSpecialAttackStat +
                ", currentSpecialAttackStat=" + currentSpecialAttackStat +
                ", specialAttackStatIv=" + specialAttackStatIv +
                ", specialAttackStatEv=" + specialAttackStatEv +
                ", maxSpecialDefenseStat=" + maxSpecialDefenseStat +
                ", currentSpecialDefenseStat=" + currentSpecialDefenseStat +
                ", specialDefenseStatIv=" + specialDefenseStatIv +
                ", specialDefenseStatEv=" + specialDefenseStatEv +
                ", maxSpeedStat=" + maxSpeedStat +
                ", currentSpeedStat=" + currentSpeedStat +
                ", speedStatIv=" + speedStatIv +
                ", speedStatEv=" + speedStatEv +
                ", attacks=" + attacks +
                ", pokemonTypes=" + pokemonTypes +
                '}';
    }
}
