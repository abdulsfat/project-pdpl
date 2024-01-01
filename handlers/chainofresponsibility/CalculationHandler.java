package handlers.chainofresponsibility;

public interface CalculationHandler {
    double handleRequest(double operand1, double operand2, String operation);
    // Operasi getCurrentOperation();
}