import java.util.Scanner;
import util.CalculatorLogger;
import operation.OperasiFactory;
import operation.Operasi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorLogger logger = CalculatorLogger.getInstance();
        logger.log("Selamat Datang di Calculator App");

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        

        while (isRunning) {
            // Meminta input ekspresi dari pengguna
            System.out.print("Masukkan ekspresi matematika (atau ketik 'exit' untuk keluar): ");
            String expression = scanner.nextLine();

            if (expression.equalsIgnoreCase("exit")) {
                isRunning = false;
            } else {
                // Membuat pattern untuk mencocokkan operator dan operand
                Pattern pattern = Pattern.compile("(\\d+\\.?\\d*)|([\\+\\-\\*\\/])");

                // Mencocokkan operator dan operand menggunakan Matcher
                Matcher matcher = pattern.matcher(expression);

                // Menyimpan operator dan operand dalam ArrayList
                var tokens = new ArrayList<String>();
                while (matcher.find()) {
                    tokens.add(matcher.group());
                }

                // Membuat operasi sesuai dengan operator yang dimasukkan
                Operasi operation = null;
                ArrayList<Double> operands = new ArrayList<>();

                for (String token : tokens) {
                    if (token.matches("\\d+\\.?\\d*")) {
                        // Token adalah operand, tambahkan ke daftar operands
                        operands.add(Double.parseDouble(token));
                    } else {
                        // Token adalah operator, buat operasi baru
                        if (operation == null) {
                            operation = OperasiFactory.createOperation(token);
                        } else {
                            // Hitung hasil operasi sebelumnya
                            double result = operation.performOperation(operands.stream().mapToDouble(Double::doubleValue).toArray());

                            // Bersihkan daftar operands dan tambahkan hasil operasi
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
