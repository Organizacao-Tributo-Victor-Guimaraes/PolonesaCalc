import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão em Notação Polonesa Inversa:");
        String expression = scanner.nextLine();

        try {
            double result = calculator.evaluate(expression);
            System.out.println("Resultado: " + result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }
}