import java.util.Stack;

class PostfixEvaluator {
    
    // Función para evaluar una expresión en notación postfix
    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Si es un número, lo convertimos a entero y lo apilamos
            if (Character.isDigit(c)) {
                stack.push(c - '0');  // Convierte el char numérico a entero
            }
            // Si es un operador, sacamos dos operandos de la pila y realizamos la operación
            else {
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
                    // Potencia
                    default -> throw new IllegalArgumentException("Operador desconocido: " + c);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión postfix mal formada");
        }

        return stack.pop(); // El resultado final queda en la cima de la pila
    }

    // Método de prueba
    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();

        // Casos de prueba
        String[] testCases = {
            "34+5*",    // (3+4)*5 = 35
            "345*+",    // 3 + (4*5) = 23
            "82/4+",    // (8/2) + 4 = 8
            "34+2^",    // (3+4)^2 = 49
            "92-3*",    // (9-2)*3 = 21
            "23^"       // 2^3 = 8
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