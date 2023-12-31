// Menggunakan Factory Method (Creational)
package operation;

public class OperasiPembagian implements Operasi {
    @Override
    public double performOperation(double[] operands) {
        if (operands.length == 0) {
            throw new IllegalArgumentException("Tidak ada operand untuk melakukan operasi pembagian.");
        }

        double result = operands[0];

        for (int i = 1; i < operands.length; i++) {
            if (operands[i] == 0) {
                throw new ArithmeticException("Pembagian oleh nol tidak diizinkan.");
            }
            result /= operands[i];
        }

        return result;
    }
}

/*
Penjelasan:

- 'AdditionOperation' adalah kelas konkrit yang mengimplementasikan antarmuka 'Operation'.
- Metode 'performOperation' diimplementasikan untuk melakukan operasi penambahan ('+') pada dua angka.
- Dalam hal ini, kelas ini bertindak sebagai produsen dari operasi penambahan.
- Penerapan Factory Method memungkinkan penciptaan objek 'AdditionOperation' tanpa harus mengungkapkan detail implementasinya, dan dapat dipergunakan melalui antarmuka 'Operation'.
 */