// Kelas ini merupakan implementasi dari antarmuka Operasi untuk operasi pembagian.

package operation;

public class OperasiPembagian implements Operasi {
    // Metode performOperation untuk melakukan operasi pembagian pada array operand.
    @Override
    public double performOperation(double[] operands) {
        // Memeriksa apakah terdapat cukup operand untuk melakukan operasi pembagian.
        if (operands.length == 0) {
            throw new IllegalArgumentException("Tidak ada operand untuk melakukan operasi pembagian.");
        }

        // Inisialisasi hasil dengan nilai operand pertama.
        double result = operands[0];

        // Melakukan operasi pembagian untuk setiap operand berikutnya.
        for (int i = 1; i < operands.length; i++) {
            // Memeriksa apakah operand yang akan dibagi adalah nol.
            if (operands[i] == 0) {
                // Jika ya, lempar pengecualian ArithmeticException.
                throw new ArithmeticException("Pembagian oleh nol tidak diizinkan.");
            }

            // Melakukan operasi pembagian.
            result /= operands[i];
        }

        // Mengembalikan hasil operasi pembagian.
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