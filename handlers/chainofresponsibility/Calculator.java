package handlers.chainofresponsibility;
// // Kalkulator menggunakan pola Chain of Responsibility
// class Calculator {
//     private CalculationHandler handlerChain;

//     public Calculator() {
//         this.handlerChain = new AddHandler(new SubtractHandler(new MultiplyHandler(new DivideHandler(null))));
//     }

//     public double calculate(double[] operands, String[] operations) {
//         // Memastikan panjang operasi satu kurang dari panjang operan
//         if (operations.length != operands.length - 1) {
//             System.out.println("Format ekspresi tidak valid");
//             return 0;
//         }

//         double result = operands[0];

//         for (int i = 0; i < operations.length; i++) {
//             result = handlerChain.handleRequest(result, operands[i + 1], operations[i]);
//         }

//         return result;
//     }
// }
