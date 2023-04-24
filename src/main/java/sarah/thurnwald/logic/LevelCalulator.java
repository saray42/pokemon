package sarah.thurnwald.logic;

import sarah.thurnwald.data.ExpType;

public class LevelCalulator {

    public int calculateLevel(ExpType expType, int level) {
        return switch (expType) {
            case ERRATIC -> calculateErratic(level);
            case FAST -> calculateFast(level);
            case MEDIUMFAST -> calculateMediumFast(level);
            case MEDIUMSLOW -> calculateMediumSlow(level);
            case SLOW -> calculateSlow(level);
            case FLUCTUATING -> calculateFluctuating(level);
        };
    }

    private int calculateErratic(int level) {
        if (level == 1) {
            return 0;
        } else if (level > 1 && level <= 50) {
            return (int) Math.floor(Math.pow(level, 3) * ((double) (100 - level) / 50));
        } else if (level >= 50 && level <= 68) {
            return (int) Math.floor(Math.pow(level, 3) * ((double) (150 - level) / 100));
        } else if (level >= 68 && level <= 98) {
            return (int) Math.floor(Math.pow(level, 3) * ((double) ((1911 - (10 * level)) / 3) / 500));
        } else if (level >= 98 && level <= 100) {
            return (int) Math.floor(Math.pow(level, 3) * ((double) (160 - level) / 100));
        }

        return 0;
    }

    private int calculateFast(int level) {
        return (int) Math.floor(4 * Math.pow(level, 3) / 5);
    }

    private int calculateMediumFast(int level) {
        return (int) Math.pow(level, 3);
    }

    private int calculateMediumSlow(int level) {
        return (int) Math.floor(((double) 6 / 5) * Math.pow(level, 3) - 15 * Math.pow(level, 2) + 100 * level - 140);
    }

    private int calculateSlow(int level) {
        return (int) Math.floor(5 * Math.pow(level, 3) / 4);
    }

    private int calculateFluctuating(int level) {
        if (level <= 15) {
            return (int) Math.floor(Math.pow(level, 3) * ((24 + ((double) (level + 1) / 3)) / 50));
        } else if (level <= 36) {
            return (int) Math.floor(Math.pow(level, 3) * ((double) (14 * level) / 50));
        } else {
            return (int) Math.floor(Math.pow(level, 3) * ((32 + ((double) level / 2)) / 50));
        }
    }
}
