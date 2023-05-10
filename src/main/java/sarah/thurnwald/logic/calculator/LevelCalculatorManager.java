package sarah.thurnwald.logic.calculator;

import sarah.thurnwald.data.pokemon.ExpType;
import sarah.thurnwald.logic.calculator.levelcalculator.LevelCalculator;

import java.util.Map;


public class LevelCalculatorManager {

    private final Map<ExpType, LevelCalculator> levelCalculators;

    public LevelCalculatorManager(Map<ExpType, LevelCalculator> levelCalculators) {
        this.levelCalculators = levelCalculators;
    }

    public int calculateExpForLevel(ExpType expType, int level) {
        return levelCalculators.entrySet().stream()
                .filter(element -> element.getKey().equals(expType))
                .findFirst()
                .map(element -> element.getValue().calculate(level))
                .orElseThrow(RuntimeException::new);
    }
}
