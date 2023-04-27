package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.ExpType;

import static org.junit.jupiter.api.Assertions.*;

class CalculateLevelTest {

    LevelCalculator levelCalculator = new LevelCalculator();

    @Test
    void calculateLevelErratic() {
        assertEquals(600_000, levelCalculator.calculateLevel(ExpType.ERRATIC, 100));
    }

    @Test
    void calculateLevelFast() {
        assertEquals(800_000, levelCalculator.calculateLevel(ExpType.FAST, 100));
    }

    @Test
    void calculateLevelMediumFast() {
        assertEquals(1_000_000, levelCalculator.calculateLevel(ExpType.MEDIUM_FAST, 100));
    }

    @Test
    void calculateLevelMediumSlow() {
        assertEquals(1_059_860, levelCalculator.calculateLevel(ExpType.MEDIUM_SLOW, 100));
    }

    @Test
    void calculateLevelSlow() {
        assertEquals(1_250_000, levelCalculator.calculateLevel(ExpType.SLOW, 100));
    }

    @Test
    void calculateLevelFluctuating() {
        assertEquals(1_640_000, levelCalculator.calculateLevel(ExpType.FLUCTUATING, 100));
    }

    @Test
    void calculateLevelFluctuatingLvl2() {
        assertEquals(4, levelCalculator.calculateLevel(ExpType.FLUCTUATING, 2));
    }

    @Test
    void calculateLevelFluctuatingLvl50() {
        assertEquals(142_500, levelCalculator.calculateLevel(ExpType.FLUCTUATING, 50));
    }

    @Test
    void calculateLevelErraticLvl2() {
        assertEquals(15, levelCalculator.calculateLevel(ExpType.ERRATIC, 2));
    }
}