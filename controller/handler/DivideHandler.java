package controller.handler;
/**
 * Handler class for division operation in the Chain of Responsibility pattern.
 * 
 * Penjelasan:
 * 
 * Konstruktor DivideHandler:
 * - Menerima CalculationHandler sebagai penerus (successor) dalam pola desain Chain of Responsibility.
 * - Menginisialisasi atribut successor dengan penerus yang diterima.
 * 
 * Metode handleRequest():
 * - Mengimplementasikan operasi penanganan untuk operasi pembagian.
 * - Jika operasi sesuai dengan penanganan DivideHandler dan operand kedua bukan 0, hasilnya dikembalikan.
 * - Jika operand kedua adalah 0, tampilkan pesan kesalahan dan kembalikan nilai default 0.
 * - Jika tidak sesuai, delegasikan ke penerus (successor) jika ada, jika tidak, kembalikan nilai default 0.
 */
public class DivideHandler implements CalculationHandler {
    // Atribut untuk menyimpan penerus (successor) dalam Chain of Responsibility.
    private CalculationHandler successor;

    /**
     * Konstruktor untuk menginisialisasi penerus (successor).
     * 
     * @param successor CalculationHandler sebagai penerus.
     */
    public DivideHandler(CalculationHandler successor) {
        this.successor = successor;
    }

    /**
     * Metode untuk menangani permintaan operasi pembagian.
     * 
     * @param operand1  Operan pertama.
     * @param operand2  Operan kedua.
     * @param operation Operator pembagian.
     * @return Hasil penanganan operasi pembagian.
     */
    @Override
    public double handleRequest(double operand1, double operand2, String operation) {
        // Jika operasi sesuai dengan penanganan DivideHandler dan operand kedua bukan 0, hasilnya dikembalikan.
        if (operation.equals("/")) {
            if (operand2 != 0) {
                return operand1 / operand2;
            } else {
                // Jika operand kedua adalah 0, tampilkan pesan kesalahan dan kembalikan nilai default 0.
                System.out.println("Tidak Bisa dibagi dengan 0");
                return 0;
            }
        } else if (successor != null) {
            // Jika tidak sesuai, delegasikan ke penerus (successor) jika ada.
            return successor.handleRequest(operand1, operand2, operation);
        } else {
            // Jika tidak ada handler yang sesuai, kembalikan nilai default 0.
            return 0;
        }
    }
}
