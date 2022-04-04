import java.util.LinkedList;

public class MyStack<T> {
    LinkedList<T> stack = new LinkedList<>();

    public void push(T e) {
        stack.add(e);
    }

    public T pop() {
        T removed;
        int lastI = stack.size() - 1;
        removed = stack.get(lastI);
        stack.remove(lastI);
        return removed;
    }

}
