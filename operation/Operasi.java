// Menggunakan Factory Method (Creational):
package operation;

public interface Operasi {
    // Metode performOperation untuk melakukan operasi pada array operand
     double performOperation(double[] operands);
}

/*
Penjelasan:

- 'Operasi' adalah antarmuka (interface) yang mewakili konsep Factory Method.
- interface ini mendefinisikan metode 'performOperation' yang akan diimplementasikan oleh kelas-kelas operasi konkretnya.
- Melalui antarmuka ini, setiap operasi (penambahan, pengurangan, dll.) akan memiliki implementasi khusus untuk melakukan operasinya sendiri.
- Pola desain Factory Method digunakan di sini untuk memungkinkan penciptaan objek operasi tanpa harus mengungkapkan detail implementasinya di level yang lebih tinggi.
 */