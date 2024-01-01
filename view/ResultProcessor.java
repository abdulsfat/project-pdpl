package view;

import handlers.factorymethod.Operasi;
import java.util.ArrayList;

import model.CalculatorModel;

public class ResultProcessor {
    public static void displayResult(Operasi operation, ArrayList<Double> operands, double[] operandsHandler, String[] operations) {
        if (operation != null) {
            double resultFactory = operation.performOperation(operands.stream().mapToDouble(Double::doubleValue).toArray());
            System.out.println("Hasil operasi Menggunakan Factory Method: " + resultFactory);

            CalculatorModel calculatorModel = new CalculatorModel();
            double resultHandler = calculatorModel.calculate(operandsHandler, operations);
            System.out.println("Hasil operasi Menggunakan Handler: " + resultHandler);

        } else {
            System.out.println("Tidak ada operasi menggunakan Factory Method.");
        }
    }
}