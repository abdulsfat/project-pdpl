package model;

import java.util.List;

import controller.handler.AddHandler;
import controller.handler.CalculationHandler;
import controller.handler.DivideHandler;
import controller.handler.MultiplyHandler;
import controller.handler.NegateHandler;
import controller.handler.SubtractHandler;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class representing the Calculator Model that performs calculations.
 * 
 * Penjelasan:
 * 
 * Import Statements: Mengimpor kelas-kelas yang diperlukan dari paket controller.handler dan Java.
 */
public class CalculatorModel {
    // Atribut untuk menangani operasi perhitungan dengan pola desain Chain of Responsibility.
    private CalculationHandler handlerChain;
    // Menyimpan daftar operasi yang baru saja dihitung.
    private List<String> currentOperations;

    /**
     * Konstruktor CalculatorModel:
     * - Menginisialisasi handlerChain dengan pola desain Chain of Responsibility.
     * - Menginisialisasi currentOperations sebagai ArrayList kosong.
     */
    public CalculatorModel() {
        this.handlerChain = new AddHandler(new SubtractHandler(new MultiplyHandler(new DivideHandler(new NegateHandler(null)))));
        this.currentOperations = new ArrayList<>();
    }

    /**
     * Metode untuk menghitung hasil dari ekspresi matematika.
     * 
     * @param operands    Array double yang berisi operand-operand dari ekspresi matematika.
     * @param operations  Array String yang berisi operator-operator dari ekspresi matematika.
     * @return            Hasil perhitungan dari ekspresi matematika.
     */
    public double calculate(double[] operands, String[] operations) {

    // Mengecek apakah jumlah operator sesuai dengan jumlah operand.
    if (operations.length != operands.length - 1) {
        System.out.println("Format ekspresi tidak valid");
        return 0;
    }

    // Inisialisasi List untuk menyimpan operand dan operator sementara.
    List<Double> tempOperands = new ArrayList<>();
    List<String> tempOperations = new ArrayList<>();

    // Inisialisasi hasil sementara dengan operand pertama.
    double tempResult = operands[0];

    // Iterasi melalui array operator.
    for (int i = 0; i < operations.length; i++) {
        // Memeriksa apakah operator adalah perkalian atau pembagian.
        if (operations[i].equals("*") || operations[i].equals("/")) {
            // Mengambil operand berikutnya.
            double nextOperand = operands[i + 1];
            
            // Menangani operasi perkalian atau pembagian.
            if (operations[i].equals("*")) {
                tempResult *= nextOperand;
            } else {
                // Menangani pembagian, memeriksa apakah pembagian oleh nol.
                if (nextOperand == 0) {
                    System.out.println("Pembagian oleh nol tidak diizinkan");
                    return 0;
                }
                tempResult /= nextOperand;
            }
        } else {
            // Menyimpan hasil sementara, operator, dan mengambil operand berikutnya.
            tempOperands.add(tempResult);
            tempOperations.add(operations[i]);
            tempResult = operands[i + 1];
        }
    }
    // Menambahkan hasil terakhir ke list operand sementara.
    tempOperands.add(tempResult);

    // Inisialisasi hasil dengan operand pertama.
    double result = tempOperands.get(0);

    // Iterasi melalui list operator sementara.
    for (int i = 0; i < tempOperations.size(); i++) {
        // Menangani penambahan atau pengurangan sesuai operator.
        if (tempOperations.get(i).equals("+")) {
            result += tempOperands.get(i + 1);
        } else {
            result -= tempOperands.get(i + 1);
        }
    }

    // Menyimpan operasi yang baru saja dihitung.
    this.currentOperations = Arrays.asList(operations);

    // Mengembalikan hasil perhitungan.
    return result;
}

    /**
     * Metode untuk mendapatkan handlerChain.
     * 
     * @return CalculationHandler yang merupakan handlerChain.
     */
    public CalculationHandler getHandlerChain() {
        return this.handlerChain;
    }

    /**
     * Metode untuk mendapatkan daftar operasi yang baru saja dihitung.
     * 
     * @return Array String yang berisi operasi-operasi.
     */
    public String[] getOperations() {
        return this.currentOperations.toArray(new String[0]);
    }
}
