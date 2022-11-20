package homework6;

public class RubberArray<V> {
    private V[] array;

    public V get(int idx) {
        return array[idx];
    }

    public void set(int idx, V item) {
        if (array != null) {
            array[idx] = item;
        }
    }

    public int size() {
        if (array != null) {
            return array.length;
        }
        return 0;
    }

    public void add(V item) {
        if (array == null) {
            array = (V[]) new Object[0];
        }
        V[] newArray = (V[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length); // у меня и без скопирования старого массива выводит [12, 3, 5]
        newArray[array.length] = item;
        array = newArray;
    }

    public void addAll(V... items) {
        for (V item : items) {
            add(item);
        }
    }

    public boolean remove(V item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void remove(int idx) {
        if (array != null && array.length > 0) {
            V[] newArray = (V[]) new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, idx);
            System.arraycopy(array, idx + 1, newArray, idx, newArray.length - idx);
            array = newArray;
        }
    }

    public boolean contains(V item) {
        for (V v : array) {
            if (v.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public V[] toArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // if (array != null) { у меня без этого условия работает, с ним же наоборот выдает ошибку
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                    sb.append(", ");
            }
        }
        // }

        sb.append("]");
        return sb.toString();
    }
}
