import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

/**
 * Main class to start the calculator application.
 */
public class Main {
    public static void main(String[] args) {
        // Create instances of the model, view, and controller
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        // Run the calculator application
        controller.run();
    }
}
