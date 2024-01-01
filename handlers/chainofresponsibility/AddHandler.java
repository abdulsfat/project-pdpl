package handlers.chainofresponsibility;

public class AddHandler implements CalculationHandler {
    private CalculationHandler successor;

    public AddHandler(CalculationHandler successor) {
        this.successor = successor;
    }

    @Override
    public double handleRequest(double operand1, double operand2, String operation) {
        if (operation.equals("+")) {
            return operand1 + operand2;
        } else if (successor != null) {
            return successor.handleRequest(operand1, operand2, operation);
        } else {
            return 0; // Default, jika tidak ada handler yang sesuai
        }
    }
}



// class AddOperation implements Operasi {
//     private double operand1;
//     private double operand2;

//     public AddOperation(double operand1, double operand2) {
//         this.operand1 = operand1;
//         this.operand2 = operand2;
//     }

//     @Override
//     public double performOperation(double[] operands) {
//         // Logika operasi penambahan sesuai dengan kebutuhan
//         return operand1 + operand2;
//     }
// }
