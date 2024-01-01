// Program ini merupakan aplikasi kalkulator sederhana yang menerima input ekspresi matematika dari pengguna.

import java.util.Scanner;
import util.CalculatorLogger;
import operation.OperasiFactory;
import operation.Operasi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;


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


            //  operasi untuk handler
      // Pisahkan ekspresi menjadi angka dan operasi
      List<String> parts = new ArrayList<>();

      StringBuilder currentPart = new StringBuilder();
      for (char c : expression.toCharArray()) {
          if (Character.isDigit(c) || c == '.') {
              currentPart.append(c);
          } else {
              if (currentPart.length() > 0) {
                  parts.add(currentPart.toString());
                  currentPart = new StringBuilder();
              }
              parts.add(String.valueOf(c));
          }
      }

      if (currentPart.length() > 0) {
          parts.add(currentPart.toString());
      }

      // Validasi masukan
      if (parts.size() % 2 == 0) {
          System.out.println("Format ekspresi tidak valid");
          return;
      }

      double[] operandshn = new double[(parts.size() + 1) / 2];
      String[] operations = new String[parts.size() / 2];

      for (int i = 0; i < parts.size(); i++) {
          if (i % 2 == 0) {
              try {
                  operandshn[i / 2] = Double.parseDouble(parts.get(i));
              } catch (NumberFormatException e) {
                  System.out.println("Format operand tidak valid");
                  return;
              }
          } else {
              operations[i / 2] = parts.get(i);
          }
      }




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

                Calculator calculator = new Calculator();
                double result = calculator.calculate(operandshn, operations);
System.out.println("Hasil: " + result);
            }
        }

        // Menutup scanner
        scanner.close();
    }
}