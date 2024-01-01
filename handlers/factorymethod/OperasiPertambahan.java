// Kelas ini merupakan implementasi dari antarmuka Operasi untuk operasi pertambahan.

package handlers.factorymethod;

public class OperasiPertambahan implements Operasi {
    // Metode performOperation untuk melakukan operasi pertambahan pada array operand.
    @Override
    public double performOperation(double[] operands) {
        // Inisialisasi hasil dengan nilai awal 0.
        double result = 0;

        // Melakukan operasi pertambahan untuk setiap operand.
        for (double operand : operands) {
            result += operand;
        }

        // Mengembalikan hasil operasi pertambahan.
        return result;
    }
    
}


/*
Penjelasan:

- 'OperasiPertambahan' adalah kelas konkrit yang mengimplementasikan antarmuka 'Operation'.
- Metode 'performOperation' diimplementasikan untuk melakukan operasi penambahan ('+') pada dua angka.
- Dalam hal ini, kelas ini bertindak sebagai produsen dari operasi penambahan.
- Penerapan Factory Method memungkinkan penciptaan objek 'OperasiPertambahan' tanpa harus mengungkapkan detail implementasinya, dan dapat dipergunakan melalui antarmuka 'Operation'.
 */