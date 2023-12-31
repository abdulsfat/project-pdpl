package handler;

public class OperatorHandler implements CalculatorHandler {
    private String operator;
    private CalculatorHandler nextHandler;

    public OperatorHandler(String operator) {
        this.operator = operator;
    }

    @Override
    public double handleRequest(double[] operands) {
        if (nextHandler != null) {
            return nextHandler.handleRequest(operands);
        }
        throw new UnsupportedOperationException("Operator tidak valid: " + operator);
    }

    @Override
    public void setNextHandler(CalculatorHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}