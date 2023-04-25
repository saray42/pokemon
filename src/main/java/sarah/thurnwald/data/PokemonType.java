package sarah.thurnwald.data;

public enum PokemonType {

    NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DARK, DRAGON, STEEL, FAIRY;

    public PokemonType[] getWeaknesses(PokemonType pokemonType) {
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

    public PokemonType[] getResistances(PokemonType pokemonType) {
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

    public PokemonType[] getImmunities(PokemonType pokemonType) {
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
