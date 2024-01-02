package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to parse mathematical expressions and populate operands and operations arrays.
 * 
 * Penjelasan:
 * 
 * Metode parseExpression():
 * - Menerima ekspresi matematika sebagai input.
 * - Membuat daftar bagian-bagian (operand dan operator) dari ekspresi.
 * - Menangani angka negatif dan digit desimal.
 * - Mengembalikan daftar bagian-bagian ekspresi.
 * 
 * Metode populateOperandsAndOperations():
 * - Menerima daftar bagian-bagian ekspresi, array untuk operandsHandler, dan array untuk operations.
 * - Mengisi array operandsHandler dengan operand numerik dari ekspresi.
 * - Mengisi array operations dengan operator dari ekspresi.
 */
public class ExpressionParser {
    /**
     * Metode untuk memecah ekspresi matematika menjadi bagian-bagian.
     * 
     * @param expression  Ekspresi matematika yang akan dipecah.
     * @return            List<String> berisi bagian-bagian ekspresi.
     */
    public static List<String> parseExpression(String expression) {
        List<String> parts = new ArrayList<>();
        StringBuilder currentPart = new StringBuilder();

        // Iterasi melalui karakter-karakter ekspresi.
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Menangani digit atau desimal.
            if (Character.isDigit(c) || c == '.') {
                currentPart.append(c);
            } else if (c == '-' && (i == 0 || !Character.isDigit(expression.charAt(i - 1)))) {
                // Menangani angka negatif.
                currentPart.append(c);
            } else {
                // Menyimpan bagian yang sudah terbentuk ke dalam daftar.
                if (currentPart.length() > 0) {
                    parts.add(currentPart.toString());
                    currentPart = new StringBuilder();
                }
                parts.add(String.valueOf(c));
            }
        }

        // Menambahkan bagian terakhir ke dalam daftar.
        if (currentPart.length() > 0) {
            parts.add(currentPart.toString());
        }

        // Mengembalikan daftar bagian-bagian ekspresi.
        return parts;
    }

    /**
     * Metode untuk mengisi array operandsHandler dan operations dari daftar bagian-bagian ekspresi.
     * 
     * @param parts           List<String> berisi bagian-bagian ekspresi.
     * @param operandsHandler Array double untuk menyimpan operand numerik.
     * @param operations      Array String untuk menyimpan operator.
     */
    public static void populateOperandsAndOperations(List<String> parts, double[] operandsHandler, String[] operations) {
        for (int i = 0; i < parts.size(); i++) {
            // Mengisi array operandsHandler dengan operand numerik.
            if (i % 2 == 0) {
                try {
                    operandsHandler[i / 2] = Double.parseDouble(parts.get(i));
                } catch (NumberFormatException e) {
                    System.out.println("Format operand tidak valid");
                    return;
                }
            } else {
                // Mengisi array operations dengan operator.
                operations[i / 2] = parts.get(i);
            }
        }
    }
}
