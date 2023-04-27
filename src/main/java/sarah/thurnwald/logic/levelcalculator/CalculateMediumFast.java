package sarah.thurnwald.logic.levelcalculator;

public class CalculateMediumFast implements LevelCalculator {
    @Override
    public int calculate(int level) {
        return (int) Math.pow(level, 3);
    }
}
