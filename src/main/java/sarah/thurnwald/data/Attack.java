package sarah.thurnwald.data;

public class Attack {
    private String attackName;

    private int attackDamage;

    private PokemonTypes attackType;

    private AttackCategory attackCategory;

    public Attack(String attackName, int attackDamage, PokemonTypes attackType, AttackCategory attackCategory) {
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
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

    public PokemonTypes getAttackType() {
        return attackType;
    }

    public void setAttackType(PokemonTypes attackType) {
        this.attackType = attackType;
    }

    public AttackCategory getAttackCategory() {
        return attackCategory;
    }

    public void setAttackCategory(AttackCategory attackCategory) {
        this.attackCategory = attackCategory;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "attackName='" + attackName + '\'' +
                ", attackDamage=" + attackDamage +
                ", attackType=" + attackType +
                '}';
    }
}
