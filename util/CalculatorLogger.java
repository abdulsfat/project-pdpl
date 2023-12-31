package util;

// Menggunakan Singleton untuk CalculatorLogger
public class CalculatorLogger {
    // Singleton instance
    private static CalculatorLogger instance;

    // Private constructor to prevent instantiation
    private CalculatorLogger() {
        // private constructor to prevent instantiation
    }

    // Mendapatkan instance Singleton CalculatorLogger
    public static CalculatorLogger getInstance() {
        // Jika instance belum dibuat, buat instance baru
        if (instance == null) {
            instance = new CalculatorLogger();
        }
        // Mengembalikan instance Singleton CalculatorLogger
        return instance;
    }

    // Metode untuk mencatat pesan log
    public void log(String message) {
        // Mencetak pesan log ke konsol
        System.out.println("Log: " + message);
    }
}

/*
Penjelasan:

Code ini adalah sebuah kelas utilitas yang dibuat untuk memproses ekspresi catatan pesan (Log).
- 'CalculatorLogger' adalah kelas utilitas yang dirancang dengan pola desain Singleton.
- Hanya ada satu instance dari kelas ini yang dapat dibuat.
- Konstruktor kelas ini bersifat private, sehingga tidak dapat diakses dari luar kelas.
- 'getInstance' adalah metode statis yang digunakan untuk mendapatkan instance tunggal dari kelas. Jika instance belum dibuat, maka instance baru akan dibuat; jika sudah ada, instance yang sudah ada akan dikembalikan.
- 'log' adalah metode untuk mencatat pesan log ke konsol.
- Penggunaan Singleton di sini memastikan bahwa hanya ada satu objek 'CalculatorLogger' yang digunakan dalam aplikasi.

 */