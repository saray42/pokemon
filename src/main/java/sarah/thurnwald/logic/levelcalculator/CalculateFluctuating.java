package sarah.thurnwald.logic.levelcalculator;

public class CalculateFluctuating implements LevelCalculator {
    @Override
    public int calculate(int level) {
        if (level <= 15) {
            return (int) Math.floor(Math.pow(level, 3) * ((double) (24 + ((level + 1) / 3)) / 50));
        } else if (level <= 36) {
            return (int) Math.floor(Math.pow(level, 3) * ((double) (14 + level) / 50));
        } else {
            return (int) Math.floor(Math.pow(level, 3) * ((double) (32 + (level / 2)) / 50));
        }
    }
}
