package sarah.thurnwald.logic.calculator.levelcalculator;

public class CalculateMediumSlow implements LevelCalculator {
    @Override
    public int calculate(int level) {
        return (int) Math.floor(((double) 6 / 5) * Math.pow(level, 3) - 15 * Math.pow(level, 2) + 100 * level - 140);
    }
}
