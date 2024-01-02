import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

/**
 * Kelas utama untuk memulai aplikasi kalkulator.
 */
public class Main {
    public static void main(String[] args) {
        // Membuat instance dari model, view, dan controller
        CalculatorModel model = new CalculatorModel(); // Instance dari CalculatorModel untuk mengelola data dan perhitungan.

        CalculatorView view = new CalculatorView(); // Instance dari CalculatorView untuk menangani antarmuka pengguna.

        CalculatorController controller = new CalculatorController(model, view);
        // Instance dari CalculatorController, dengan model dan view sebagai parameter.
        // Controller berperan sebagai perantara antara model dan view, menangani input pengguna, dan memperbarui model dan view.

        // Menjalankan aplikasi kalkulator
        controller.run();
        // Memanggil metode run() pada controller untuk memulai aplikasi kalkulator.
        // Metode run() di dalam CalculatorController akan memulai loop utama di mana controller menunggu input pengguna, memprosesnya, dan mengupdate model dan view sesuai kebutuhan.
    }
}
