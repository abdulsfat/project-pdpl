package handler;

import java.util.Arrays;

public class PembagianHandler implements CalculatorHandler {
    private CalculatorHandler nextHandler;

    @Override
    public double handleRequest(double[] operands) {
        if (Arrays.stream(operands).anyMatch(operand -> operand == 0)) {
            throw new ArithmeticException("Pembagian oleh nol tidak diizinkan.");
        }

        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result /= operands[i];
        }

        if (nextHandler != null) {
            return nextHandler.handleRequest(new double[]{result});
        }

        return result;
    }

    @Override
    public void setNextHandler(CalculatorHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}