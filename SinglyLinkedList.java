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

    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        T data = head.data;
        head = head.next;
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