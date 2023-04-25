package sarah.thurnwald.data;

public enum PokemonTypes {

    NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DARK, DRAGON, STEEL, FAIRY;

    public PokemonTypes[] getWeaknesses(PokemonTypes pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> new PokemonTypes[]{FIGHTING};
            case FIRE -> new PokemonTypes[]{GROUND, ROCK};
            case WATER -> new PokemonTypes[]{GRASS, ELECTRIC};
            case GRASS -> new PokemonTypes[]{FLYING, POISON, BUG, FIRE, ICE};
            case ELECTRIC -> new PokemonTypes[]{GROUND};
            case ICE -> new PokemonTypes[]{FIGHTING, ROCK, STEEL, FIRE};
            case FIGHTING -> new PokemonTypes[]{FLYING, PSYCHIC, FAIRY};
            case POISON -> new PokemonTypes[]{GROUND, PSYCHIC};
            case GROUND -> new PokemonTypes[]{WATER, GRASS, ICE};
            case FLYING -> new PokemonTypes[]{ROCK, ELECTRIC, ICE};
            case PSYCHIC -> new PokemonTypes[]{BUG, GHOST, DARK};
            case BUG -> new PokemonTypes[]{ROCK, FLYING, FIRE};
            case ROCK -> new PokemonTypes[]{FIGHTING, GROUND, STEEL, WATER, GRASS};
            case GHOST -> new PokemonTypes[]{GHOST, DARK};
            case DARK -> new PokemonTypes[]{FIGHTING, BUG, FAIRY};
            case DRAGON -> new PokemonTypes[]{ICE, DRAGON, FAIRY};
            case STEEL -> new PokemonTypes[]{FIGHTING, GROUND, FIRE};
            case FAIRY -> new PokemonTypes[]{POISON, STEEL};
        };
    }

    public PokemonTypes[] getResistances(PokemonTypes pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> new PokemonTypes[]{};
            case FIRE -> new PokemonTypes[]{BUG, STEEL, FIRE, GRASS, ICE};
            case WATER -> new PokemonTypes[]{STEEL, FIRE, WATER, ICE};
            case GRASS -> new PokemonTypes[]{GROUND, WATER, GRASS, ELECTRIC};
            case ELECTRIC -> new PokemonTypes[]{FLYING, STEEL, ELECTRIC};
            case ICE -> new PokemonTypes[]{ICE};
            case FIGHTING -> new PokemonTypes[]{DARK, ROCK, BUG};
            case POISON -> new PokemonTypes[]{FIGHTING, POISON, BUG, GRASS, FAIRY};
            case GROUND -> new PokemonTypes[]{POISON, ROCK};
            case FLYING -> new PokemonTypes[]{FIGHTING, BUG, GRASS};
            case PSYCHIC -> new PokemonTypes[]{FIGHTING, PSYCHIC};
            case BUG -> new PokemonTypes[]{FIGHTING, GROUND, GRASS};
            case ROCK -> new PokemonTypes[]{NORMAL, FLYING, POISON, FIRE};
            case GHOST -> new PokemonTypes[]{POISON, BUG};
            case DARK -> new PokemonTypes[]{GHOST, DARK};
            case DRAGON -> new PokemonTypes[]{FIRE, WATER, GRASS, ELECTRIC};
            case STEEL -> new PokemonTypes[]{NORMAL, FLYING, ROCK, BUG, STEEL, GRASS, PSYCHIC, ICE, DRAGON, FAIRY};
            case FAIRY -> new PokemonTypes[]{FIGHTING, BUG, DARK};
        };
    }

    public PokemonTypes[] getImmunities(PokemonTypes pokemonType) {
        return switch (pokemonType) {
            case NORMAL -> new PokemonTypes[]{GHOST};
            case GROUND -> new PokemonTypes[]{ELECTRIC};
            case FLYING -> new PokemonTypes[]{GROUND};
            case GHOST -> new PokemonTypes[]{NORMAL, FIGHTING};
            case DARK -> new PokemonTypes[]{PSYCHIC};
            case STEEL -> new PokemonTypes[]{POISON};
            case FAIRY -> new PokemonTypes[]{DRAGON};
            case FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, PSYCHIC, BUG, ROCK, DRAGON ->
                    new PokemonTypes[]{};
        };
    }

}
