package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.ExpressionParser;


/**
     * Metode untuk menerima input pengguna dan menangani operasi kalkulator.
     * Penjelasan:
     * 
     * Import Statements: Mengimpor kelas-kelas yang diperlukan dari paket util dan Java.
     * 
     * Deklarasi Kelas: Deklarasi kelas CalculatorView.
     * 
     * Atribut Scanner: Mendeklarasikan objek Scanner untuk menerima input dari pengguna.
     * 
     * Metode getUserInput():
     * - Loop Utama (While): Mengatur loop utama untuk terus menerima input dari pengguna hingga pengguna memilih untuk keluar.
     * - Input Expression: Meminta pengguna untuk memasukkan ekspresi matematika atau keluar.
     * - Exit Condition: Mengecek apakah pengguna memilih untuk keluar.
     * - Pemecahan Ekspresi: Memecah ekspresi menjadi bagian-bagian (operand dan operator) menggunakan ExpressionParser.
     * - Validasi Ekspresi: Memeriksa apakah format ekspresi valid.
     * - Inisialisasi Array: Mendeklarasikan array untuk menangani operand dan operator.
     * - Pengisian Array: Mengisi array operand dan operator menggunakan ExpressionParser.
     * - Inisialisasi ArrayList: Inisialisasi objek ArrayList untuk menangani operand.
     * - Iterasi Ekspresi: Iterasi melalui bagian-bagian ekspresi untuk memproses operand dan operator.
     * - Menutup Scanner: Menutup objek Scanner setelah selesai menggunakan.
     * - Return Statement: Mengembalikan nilai null karena metode ini seharusnya mengembalikan array double (belum diimplementasikan).
     */

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public double[] getUserInput() {
        boolean isRunning = true;
        while (isRunning) {
            // Meminta pengguna untuk memasukkan ekspresi matematika atau keluar.
            System.out.print("Masukkan ekspresi matematika (atau ketik 'exit' untuk keluar): ");
            String expression = scanner.nextLine();

            if (expression.equalsIgnoreCase("exit")) {
                isRunning = false; // Menghentikan loop jika pengguna memilih untuk keluar.
            } else {
                // Memecah ekspresi menjadi bagian-bagian (operand dan operator).
                List<String> parts = ExpressionParser.parseExpression(expression);

                // Memeriksa apakah format ekspresi valid.
                if (parts.size() % 2 == 0) {
                    System.out.println("Format ekspresi tidak valid");
                    continue; // Melanjutkan loop jika format ekspresi tidak valid.
                }

                // Mendeklarasikan array untuk menangani operand dan operator.
                double[] operandsHandler = new double[(parts.size() + 1) / 2];
                String[] operations = new String[parts.size() / 2];

                // Mengisi array operand dan operator.
                ExpressionParser.populateOperandsAndOperations(parts, operandsHandler, operations);

                // Inisialisasi objek Operasi sebagai null.
                ArrayList<Double> operands = new ArrayList<>();

                // Iterasi melalui bagian-bagian ekspresi.
                for (String token : parts) {
                    // Memeriksa apakah token adalah operand numerik.
                    if (token.matches("\\d+\\.?\\d*")) {
                        operands.add(Double.parseDouble(token));
                    } else {
                        // Menangani operator (komentar ini perlu diimplementasikan).
                        // operation = handleOperator(operation, operands, token);
                    }
                }

                // Menampilkan hasil perhitungan.
                ResultProcessor.displayResult(operands, operandsHandler, operations);
            }
        }
        // Menutup objek Scanner setelah selesai menggunakan.
        scanner.close();
        // Mengembalikan nilai null karena metode ini seharusnya mengembalikan array double (belum diimplementasikan).
        return null;
    }     
}
