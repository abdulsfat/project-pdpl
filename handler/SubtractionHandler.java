// // Menggunakan Chain of Responsibility (Behavioral):
// package handler;

// public class SubtractionHandler extends CalculatorHandler {
//     // Implementasi metode handleRequest untuk penanganan operasi pengurangan
//     @Override
//     public double handleRequest(double[] operands) {
//         // Jika operator adalah '-', maka penanganan dilakukan di sini
//         if (operator == '-') {
//             return num1 - num2;
//         } else if (nextHandler != null) {
//             // Jika tidak, dan handler berikutnya ada, meneruskan permintaan ke handler berikutnya
//             return nextHandler.handleRequest(operator, num1, num2);
//         }
//         // Jika tidak ada handler yang dapat menangani, lempar pengecualian
//         throw new IllegalArgumentException("Invalid operation");
//     }
// }

// /*
// Penjelasan:

// - 'SubtractionHandler' adalah kelas turunan dari 'CalculatorHandler' yang mengimplementasikan penanganan operasi pengurangan.
// - Metode 'handleRequest' diimplementasikan untuk menangani operasi pengurangan ('-').
// - Jika operator adalah '-', maka penanganan dilakukan di sini dengan mengembalikan hasil pengurangan dari 'num1' dan 'num2'.
// - Jika operator tidak sama dengan '-', dan handler berikutnya dalam rantai ada ('nextHandler != null'), maka permintaan diteruskan ke handler berikutnya dengan memanggil 'nextHandler.handleRequest'.
// - Jika tidak ada 'handler' yang dapat menangani, lempar pengecualian 'IllegalArgumentException' dengan pesan "Invalid operation".
//  */