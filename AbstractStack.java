public abstract class AbstractStack<T> implements IStack<T> {
    public boolean isEmpty() {
        return size() == 0;
    }
}