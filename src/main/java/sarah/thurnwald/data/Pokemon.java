package sarah.thurnwald.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pokemon {

    private String name;

    private String customName;

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

    public Pokemon(String name, String customName, int level, ExpType expType, int currentExp, int expForNextLevel, int basicExp, PokemonGender gender, PokemonNature nature, int healthStat, int healthStatIv, int healthStatEv, int attackStat, int attackStatIv, int attackStatEv, int defenseStat, int defenseStatIv, int defenseStatEv, int specialAttackStat, int specialAttackStatIv, int specialAttackStatEv, int specialDefenseStat, int specialDefenseStatIv, int specialDefenseStatEv, int speedStat, int speedStatIv, int speedStatEv, List<Attack> attacks, List<PokemonType> pokemonTypes) {
        int healthStatFormula = ((2 * healthStat + healthStatIv + healthStatEv / 4 + 100) * level) / 100 + 10;
        int calculatedAttackStat = calculateStat("Attack", attackStat, attackStatIv, attackStatEv, level, nature);
        int calculatedDefenseStat = calculateStat("Defense", defenseStat, defenseStatIv, defenseStatEv, level, nature);
        int calculatedSpecialAttackStat = calculateStat("SpecialAttack", specialAttackStat, specialAttackStatIv, specialAttackStatEv, level, nature);
        int calculatedSpecialDefenseStat = calculateStat("SpecialDefense", specialDefenseStat, specialAttackStatIv, specialDefenseStatIv, level, nature);
        int calculatedSpeedStat = calculateStat("Speed", speedStat, speedStatIv, speedStatEv, level, nature);

        this.name = name;
        this.customName = customName;
        this.level = level;
        this.expType = expType;
        this.currentExp = currentExp;
        this.expForNextLevel = expForNextLevel;
        this.basicExp = basicExp;
        this.gender = gender;
        this.nature = nature;
        this.maxHealthStat = healthStatFormula;
        this.currentHealthStat = healthStatFormula;
        this.healthStatIv = healthStatIv;
        this.healthStatEv = healthStatEv;
        this.maxAttackStat = calculatedAttackStat;
        this.currentAttackStat = calculatedAttackStat;
        this.attackStatIv = attackStatIv;
        this.attackStatEv = attackStatEv;
        this.maxDefenseStat = calculatedDefenseStat;
        this.currentDefenseStat = calculatedDefenseStat;
        this.defenseStatIv = defenseStatIv;
        this.defenseStatEv = defenseStatEv;
        this.maxSpecialAttackStat = calculatedSpecialAttackStat;
        this.currentSpecialAttackStat = calculatedSpecialAttackStat;
        this.specialAttackStatIv = specialAttackStatIv;
        this.specialAttackStatEv = specialAttackStatEv;
        this.maxSpecialDefenseStat = calculatedSpecialDefenseStat;
        this.currentSpecialDefenseStat = calculatedSpecialDefenseStat;
        this.specialDefenseStatIv = specialDefenseStatIv;
        this.specialDefenseStatEv = specialDefenseStatEv;
        this.maxSpeedStat = calculatedSpeedStat;
        this.currentSpeedStat = calculatedSpeedStat;
        this.speedStatIv = speedStatIv;
        this.speedStatEv = speedStatEv;
        this.attacks.addAll(attacks);
        this.pokemonTypes.addAll(pokemonTypes);
    }

    private int calculateStat(String statName, int statNumber, int iv, int ev, int level, PokemonNature nature) {
        return (int) ((((2 * statNumber + iv + ev / 4) * level) / 100 + 5) * getNatureMultiplier(statName, nature));
    }

    private float getNatureMultiplier(String statName, PokemonNature nature) {
        if (statName.equals(nature.getIncreaseStat())) return 1.1f;
        if (statName.equals(nature.getDecreaseStat())) return 0.9f;
        return 1.0f;
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
