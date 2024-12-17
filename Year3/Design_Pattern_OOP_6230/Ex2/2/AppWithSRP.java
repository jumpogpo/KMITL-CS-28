public class AppWithSRP {
    public static void main(String[] args) {
        System.out.println("Welcome to Application");

        // get a pair of values
        PairOfInput pair = PairOfInputProcessor.read();
        MathOperationStrategy addition = new AdditionOperation();
        MathOperationStrategy subtraction = new SubtractionOperation();

        // Check whether the inputs are valid
        if (PairOfInputProcessor.isValid(pair)) {
            int firstInt, secondInt;
            firstInt = Integer.parseInt(pair.getFirst());
            secondInt = Integer.parseInt(pair.getSecond());

            // do the methematical operation
            int additionResult = new MathOperation(addition).calculate(firstInt, secondInt);
            int subtractionResult = new MathOperation(subtraction).calculate(firstInt, secondInt);

            System.out.println("The addition result is: " + additionResult);
            System.out.println("The subtraction result is: " + subtractionResult);
        } else {
            System.out.println("Invalid number");
        }

        System.out.println("End of the application");
    }
}
