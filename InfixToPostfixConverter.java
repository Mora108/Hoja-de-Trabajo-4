import java.util.Stack;

class InfixToPostfixConverter {
    
    // Función para retornar la precedencia de los operadores
    private int prec(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        }; // Potencia (asociatividad derecha)
        // Multiplicación y división (asociatividad izquierda)
        // Suma y resta (asociatividad izquierda)
        // Caracter no reconocido
    }

    // Función para convertir una expresión infix a postfix
    public String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Si el caracter es un operando (número o letra), lo agregamos al resultado
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // Si el caracter es un paréntesis de apertura, lo apilamos
            else if (c == '(') {
                st.push(c);
            }
            // Si el caracter es un paréntesis de cierre, desapilamos hasta encontrar '('
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop(); // Desapilamos '('
                } else {
                    throw new IllegalArgumentException("Expresión mal formada: paréntesis desbalanceados");
                }
            }
            // Si es un operador
            else {
                while (!st.isEmpty() && (prec(c) < prec(st.peek()) ||
                                         (prec(c) == prec(st.peek()) && c != '^'))) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        // Desapilamos los operadores restantes
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                throw new IllegalArgumentException("Expresión mal formada: paréntesis desbalanceados");
            }
            result.append(st.pop());
        }

        return result.toString();
    }

    // Método de prueba
    public static void main(String[] args) {
        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        
        // Casos de prueba
        String[] testCases = {
            "a+b*(c^d-e)^(f+g*h)-i",  // Caso con paréntesis y operadores
            "(3+4)*5",                // Caso numérico con paréntesis
            "3+4*5",                  // Caso numérico sin paréntesis
            "a+b*c",                  // Expresión básica
            "a*b+c",                  // Expresión con orden de operaciones distinto
            "(a+b)*(c+d)",            // Expresión con varios paréntesis
            "a+b*(c-d)",              // Expresión con multiplicación dentro de paréntesis
            "((a+b)*c)-d",            // Expresión con múltiples niveles de paréntesis
            "(a+b"                    // Expresión con error (paréntesis desbalanceados)
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