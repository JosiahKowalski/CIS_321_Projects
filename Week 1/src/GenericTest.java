public class GenericTest<T> {
    private T type;

    public GenericTest(T type) {
        this.type = type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }
}
