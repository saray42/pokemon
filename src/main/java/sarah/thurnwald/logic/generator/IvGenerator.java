package sarah.thurnwald.logic.generator;

public class IvGenerator {

    private final int RANDOM_MIN = 0;

    private final int RANDOM_MAX = 31;

    private final RandomNumberGenerator randomNumberGenerator;

    public IvGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int generate() {
        return randomNumberGenerator.generate(RANDOM_MIN, RANDOM_MAX);
    }

}
