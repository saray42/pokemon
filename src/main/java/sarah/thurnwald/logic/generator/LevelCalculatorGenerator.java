package sarah.thurnwald.logic.generator;

import sarah.thurnwald.data.pokemon.ExpType;
import sarah.thurnwald.logic.calculator.levelcalculator.*;

import java.util.HashMap;
import java.util.Map;

public class LevelCalculatorGenerator {
    public Map<ExpType, LevelCalculator> generate() {
        return new HashMap<>(
                Map.of(
                        ExpType.ERRATIC, new CalculateErratic(),
                        ExpType.FAST, new CalculateFast(),
                        ExpType.MEDIUM_FAST, new CalculateMediumFast(),
                        ExpType.MEDIUM_SLOW, new CalculateMediumSlow(),
                        ExpType.SLOW, new CalculateSlow(),
                        ExpType.FLUCTUATING, new CalculateFluctuating()
                )
        );
    }
}
