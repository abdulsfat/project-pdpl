package controller.handler;

/**
 * Handler class for subtraction operation in the Chain of Responsibility pattern.
 * 
 * Penjelasan:
 * 
 * Konstruktor SubtractHandler:
 * - Menerima CalculationHandler sebagai penerus (successor) dalam pola desain Chain of Responsibility.
 * - Menginisialisasi atribut successor dengan penerus yang diterima.
 * 
 * Metode handleRequest():
 * - Mengimplementasikan operasi penanganan untuk operasi pengurangan.
 * - Jika operasi sesuai dengan penanganan SubtractHandler, hasil pengurangan dari operand1 dan operand2 dikembalikan.
 * - Jika tidak sesuai, delegasikan ke penerus (successor) jika ada, jika tidak, kembalikan nilai default 0.
 */
public class SubtractHandler implements CalculationHandler {
    // Atribut untuk menyimpan penerus (successor) dalam Chain of Responsibility.
    private CalculationHandler successor;

    /**
     * Konstruktor untuk menginisialisasi penerus (successor).
     * 
     * @param successor CalculationHandler sebagai penerus.
     */
    public SubtractHandler(CalculationHandler successor) {
        this.successor = successor;
    }

    /**
     * Metode untuk menangani permintaan operasi pengurangan.
     * 
     * @param operand1  Operan pertama.
     * @param operand2  Operan kedua.
     * @param operation Operator pengurangan.
     * @return Hasil penanganan operasi pengurangan.
     */
    @Override
    public double handleRequest(double operand1, double operand2, String operation) {
        // Jika operasi sesuai dengan penanganan SubtractHandler, hasil pengurangan dari operand1 dan operand2 dikembalikan.
        if (operation.equals("-")) {
            return operand1 - operand2;
        } else if (successor != null) {
            // Jika tidak sesuai, delegasikan ke penerus (successor) jika ada.
            return successor.handleRequest(operand1, operand2, operation);
        } else {
            // Jika tidak ada handler yang sesuai, kembalikan nilai default 0.
            return 0;
        }
    }
}
