package sarah.thurnwald.logic;

import sarah.thurnwald.data.ExpType;
import sarah.thurnwald.logic.levelcalculator.LevelCalculator;

import java.util.HashMap;
import java.util.Map;


public class LevelCalculatorManager {

    private final Map<ExpType, LevelCalculator> levelCalculators;

    public LevelCalculatorManager(Map<ExpType, LevelCalculator> levelCalculators) {
        this.levelCalculators = levelCalculators;
    }

    public int calculateLevel(ExpType expType, int level) {
        return levelCalculators.entrySet().stream()
                .filter(element -> element.getKey().equals(expType))
                .findFirst()
                .map(element -> element.getValue().calculate(level))
                .orElseThrow(RuntimeException::new);
    }
}
