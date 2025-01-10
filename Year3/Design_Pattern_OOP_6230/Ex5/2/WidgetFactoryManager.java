public class WidgetFactoryManager {
    public static IWidgetFactory createWidgetFactory(String factoryType) {
        switch (factoryType) {
            case "PM":
                return PMWidgetFactory.getMotifWidgetFactory();
            case "Motif":
                return MotifWidgetFactory.getMotifWidgetFactory();
            default:
                throw new IllegalArgumentException("Invalid factory type");
        }
    }
}
