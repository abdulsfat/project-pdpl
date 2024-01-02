package controller;

import model.CalculatorModel;
import view.CalculatorView;
import view.ResultProcessor;

/**
 * Controller class to manage interactions between the model and view in the calculator application.
 * 
 * Penjelasan:
 * 
 * Konstruktor CalculatorController:
 * - Menerima instance CalculatorModel dan CalculatorView sebagai parameter.
 * - Menginisialisasi atribut model dan view dengan instance yang diterima.
 * 
 * Metode run():
 * - Menjalankan kalkulator dengan langkah-langkah berikut:
 *   - Mendapatkan input pengguna dari tampilan (misalnya, operand-operand) melalui view.
 *   - Memastikan input tidak null sebelum melanjutkan.
 *   - Mendapatkan operasi yang didukung dari model.
 *   - Menampilkan hasil perhitungan ke tampilan menggunakan ResultProcessor.
 */
public class CalculatorController {
    // Atribut untuk menyimpan instance CalculatorModel.
    private CalculatorModel model;
    // Atribut untuk menyimpan instance CalculatorView.
    private CalculatorView view;

    /**
     * Konstruktor untuk menginisialisasi model dan view.
     * 
     * @param model Instance CalculatorModel.
     * @param view  Instance CalculatorView.
     */
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Metode untuk menjalankan kalkulator.
     */
    public void run() {
        // Mendapatkan input pengguna dari tampilan (misalnya, operand-operand).
        double[] operands = view.getUserInput();

        // Memastikan input tidak null sebelum melanjutkan.
        if (operands != null) {
            // Mendapatkan operasi yang didukung dari model.
            String[] operations = model.getOperations();

            // Menampilkan hasil perhitungan ke tampilan menggunakan ResultProcessor.
            ResultProcessor.displayResult(null, operands, operations);
        }
    }
}
