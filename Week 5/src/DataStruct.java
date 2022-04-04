import java.util.ArrayList;

public class DataStruct<T> implements Stack<T>, Queue<T>{
    ArrayList<T> list;
    boolean isStack;
    public DataStruct(boolean isStack){
        list = new ArrayList<>();
        this.isStack = isStack;
    }

    @Override
    public T pop() {
        T removed;
        if (isStack){
            int lastI = list.size() - 1;
            removed = list.get(lastI);
            list.remove(lastI);
        }
        else {
            removed = list.get(0);
            list.remove(0);
        }
        return removed;
    }

    @Override
    public void push(T e) {
        list.add(e);
    }

    @Override
    public String toString() {
        if (isStack){
            return "Stack=" + list;
        }
        else {
            return "Queue=" + list;
        }
    }
}
