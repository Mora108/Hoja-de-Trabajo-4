public abstract class AbstractList<T> implements IList<T> {
    public boolean isEmpty() {
        return size() == 0;
    }
}