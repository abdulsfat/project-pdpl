package handlers.chainofresponsibility;
// Implementasi handler pengurangan
public class SubtractHandler implements CalculationHandler {
    private CalculationHandler successor;

    public SubtractHandler(CalculationHandler successor) {
        this.successor = successor;
    }

    @Override
    public double handleRequest(double operand1, double operand2, String operation) {
        if (operation.equals("-")) {
            return operand1 - operand2;
        } else if (successor != null) {
            return successor.handleRequest(operand1, operand2, operation);
        } else {
            return 0;
        }
    }
}