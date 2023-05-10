package sarah.thurnwald.logic.generator;

public class RandomNumberGenerator {
    public int generate(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
