// Menggunakan Chain of Responsibility (Behavioral):
package handler;

public interface CalculatorHandler {
    double handleRequest(double[] operands);
    void setNextHandler(CalculatorHandler nextHandler);
}

/*
Penjelasan:

- 'CalculatorHandler' adalah kelas abstrak yang menerapkan pola desain Chain of Responsibility.
- Memiliki atribut 'nextHandler' yang merupakan handler selanjutnya dalam rantai.
- Metode 'setNextHandler' digunakan untuk mengatur handler berikutnya dalam rantai.
- 'handleRequest' adalah metode abstrak yang akan diimplementasikan oleh kelas-kelas turunannya. Metode ini digunakan untuk menangani permintaan perhitungan, dan setiap handler dapat memutuskan apakah akan menangani permintaan tersebut atau meneruskannya ke handler berikutnya dalam rantai.
 */