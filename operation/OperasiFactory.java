// Kelas ini bertanggung jawab untuk menciptakan objek operasi matematika berdasarkan operator yang diberikan.

package operation;

public class OperasiFactory {
    // Metode ini menerima operator dalam bentuk string dan mengembalikan objek operasi yang sesuai.
    public static Operasi createOperation(String operator) {
        // Menggunakan struktur switch case untuk menentukan operasi berdasarkan operator.
        switch (operator) {
            case "+":
                // Jika operator adalah "+", kembalikan objek OperasiPertambahan.
                return new OperasiPertambahan();
            case "-":
                // Jika operator adalah "-", kembalikan objek OperasiPengurangan.
                return new OperasiPengurangan();
            case "*":
                // Jika operator adalah "*", kembalikan objek OperasiPerkalian.
                return new OperasiPerkalian();
            case "/":
                // Jika operator adalah "/", kembalikan objek OperasiPembagian.
                return new OperasiPembagian();
            // Tambahkan case untuk operasi matematika lain jika diperlukan.
            default:
                // Jika operator tidak valid, lempar pengecualian dengan pesan yang sesuai.
                throw new IllegalArgumentException("Invalid operation: " + operator);
        }
    }
}


/*
Penjelasan:

- 'OperasiFactory' adalah kelas yang bertindak sebagai pembuat objek operasi.
- Metode 'createOperation' menerima karakter operator dan menggunakan switch untuk menentukan jenis operasi yang sesuai.
- Jika operator adalah '+', maka kembalikan objek 'OperasiPertambahan'.
- Jika operator adalah '-', maka kembalikan objek 'OperasiPengurangan'.
- Jika operator adalah '*', maka kembalikan objek 'OperasiPerkalian'.
- Jika operator adalah '/', maka kembalikan objek 'OperasiPembagian'.
- Jika operator tidak valid, lempar pengecualian 'IllegalArgumentException'.
 */