package sarah.thurnwald.data.pokeball;

public enum Pokeball {
    POKEBALL(1.f),
    GREATBALL(1.5f),
    ULTRABALL(2.f),
    MASTERBALL(999.f);

    private final float catchRate;

    Pokeball(float catchRate) {
        this.catchRate = catchRate;
    }

    public float getCatchRate() {
        return catchRate;
    }
}
