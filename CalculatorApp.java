// Program ini merupakan aplikasi kalkulator sederhana yang menerima input ekspresi matematika dari pengguna.

import java.util.Scanner;
import util.CalculatorLogger;
import operation.OperasiFactory;
import operation.Operasi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class CalculatorApp {
    public static void main(String[] args) {
        // Menginisialisasi logger untuk mencatat log aplikasi
        CalculatorLogger logger = CalculatorLogger.getInstance();
        logger.log("Selamat Datang di Calculator App");

        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Variabel untuk menentukan apakah aplikasi sedang berjalan atau tidak
        boolean isRunning = true;

        while (isRunning) {
            // Meminta input ekspresi matematika dari pengguna
            System.out.print("Masukkan ekspresi matematika (atau ketik 'exit' untuk keluar): ");
            String expression = scanner.nextLine();

            // Memeriksa apakah pengguna ingin keluar dari aplikasi
            if (expression.equalsIgnoreCase("exit")) {
                isRunning = false;
            } else {
                // Membuat pola untuk mencocokkan operator dan operand dalam ekspresi
                Pattern pattern = Pattern.compile("(\\d+\\.?\\d*)|([\\+\\-\\*\\/])");

                // Mencocokkan operator dan operand menggunakan Matcher
                Matcher matcher = pattern.matcher(expression);

                // Menyimpan operator dan operand dalam ArrayList
                var tokens = new ArrayList<String>();
                while (matcher.find()) {
                    tokens.add(matcher.group());
                }

                // Membuat objek operasi berdasarkan operator yang dimasukkan
                Operasi operation = null;
                ArrayList<Double> operands = new ArrayList<>();

                // Iterasi melalui token-token dalam ekspresi
                for (String token : tokens) {
                    if (token.matches("\\d+\\.?\\d*")) {
                        // Jika token adalah operand, tambahkan ke daftar operands
                        operands.add(Double.parseDouble(token));
                    } else {
                        // Jika token adalah operator
                        if (operation == null) {
                            // Jika belum ada operasi sebelumnya, buat operasi baru
                            operation = OperasiFactory.createOperation(token);
                        } else {
                            // Jika sudah ada operasi sebelumnya, hitung hasil operasi tersebut
                            double result = operation.performOperation(operands.stream().mapToDouble(Double::doubleValue).toArray());

                            // Bersihkan daftar operands dan tambahkan hasil operasi sebagai operand baru
                            operands.clear();
                            operands.add(result);

                            // Buat operasi baru dengan operator yang baru
                            operation = OperasiFactory.createOperation(token);
                        }
                    }
                }

                // Menampilkan hasil operasi terakhir
                if (operation != null) {
                    double result = operation.performOperation(operands.stream().mapToDouble(Double::doubleValue).toArray());
                    System.out.println("Hasil operasi: " + result);
                } else {
                    System.out.println("Tidak ada operasi yang dilakukan.");
                }
            }
        }

        // Menutup scanner
        scanner.close();
    }
}