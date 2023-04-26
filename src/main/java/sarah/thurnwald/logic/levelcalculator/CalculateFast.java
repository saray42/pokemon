package sarah.thurnwald.logic.levelcalculator;

public class CalculateFast implements LevelCalculator {
    @Override
    public int calculate(int level) {
        return (int) Math.floor(4 * Math.pow(level, 3) / 5);
    }
}
