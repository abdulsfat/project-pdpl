package controller.handler;

/**
 * Handler class for negation (unary minus) operation in the Chain of Responsibility pattern.
 * 
 * Penjelasan:
 * 
 * Konstruktor NegateHandler:
 * - Menerima CalculationHandler sebagai penerus (successor) dalam pola desain Chain of Responsibility.
 * - Menginisialisasi atribut successor dengan penerus yang diterima.
 * 
 * Metode handleRequest():
 * - Mengimplementasikan operasi penanganan untuk operasi negasi (unary minus).
 * - Jika operasi sesuai dengan penanganan NegateHandler, hasil negasi dari operand1 dikembalikan.
 * - Jika tidak sesuai, delegasikan ke penerus (successor) jika ada, jika tidak, kembalikan nilai default 0.
 */
public class NegateHandler implements CalculationHandler {
    // Atribut untuk menyimpan penerus (successor) dalam Chain of Responsibility.
    private CalculationHandler successor;

    /**
     * Konstruktor untuk menginisialisasi penerus (successor).
     * 
     * @param successor CalculationHandler sebagai penerus.
     */
    public NegateHandler(CalculationHandler successor) {
        this.successor = successor;
    }

    /**
     * Metode untuk menangani permintaan operasi negasi (unary minus).
     * 
     * @param operand1  Operan pertama.
     * @param operand2  Operan kedua.
     * @param operation Operator negasi (unary minus).
     * @return Hasil penanganan operasi negasi (unary minus).
     */
    @Override
    public double handleRequest(double operand1, double operand2, String operation) {
        // Jika operasi sesuai dengan penanganan NegateHandler, hasil negasi dari operand1 dikembalikan.
        if (operation.equals("-")) {
            return -operand1;
        } else if (successor != null) {
            // Jika tidak sesuai, delegasikan ke penerus (successor) jika ada.
            return successor.handleRequest(operand1, operand2, operation);
        } else {
            // Jika tidak ada handler yang sesuai, kembalikan nilai default 0.
            return 0;
        }
    }
}
