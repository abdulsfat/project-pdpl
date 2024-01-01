package handlers.chainofresponsibility;
// Implementasi handler perkalian
public class MultiplyHandler implements CalculationHandler {
    private CalculationHandler successor;

    public MultiplyHandler(CalculationHandler successor) {
        this.successor = successor;
    }

    @Override
    public double handleRequest(double operand1, double operand2, String operation) {
        if (operation.equals("*")) {
            return operand1 * operand2;
        } else if (successor != null) {
            return successor.handleRequest(operand1, operand2, operation);
        } else {
            return 0;
        }
    }
}