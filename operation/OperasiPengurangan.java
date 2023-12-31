// Menggunakan Factory Method (Creational)
package operation;

public class OperasiPengurangan implements Operasi {
    // Implementasi metode performOperation untuk operasi pengurangan
    @Override
    public double performOperation(double[] operands) {
        double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result -= operands[i];
        }
        return result;
    }
}

/*
Penjelasan:

- 'SubtractionOperation' adalah kelas konkrit yang mengimplementasikan antarmuka Operation.
- Metode 'performOperation' diimplementasikan untuk melakukan operasi pengurangan ('-') pada dua angka.
- Dalam hal ini, kelas ini bertindak sebagai produsen dari operasi pengurangan.
- Penerapan Factory Method memungkinkan penciptaan objek 'SubtractionOperation' tanpa harus mengungkapkan detail implementasinya, dan dapat dipergunakan melalui antarmuka Operation.
 */