package sarah.thurnwald.logic;

import sarah.thurnwald.data.ExpType;
import sarah.thurnwald.logic.levelcalculator.LevelCalculator;

import java.util.HashMap;
import java.util.Map;


public class LevelCalculatorManager {

    private final HashMap<ExpType, LevelCalculator> levelCalculators;

    public LevelCalculatorManager(HashMap<ExpType, LevelCalculator> levelCalculators) {
        this.levelCalculators = levelCalculators;
    }

    public int calculateLevel(ExpType expType, int level) {
        for (Map.Entry<ExpType, LevelCalculator> calc : levelCalculators.entrySet()) {
            if(expType.equals(calc.getKey())) return calc.getValue().calculate(level);
        }
        return 0;
    }
}
