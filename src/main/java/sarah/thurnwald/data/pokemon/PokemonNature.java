package sarah.thurnwald.data.pokemon;

import static sarah.thurnwald.data.pokemon.PokemonStats.*;

public enum PokemonNature {
    HARDY(NONE, NONE),
    LONELY(ATTACK, DEFENSE),
    BRAVE(ATTACK, SPEED),
    ADAMANT(ATTACK, SPECIALATTACK),
    NAUGHTY(ATTACK, SPECIALDEFENSE),
    BOLD(DEFENSE, ATTACK),
    DOCILE(NONE, NONE),
    RELAXED(DEFENSE, SPEED),
    IMPISH(DEFENSE, SPECIALATTACK),
    LAX(DEFENSE, SPECIALDEFENSE),
    TIMID(SPEED, ATTACK),
    HASTY(SPEED, DEFENSE),
    SERIOUS(NONE, NONE),
    JOLLY(SPEED, SPECIALATTACK),
    NAIVE(SPEED, SPECIALDEFENSE),
    MODEST(SPECIALATTACK, ATTACK),
    MILD(SPECIALATTACK, DEFENSE),
    QUIET(SPECIALATTACK, SPEED),
    BASHFUL(NONE, NONE),
    RASH(SPECIALATTACK, SPECIALDEFENSE),
    CALM(SPECIALDEFENSE, ATTACK),
    GENTLE(SPECIALDEFENSE, DEFENSE),
    SASSY(SPECIALDEFENSE, SPEED),
    CAREFUL(SPECIALDEFENSE, SPECIALATTACK),
    QUIRKY(NONE, NONE);

    private final PokemonStats increaseStat;

    private final PokemonStats decreaseStat;

    PokemonNature(PokemonStats increaseStat, PokemonStats decreaseStat) {
        this.increaseStat = increaseStat;
        this.decreaseStat = decreaseStat;
    }

    public PokemonStats getIncreaseStat() {
        return increaseStat;
    }

    public PokemonStats getDecreaseStat() {
        return decreaseStat;
    }
}
