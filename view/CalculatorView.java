package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import handlers.factorymethod.Operasi;
import handlers.factorymethod.OperasiFactory;
// import model.CalculatorModel;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public double[] getUserInput() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Masukkan ekspresi matematika (atau ketik 'exit' untuk keluar): ");
        String expression = scanner.nextLine();

            if (expression.equalsIgnoreCase("exit")) {
                isRunning = false;
            } else {
                List<String> parts = parseExpression(expression);

                if (parts.size() % 2 == 0) {
                    System.out.println("Format ekspresi tidak valid");
                    continue;
                }

                double[] operandsHandler = new double[(parts.size() + 1) / 2];
                String[] operations = new String[parts.size() / 2];

                populateOperandsAndOperations(parts, operandsHandler, operations);

                Operasi operation = null;
                ArrayList<Double> operands = new ArrayList<>();

                for (String token : parts) {
                    if (token.matches("\\d+\\.?\\d*")) {
                        operands.add(Double.parseDouble(token));
                    } else {
                        operation = handleOperator(operation, operands, token);
                    }
                }

                ResultProcessor.displayResult(operation, operands, operandsHandler, operations);
            }
        }

        scanner.close();
        return null;
    }

    private List<String> parseExpression(String expression) {
    List<String> parts = new ArrayList<>();
    StringBuilder currentPart = new StringBuilder();

    for (char c : expression.toCharArray()) {
        if (Character.isDigit(c) || c == '.') {
            currentPart.append(c);
        } else {
            if (currentPart.length() > 0) {
                parts.add(currentPart.toString());
                currentPart = new StringBuilder();
            }
            parts.add(String.valueOf(c));
        }
    }

    if (currentPart.length() > 0) {
        parts.add(currentPart.toString());
    }

    return parts;
}

    private void populateOperandsAndOperations(List<String> parts, double[] operandsHandler, String[] operations) {
        for (int i = 0; i < parts.size(); i++) {
            if (i % 2 == 0) {
                try {
                    operandsHandler[i / 2] = Double.parseDouble(parts.get(i));
                } catch (NumberFormatException e) {
                    System.out.println("Format operand tidak valid");
                    return;
                }
            } else {
                operations[i / 2] = parts.get(i);
            }
        }
    }

    private Operasi handleOperator(Operasi operation, ArrayList<Double> operands, String token) {
    if (operation == null) {
        operation = OperasiFactory.createOperation(token);
    } else {
        // Memastikan bahwa perkalian dan pembagian diutamakan lebih tinggi daripada penambahan dan pengurangan
        if (token.equals("*") || token.equals("/")) {
            if (operation.equals("+") || operation.equals("-")) {
                operation = OperasiFactory.createOperation(token);
            } else {
                double result = operation.performOperation(operands.stream().mapToDouble(Double::doubleValue).toArray());
                operands.clear();
                operands.add(result);
                operation = OperasiFactory.createOperation(token);
            }
        } else {
            double result = operation.performOperation(operands.stream().mapToDouble(Double::doubleValue).toArray());
            operands.clear();
            operands.add(result);
            operation = OperasiFactory.createOperation(token);
        }
    }
    return operation;
}
    

    
}
