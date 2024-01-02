package view;

import java.util.ArrayList;
import model.CalculatorModel;

/**
 * Class to process and display the result of calculator operations.
 * 
 * Penjelasan:
 * 
 * Import Statements: Mengimpor kelas-kelas yang diperlukan dari paket util dan Java.
 */
public class ResultProcessor {
    /**
     * Metode untuk menampilkan hasil operasi kalkulator.
     * 
     * Penjelasan:
     * 
     * Metode displayResult():
     * - Mengecek apakah terdapat operasi yang dapat dihitung.
     * - Jika ada, membuat instance dari CalculatorModel dan menghitung hasil operasi.
     * - Menampilkan hasil perhitungan.
     * 
     * @param operands         ArrayList<Double> yang berisi operand-operand dari ekspresi matematika.
     * @param operandsHandler  Array double yang berisi handler untuk operand-operand.
     * @param operations       Array String yang berisi operator-operator dari ekspresi matematika.
     */
    public static void displayResult(ArrayList<Double> operands, double[] operandsHandler, String[] operations) {
        if (operandsHandler != null) {
            CalculatorModel calculatorModel = new CalculatorModel(); // Membuat instance dari CalculatorModel untuk menghitung hasil operasi.
            double resultHandler = calculatorModel.calculate(operandsHandler, operations); // Menghitung hasil operasi.
            System.out.println("Hasil: " + resultHandler); // Menampilkan hasil perhitungan.
        } else {
            System.out.println("Tidak ada operasi."); // Menampilkan pesan jika tidak ada operasi yang dapat dihitung.
        }
    }
}
