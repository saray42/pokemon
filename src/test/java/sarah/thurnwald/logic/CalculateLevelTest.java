package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.ExpType;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculateLevelTest {

    HashMap<ExpType, LevelCalculator> levelCalculators = new HashMap<>(
            Map.of(
                    ExpType.ERRATIC, new CalculateErratic(),
                    ExpType.FAST, new CalculateFast(),
                    ExpType.MEDIUM_FAST, new CalculateMediumFast(),
                    ExpType.MEDIUM_SLOW, new CalculateMediumSlow(),
                    ExpType.SLOW, new CalculateSlow(),
                    ExpType.FLUCTUATING, new CalculateFluctuating()
            )
    );

    LevelCalculatorManager levelCalculator = new LevelCalculatorManager(levelCalculators);

    @Test
    void calculateLevelErratic() {
        assertEquals(600_000, levelCalculator.calculateExpForLevel(ExpType.ERRATIC, 100));
    }

    @Test
    void calculateLevelFast() {
        assertEquals(800_000, levelCalculator.calculateExpForLevel(ExpType.FAST, 100));
    }

    @Test
    void calculateLevelMediumFast() {
        assertEquals(1_000_000, levelCalculator.calculateExpForLevel(ExpType.MEDIUM_FAST, 100));
    }

    @Test
    void calculateLevelMediumSlow() {
        assertEquals(1_059_860, levelCalculator.calculateExpForLevel(ExpType.MEDIUM_SLOW, 100));
    }

    @Test
    void calculateLevelSlow() {
        assertEquals(1_250_000, levelCalculator.calculateExpForLevel(ExpType.SLOW, 100));
    }

    @Test
    void calculateLevelFluctuating() {
        assertEquals(1_640_000, levelCalculator.calculateExpForLevel(ExpType.FLUCTUATING, 100));
    }

    @Test
    void calculateLevelFluctuatingLvl2() {
        assertEquals(4, levelCalculator.calculateExpForLevel(ExpType.FLUCTUATING, 2));
    }

    @Test
    void calculateLevelFluctuatingLvl50() {
        assertEquals(142_500, levelCalculator.calculateExpForLevel(ExpType.FLUCTUATING, 50));
    }

    @Test
    void calculateLevelErraticLvl2() {
        assertEquals(15, levelCalculator.calculateExpForLevel(ExpType.ERRATIC, 2));
    }
}