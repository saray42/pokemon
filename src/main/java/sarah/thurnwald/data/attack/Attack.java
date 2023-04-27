package sarah.thurnwald.data.attack;

import sarah.thurnwald.data.pokemon.PokemonType;

public class Attack {
    private String attackName;

    private int attackDamage;

    private PokemonType attackType;

    private AttackCategory attackCategory;

    private int maxUsages;

    private int currentUsages;

    private int accuracy;

    public Attack(String attackName, int attackDamage, PokemonType attackType, AttackCategory attackCategory, int usages, int accuracy) {
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.maxUsages = usages;
        this.currentUsages = usages;
        this.accuracy = accuracy;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public PokemonType getAttackType() {
        return attackType;
    }

    public void setAttackType(PokemonType attackType) {
        this.attackType = attackType;
    }

    public AttackCategory getAttackCategory() {
        return attackCategory;
    }

    public void setAttackCategory(AttackCategory attackCategory) {
        this.attackCategory = attackCategory;
    }

    public int getMaxUsages() {
        return maxUsages;
    }

    public void setMaxUsages(int maxUsages) {
        this.maxUsages = maxUsages;
    }

    public int getCurrentUsages() {
        return currentUsages;
    }

    public void setCurrentUsages(int currentUsages) {
        this.currentUsages = currentUsages;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "attackName='" + attackName + '\'' +
                ", attackDamage=" + attackDamage +
                ", attackType=" + attackType +
                ", attackCategory=" + attackCategory +
                ", maxUsages=" + maxUsages +
                ", currentUsages=" + currentUsages +
                ", accuracy=" + accuracy +
                '}';
    }
}
