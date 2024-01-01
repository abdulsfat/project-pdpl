package controller;

import handlers.factorymethod.Operasi;
import model.CalculatorModel;
import view.CalculatorView;
import view.ResultProcessor;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        double[] operands = view.getUserInput();

        if (operands != null) {
            Operasi operation = model.getOperation();
            String[] operations = model.getOperations();

            ResultProcessor.displayResult(operation, null, operands, operations);
        }
    }
}
