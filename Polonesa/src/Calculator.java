import java.util.Stack;

public class Calculator {
    public double evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    if (stack.size() < 2) throw new IllegalArgumentException("Operação inválida.");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    if (stack.size() < 2) throw new IllegalArgumentException("Operação inválida.");
                    double subtrator = stack.pop();
                    stack.push(stack.pop() - subtrator);
                    break;
                case "*":
                    if (stack.size() < 2) throw new IllegalArgumentException("Operação inválida.");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    if (stack.size() < 2) throw new IllegalArgumentException("Operação inválida.");
                    double divisor = stack.pop();
                    if (divisor == 0) throw new ArithmeticException("Divisão por zero.");
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    try {
                        stack.push(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Token inválido: " + token);
                    }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expressão inválida.");
        }

        return stack.pop();
    }
}