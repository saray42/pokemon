package sarah.thurnwald.data;

public class Attack {
    private String attackName;

    private int attackDamage;

    private PokemonTypes attackType;

    public Attack(String attackName, int attackDamage, PokemonTypes attackType) {
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        this.attackType = attackType;
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
}
