import java.util.Stack;

/**
 * Clase para convertir expresiones infijas a postfijas.
 */
class InfixToPostfixConverter {

    /**
     * Retorna la precedencia de los operadores.
     *
     * @param c el operador
     * @return la precedencia del operador
     */
    private int prec(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    /**
     * Convierte una expresión infija a postfija.
     *
     * @param s la expresión infija
     * @return la expresión en notación postfija
     */
    public String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    throw new IllegalArgumentException("Expresión mal formada: paréntesis desbalanceados");
                }
            } else {
                while (!st.isEmpty() && (prec(c) < prec(st.peek()) ||
                                         (prec(c) == prec(st.peek()) && c != '^'))) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                throw new IllegalArgumentException("Expresión mal formada: paréntesis desbalanceados");
            }
            result.append(st.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InfixToPostfixConverter converter = new InfixToPostfixConverter();

        String[] testCases = {
            "a+b*(c^d-e)^(f+g*h)-i",
            "(3+4)*5",
            "3+4*5",
            "a+b*c",
            "a*b+c",
            "(a+b)*(c+d)",
            "a+b*(c-d)",
            "((a+b)*c)-d",
            "(a+b"
        };

        for (String expr : testCases) {
            try {
                System.out.println("Infix: " + expr);
                System.out.println("Postfix: " + converter.infixToPostfix(expr));
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la expresión: " + expr + " -> " + e.getMessage());
            }
        }
    }
}
