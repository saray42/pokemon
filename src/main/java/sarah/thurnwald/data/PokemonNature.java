package sarah.thurnwald.data;

import java.util.List;

public enum PokemonNature {
    HARDY("", ""),
    LONELY("Attack", "Defense"),
    BRAVE("Attack", "Speed"),
    ADAMANT("Attack", "SpecialAttack"),
    NAUGHTY("Attack", "SpecialDefense"),
    BOLD("Defense", "Attack"),
    DOCILE("", ""),
    RELAXED("Defense", "Speed"),
    IMPISH("Defense", "SpecialAttack"),
    LAX("Defense", "SpecialDefense"),
    TIMID("Speed", "Attack"),
    HASTY("Speed", "Defense"),
    SERIOUS("", ""),
    JOLLY("Speed", "SpecialAttack"),
    NAIVE("Speed", "SpecialDefense"),
    MODEST("SpecialAttack", "Attack"),
    MILD("SpecialAttack", "Defense"),
    QUIET("SpecialAttack", "Speed"),
    BASHFUL("", ""),
    RASH("SpecialAttack", "SpecialDefense"),
    CALM("SpecialDefense", "Attack"),
    GENTLE("SpecialDefense", "Defense"),
    SASSY("SpecialDefense", "Speed"),
    CAREFUL("SpecialDefense", "SpecialAttack"),
    QUIRKY("", "");

    private final String increaseStat;

    private final String decreaseStat;

    PokemonNature(String increaseStat, String decreaseStat) {
        this.increaseStat = increaseStat;
        this.decreaseStat = decreaseStat;
    }

    public String getIncreaseStat() {
        return increaseStat;
    }

    public String getDecreaseStat() {
        return decreaseStat;
    }
}
