package handlers.chainofresponsibility;
// Implementasi handler pembagian
public class DivideHandler implements CalculationHandler {
    private CalculationHandler successor;

    public DivideHandler(CalculationHandler successor) {
        this.successor = successor;
    }

    @Override
    public double handleRequest(double operand1, double operand2, String operation) {
        if (operation.equals("/")) {
            if (operand2 != 0) {
                return operand1 / operand2;
            } else {
                System.out.println("Cannot divide by zero");
                return 0;
            }
        } else if (successor != null) {
            return successor.handleRequest(operand1, operand2, operation);
        } else {
            return 0;
        }
    }
}
