package sarah.thurnwald.data.pokemon;

import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.logic.calculator.LevelCalculatorManager;
import sarah.thurnwald.logic.calculator.StatCalculator;
import sarah.thurnwald.logic.generator.IvGenerator;
import sarah.thurnwald.logic.generator.StatGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static sarah.thurnwald.data.pokemon.PokemonStats.*;

public class Pokemon {

    private String name;

    private String customName;

    private PokemonData data;

    private PokemonOwnership ownership;

    private final String id = UUID.randomUUID().toString();

    private int level;

    private final ExpType expType;

    private int currentExp;

    private int expForNextLevel;

    private int basicExp;

    private final PokemonGender gender;

    private final PokemonNature nature;

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

    private List<Attack> attacks = new ArrayList<>(4);

    private List<PokemonType> pokemonTypes = new ArrayList<>(2);

    public Pokemon(PokemonData data, PokemonOwnership ownership, int level, PokemonGender gender, PokemonNature nature, LevelCalculatorManager levelCalculator, StatCalculator statCalculator, StatGenerator statGenerator, IvGenerator ivGenerator, List<Attack> attacks) {
        this.name = data.getName();
        this.customName = data.getName();
        this.data = data;
        this.ownership = ownership;
        this.level = level;
        this.expType = data.getExpType();
        this.currentExp = levelCalculator.calculateExpForLevel(expType, level);
        this.expForNextLevel = levelCalculator.calculateExpForLevel(expType, level + 1);
        this.basicExp = data.getBasicExp();
        this.gender = gender;
        this.nature = nature;
        this.attacks.addAll(attacks);
        this.pokemonTypes.addAll(data.getPokemonTypes());
        this.healthStatEv = 0;
        this.attackStatEv = 0;
        this.defenseStatEv = 0;
        this.specialAttackStatEv = 0;
        this.specialDefenseStatEv = 0;
        this.speedStatEv = 0;
        this.healthStatIv = ivGenerator.generate();
        this.attackStatIv = ivGenerator.generate();
        this.defenseStatIv = ivGenerator.generate();
        this.specialAttackStatIv = ivGenerator.generate();
        this.specialDefenseStatIv = ivGenerator.generate();
        this.speedStatIv = ivGenerator.generate();
        Map<PokemonStats, Map<PokemonBaseStats, Integer>> pokemonBaseStats = statGenerator.generate(this, data);
        Map<PokemonStats, Integer> calculatedStats = statCalculator.calculate(pokemonBaseStats, level, nature);
        this.maxHealthStat = calculatedStats.get(HP);
        this.currentHealthStat = calculatedStats.get(HP);
        this.maxAttackStat = calculatedStats.get(ATTACK);
        this.currentAttackStat = calculatedStats.get(ATTACK);
        this.maxDefenseStat = calculatedStats.get(DEFENSE);
        this.currentDefenseStat = calculatedStats.get(DEFENSE);
        this.maxSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        this.currentSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        this.maxSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        this.currentSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        this.maxSpeedStat = calculatedStats.get(SPEED);
        this.currentSpeedStat = calculatedStats.get(SPEED);
    }

    public void updateStatsOnLevelUp(Map<PokemonStats, Integer> calculatedStats) {
        currentHealthStat += (calculatedStats.get(HP) - maxHealthStat);
        maxHealthStat = calculatedStats.get(HP);
        currentAttackStat = calculatedStats.get(ATTACK);
        maxAttackStat = calculatedStats.get(ATTACK);
        currentDefenseStat = calculatedStats.get(DEFENSE);
        maxDefenseStat = calculatedStats.get(DEFENSE);
        currentSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        maxSpecialAttackStat = calculatedStats.get(SPECIALATTACK);
        currentSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        maxSpecialDefenseStat = calculatedStats.get(SPECIALDEFENSE);
        currentSpeedStat = calculatedStats.get(SPEED);
        maxSpeedStat = calculatedStats.get(SPEED);
    }

    public Map<PokemonStats, Map<PokemonBaseStats, Integer>> getStatsToCalculate() {
        return Map.of(
                PokemonStats.HP, Map.of(
                        PokemonBaseStats.BASE, data.getHp(),
                        PokemonBaseStats.IV, healthStatIv,
                        PokemonBaseStats.EV, healthStatEv
                ),
                PokemonStats.ATTACK, Map.of(
                        PokemonBaseStats.BASE, data.getAttack(),
                        PokemonBaseStats.IV, attackStatIv,
                        PokemonBaseStats.EV, attackStatEv
                ),
                PokemonStats.DEFENSE, Map.of(
                        PokemonBaseStats.BASE, data.getDefense(),
                        PokemonBaseStats.IV, defenseStatIv,
                        PokemonBaseStats.EV, defenseStatEv
                ),
                PokemonStats.SPECIALATTACK, Map.of(
                        PokemonBaseStats.BASE, data.getSpecialAttack(),
                        PokemonBaseStats.IV, specialAttackStatIv,
                        PokemonBaseStats.EV, specialAttackStatEv
                ),
                PokemonStats.SPECIALDEFENSE, Map.of(
                        PokemonBaseStats.BASE, data.getSpecialDefense(),
                        PokemonBaseStats.IV, specialDefenseStatIv,
                        PokemonBaseStats.EV, specialDefenseStatEv
                ),
                PokemonStats.SPEED, Map.of(
                        PokemonBaseStats.BASE, data.getSpeed(),
                        PokemonBaseStats.IV, speedStatIv,
                        PokemonBaseStats.EV, speedStatEv
                )
        );
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

    public PokemonData getData() {
        return data;
    }

    public void setData(PokemonData data) {
        this.data = data;
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

    public PokemonNature getNature() {
        return nature;
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
                ", data=" + data +
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
