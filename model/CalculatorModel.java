package model;
import handlers.chainofresponsibility.AddHandler;
import handlers.chainofresponsibility.CalculationHandler;
import handlers.chainofresponsibility.DivideHandler;
import handlers.chainofresponsibility.MultiplyHandler;
import handlers.chainofresponsibility.SubtractHandler;
import handlers.factorymethod.Operasi;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// tambahkan ini
// CalculatorModel.java
public class CalculatorModel {
    private CalculationHandler handlerChain;
    private Operasi currentOperation; // Menyimpan informasi operasi terkini
    private List<String> currentOperations; // Menyimpan informasi operasi-operasi terkini

    public CalculatorModel() {
        this.handlerChain = new AddHandler(new SubtractHandler(new MultiplyHandler(new DivideHandler(null))));
        this.currentOperation = null;
        this.currentOperations = new ArrayList<>();
    }

    public double calculate(double[] operands, String[] operations) {
        // Memastikan panjang operasi satu kurang dari panjang operan
        if (operations.length != operands.length - 1) {
            System.out.println("Format ekspresi tidak valid");
            return 0;
        }

        double result = operands[0];

        for (int i = 0; i < operations.length; i++) {
            result = handlerChain.handleRequest(result, operands[i + 1], operations[i]);
        }

        // Menyimpan informasi operasi terkini
        // this.currentOperation = handlerChain.getCurrentOperation();
        this.currentOperations = Arrays.asList(operations);

        return result;
    }
// Mendapatkan operasi-operasi terkini
    public CalculationHandler getHandlerChain() {
        return this.handlerChain;
    }
    // Mendapatkan operasi terkini
    public Operasi getOperation() {
        return this.currentOperation;
    }

    // Mendapatkan operasi-operasi terkini
    public String[] getOperations() {
        return this.currentOperations.toArray(new String[0]);
    }
    
}

