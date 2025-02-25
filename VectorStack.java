import java.util.Vector;

/**
 * Implementación de la pila utilizando un Vector.
 *
 * @param <T> el tipo de los elementos en la pila
 */
public class VectorStack<T> extends AbstractStack<T> {
    private Vector<T> stack;

    /**
     * Constructor que inicializa el Vector de la pila.
     */
    public VectorStack() {
        stack = new Vector<>();
    }

    /**
     * Agrega un elemento en la cima de la pila.
     *
     * @param item el elemento a agregar
     */
    public void push(T item) {
        stack.add(item);
    }

    /**
     * Elimina y retorna el elemento en la cima de la pila.
     *
     * @return el elemento eliminado
     * @throws IllegalStateException si la pila está vacía
     */
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack vacío");
        return stack.remove(stack.size() - 1);
    }

    /**
     * Retorna el elemento en la cima de la pila sin eliminarlo.
     *
     * @return el elemento en la cima
     * @throws IllegalStateException si la pila está vacía
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack vacío");
        return stack.get(stack.size() - 1);
    }

    /**
     * Obtiene el tamaño de la pila.
     *
     * @return el número de elementos en la pila
     */
    public int size() {
        return stack.size();
    }
}
