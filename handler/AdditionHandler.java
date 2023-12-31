// // Menggunakan Chain of Responsibility (Behavioral):
// package handler;

// public class AdditionHandler extends CalculatorHandler {
//     // Implementasi metode handleRequest untuk penanganan operasi penambahan
//     @Override
//     public double handleRequest(char operator, double[] operands) {
//         // Jika operator adalah '+', maka penanganan dilakukan di sini
//         if (operator == '+') {
//             return performAddition(operands);
//         } else if (nextHandler != null) {
//             // Jika tidak, dan handler berikutnya ada, meneruskan permintaan ke handler berikutnya
//             return nextHandler.handleRequest(operator, operands);
//         }
//         // Jika tidak ada handler yang dapat menangani, lempar pengecualian
//         throw new IllegalArgumentException("Invalid operation");
//     }

//     // Metode khusus untuk menangani operasi penambahan
//     private double performAddition(double[] operands) {
//         double result = 0;
//         for (double operand : operands) {
//             result += operand;
//         }
//         return result;
//     }
// }

// /*
// Penjelasan:

// - 'AdditionHandler' adalah kelas turunan dari CalculatorHandler yang mengimplementasikan penanganan operasi penambahan.
// - Metode 'handleRequest' diimplementasikan untuk menangani operasi penambahan (+).
// - Jika operator adalah '+', maka penanganan dilakukan di sini dengan mengembalikan hasil penambahan dari 'num1' dan 'num2'.
// - Jika operator tidak sama dengan '+', dan handler berikutnya dalam rantai ada ('nextHandler != null'), maka permintaan diteruskan ke handler berikutnya dengan memanggil 'nextHandler.handleRequest'.
// - Jika tidak ada handler yang dapat menangani, lempar pengecualian 'IllegalArgumentException' dengan pesan "Invalid operation".
//  */