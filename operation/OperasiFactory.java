// OperationFactory.java
package operation;

public class OperasiFactory {
    public static Operasi createOperation(String operator) {
        switch (operator) {
            case "+":
                return new OperasiPertambahan();
            case "-":
                return new OperasiPengurangan();
            case "*":
                return new OperasiPerkalian();
            case "/":
                return new OperasiPembagian();
            // Tambah operasi yang lain
            default:
                throw new IllegalArgumentException("Invalid operation: " + operator);
        }
    }
}



/*
Penjelasan:

- 'OperationFactory' adalah kelas yang bertindak sebagai pembuat objek operasi.
- Metode 'createOperation' menerima karakter operator dan menggunakan switch untuk menentukan jenis operasi yang sesuai.
- Jika operator adalah '+', maka kembalikan objek 'AdditionOperation'.
- Jika operator adalah '-', maka kembalikan objek 'SubtractionOperation'.
- Jika operator tidak valid, lempar pengecualian 'IllegalArgumentException'.
 */