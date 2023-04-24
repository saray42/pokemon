package sarah.thurnwald.logic;

import org.junit.jupiter.api.Test;
import sarah.thurnwald.data.ExpType;

import static org.junit.jupiter.api.Assertions.*;

class CalculateLevelTest {

    LevelCalulator levelCalulator = new LevelCalulator();
    @Test
    void calculateLevel() {
        assertEquals(276_458, levelCalulator.calculateLevel(ExpType.ERRATIC, 70));
    }
}