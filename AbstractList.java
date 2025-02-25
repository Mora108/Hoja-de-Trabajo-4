/**
 * Clase abstracta que implementa la interfaz IList.
 * Proporciona una implementación básica del método isEmpty.
 *
 * @param <T> el tipo de los elementos en la lista
 */
public abstract class AbstractList<T> implements IList<T> {

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false de lo contrario
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
