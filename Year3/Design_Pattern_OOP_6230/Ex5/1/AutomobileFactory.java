public class AutomobileFactory {
    public static AutomobileDisplay getDisplay(String type) {
        switch (type.toLowerCase()) {
            case "ford":
                return new FordDisplay();
            case "toyota":
                return new ToyotaDisplay();
            default:
                throw new IllegalArgumentException("Unknown automobile type: " + type);
        }
    }
}