enum Price {
    FIVE(5),
    TEN(10),
    FIFTEEN(15);

    private final int value;

    Price(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}