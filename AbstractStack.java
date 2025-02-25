/**
 * Clase abstracta que implementa la interfaz IStack.
 * Proporciona una implementación básica del método isEmpty.
 *
 * @param <T> el tipo de los elementos en la pila
 */
public abstract class AbstractStack<T> implements IStack<T> {

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
