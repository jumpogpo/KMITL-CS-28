public class MathOperation {
    MathOperationStrategy operation;

    public MathOperation(MathOperationStrategy operation) {
        this.operation = operation;
    }

    public int calculate(int num1, int num2) {
        return this.operation.calculate(num1, num2);
    }
}
