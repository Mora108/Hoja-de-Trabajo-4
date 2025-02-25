import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {
    private ArrayList<T> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
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