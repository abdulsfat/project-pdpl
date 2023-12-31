// Kelas ini merupakan implementasi dari antarmuka Operasi untuk operasi perkalian.

package operation;

public class OperasiPerkalian implements Operasi {
    // Metode performOperation untuk melakukan operasi perkalian pada array operand.
    @Override
    public double performOperation(double[] operands) {
        // Inisialisasi hasil dengan nilai operand pertama.
        double result = operands[0];

        // Melakukan operasi perkalian untuk setiap operand berikutnya.
        for (int i = 1; i < operands.length; i++) {
            result *= operands[i];
        }

        // Mengembalikan hasil operasi perkalian.
        return result;
    }
}


/*
Penjelasan:

- 'OperasiPerkalian' adalah kelas konkrit yang mengimplementasikan antarmuka Operation.
- Metode 'performOperation' diimplementasikan untuk melakukan operasi perkalian ('*')
- Dalam hal ini, kelas ini bertindak sebagai produsen dari operasi perkalian.
- Penerapan Factory Method memungkinkan penciptaan objek 'OperasiPerkalian' tanpa harus mengungkapkan detail implementasinya, dan dapat dipergunakan melalui antarmuka Operation.
 */