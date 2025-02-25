public class DoublyLinkedList<T> extends AbstractList<T> {
    private class Node {
        T data;
        Node next, prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size = 0;

    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head != null) head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        size--;
        return data;
    }

    public T getFirst() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        return head.data;
    }

    public int size() {
        return size;
    }
}