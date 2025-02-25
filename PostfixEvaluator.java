import java.util.Stack;

/**
 * Clase para evaluar una expresión en notación postfix.
 */
class PostfixEvaluator {

    /**
     * Evalúa una expresión en notación postfix.
     *
     * @param expression la expresión postfix
     * @return el resultado de la evaluación
     * @throws IllegalArgumentException si la expresión es mal formada
     * @throws ArithmeticException si ocurre un error aritmético, como división por cero
     */
    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión postfix mal formada");
                }

                int b = stack.pop();
                int a = stack.pop();

                switch (c) {
                    case '+' -> stack.push(a + b);
                    case '-' -> stack.push(a - b);
                    case '*' -> stack.push(a * b);
                    case '/' -> {
                        if (b == 0) throw new ArithmeticException("División por cero");
                        stack.push(a / b);
                    }
                    case '^' -> stack.push((int) Math.pow(a, b));
                    default -> throw new IllegalArgumentException("Operador desconocido: " + c);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión postfix mal formada");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();

        String[] testCases = {
            "34+5*",
            "345*+",
            "82/4+",
            "34+2^",
            "92-3*",
            "23^"
        };

        for (String expr : testCases) {
            try {
                System.out.println("Postfix: " + expr);
                System.out.println("Evaluación: " + evaluator.evaluatePostfix(expr));
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error evaluando " + expr + ": " + e.getMessage());
            }
        }
    }
}
