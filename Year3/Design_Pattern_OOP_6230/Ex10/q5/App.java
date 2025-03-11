public class App {
    public static void main(String[] args) {
        Logger loggerChain = LoggerChain.getLoggerChain();

        System.out.println("=== INFO Level ===");
        loggerChain.logMessage(Logger.INFO, "This is an information.");

        System.out.println("\n=== DEBUG Level ===");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug information.");

        System.out.println("\n=== ERROR Level ===");
        loggerChain.logMessage(Logger.ERROR, "This is an error information.");
    }
}

