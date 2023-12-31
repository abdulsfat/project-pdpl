// Menggunakan Factory Method (Creational)
package operation;

public class OperasiPertambahan implements Operasi {
    @Override
    public double performOperation(double[] operands) {
        double result = 0;
        for (double operand : operands) {
            result += operand;
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