// Kelas ini merupakan implementasi dari antarmuka Operasi untuk operasi pengurangan.

package operation;

public class OperasiPengurangan implements Operasi {
    // Metode performOperation untuk melakukan operasi pengurangan pada array operand.
    @Override
    public double performOperation(double[] operands) {
        // Inisialisasi hasil dengan nilai operand pertama.
        double result = operands[0];

        // Melakukan operasi pengurangan untuk setiap operand berikutnya.
        for (int i = 1; i < operands.length; i++) {
            result -= operands[i];
        }

        // Mengembalikan hasil operasi pengurangan.
        return result;
    }
}
/*
Penjelasan:
- 'OperasiPengurangan' adalah kelas konkrit yang mengimplementasikan antarmuka Operation.
- Metode 'performOperation' diimplementasikan untuk melakukan operasi pengurangan ('-').
- Dalam hal ini, kelas ini bertindak sebagai produsen dari operasi pengurangan.
- Penerapan Factory Method memungkinkan penciptaan objek 'OperasiPengurangan' tanpa harus mengungkapkan detail implementasinya, dan dapat dipergunakan melalui antarmuka Operation.
 */