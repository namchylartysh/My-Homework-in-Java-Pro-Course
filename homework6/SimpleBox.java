package homework6;

public class SimpleBox<V extends Number> {
    private V object;

    public SimpleBox(V object) {
        this.object = object;
    }

    public V getObject() {
        return object;
    }

    public void setObject(V object) {
        this.object = object;
    }
}
