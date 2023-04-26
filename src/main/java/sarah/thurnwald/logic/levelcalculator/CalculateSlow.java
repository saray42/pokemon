package sarah.thurnwald.logic.levelcalculator;

public class CalculateSlow implements LevelCalculator {
    @Override
    public int calculate(int level) {
        return (int) Math.floor(5 * Math.pow(level, 3) / 4);
    }
}
