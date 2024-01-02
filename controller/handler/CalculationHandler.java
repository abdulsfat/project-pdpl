package controller.handler;

/**
 * Interface for handling calculations in the Chain of Responsibility pattern.
 * 
 * Penjelasan:
 * 
 * Interface CalculationHandler:
 * - Mendefinisikan metode handleRequest untuk menangani operasi perhitungan.
 */
public interface CalculationHandler {
    /**
     * Metode untuk menangani permintaan operasi perhitungan.
     * 
     * @param operand1  Operan pertama.
     * @param operand2  Operan kedua.
     * @param operation Operator perhitungan.
     * @return Hasil penanganan operasi perhitungan.
     */
    double handleRequest(double operand1, double operand2, String operation);
}
