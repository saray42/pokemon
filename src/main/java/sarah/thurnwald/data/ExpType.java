package sarah.thurnwald.data;

public enum ExpType {
    ERRATIC("ERRATIC"),
    FAST("FAST"),
    MEDIUMFAST("MEDIUMFAST"),
    MEDIUMSLOW("MEDIUMSLOW"),
    SLOW("SLOW"),
    FLUCTUATING("FLUCTUATING");


    private final String expType;

    ExpType(String expType) {
        this.expType = expType.toUpperCase();
    }

    public ExpType getExpType() {
        return ExpType.valueOf(expType);
    }

}
