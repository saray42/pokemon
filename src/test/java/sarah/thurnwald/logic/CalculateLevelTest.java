package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.ExpType;

import static org.junit.jupiter.api.Assertions.*;

class CalculateLevelTest {

    LevelCalculator levelCalulator = new LevelCalculator();
    @Test
    void calculateLevelErratic() {
        assertEquals(600_000, levelCalulator.calculateLevel(ExpType.ERRATIC, 100));
    }

    @Test
    void calculateLevelFast() {
        assertEquals(800_000, levelCalulator.calculateLevel(ExpType.FAST, 100));
    }

    @Test
    void calculateLevelMediumfast() {
        assertEquals(1_000_000, levelCalulator.calculateLevel(ExpType.MEDIUMFAST, 100));
    }

    @Test
    void calculateLevelMediumslow() {
        assertEquals(1_059_860, levelCalulator.calculateLevel(ExpType.MEDIUMSLOW, 100));
    }

    @Test
    void calculateLevelSlow() {
        assertEquals(1_250_000, levelCalulator.calculateLevel(ExpType.SLOW, 100));
    }
    @Test
    void calculateLevelFluctuating() {
        assertEquals(1_640_000, levelCalulator.calculateLevel(ExpType.FLUCTUATING, 100));
    }
}