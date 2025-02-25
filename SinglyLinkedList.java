/**
 * Implementación de una lista ligada simple.
 *
 * @param <T> el tipo de los elementos en la lista
 */
public class SinglyLinkedList<T> extends AbstractList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size = 0;

    /**
     * Agrega un elemento al inicio de la lista.
     *
     * @param item el elemento a agregar
     */
    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Elimina el primer elemento de la lista.
     *
     * @return el elemento eliminado
     * @throws IllegalStateException si la lista está vacía
     */
    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Obtiene el primer elemento de la lista.
     *
     * @return el primer elemento
     * @throws IllegalStateException si la lista está vacía
     */
    public T getFirst() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        return head.data;
    }

    /**
     * Obtiene el tamaño de la lista.
     *
     * @return el número de elementos en la lista
     */
    public int size() {
        return size;
    }
}
