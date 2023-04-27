package sarah.thurnwald.logic.levelcalculator;

public class CalculateErratic implements LevelCalculator {
    @Override
    public int calculate(int level) {
        if (level > 1 && level <= 50) {
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
}
