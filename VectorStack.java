import java.util.Vector;

public class VectorStack<T> extends AbstractStack<T> {
    private Vector<T> stack;

    public VectorStack() {
        stack = new Vector<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack vacío");
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack vacío");
        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }
}