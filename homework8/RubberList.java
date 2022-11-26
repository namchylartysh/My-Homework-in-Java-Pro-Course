package homework8;

public class RubberList<T> {
    private int size;
    private Element<T> first;
    private Element<T> last;

    private class Element<T> {
        T value;
        Element<T> previous;
        Element<T> next;

        public Element(T value, Element<T> previous, Element<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    public void add(T value) {
        if (first == null) {
            first = new Element<T>(value, null, null);
        } else if (last == null) {
            last = new Element<T>(value, first, null);
            first.next = last;
        } else {
            Element<T> element = new Element<T>(value, first, null);
            last.next = element;
            last = element;
        }
        size++;
    }

    public boolean remove(T value) {
        if (first != null) {
            Element<T> cursor = first;
            do {
                if (cursor.value.equals(value)) {
                    if (cursor.previous == null) {
                        if (first.next != null) {
                            first = first.next;
                            first.previous = null;
                        } else {
                            first = null;
                        }
                    } else if (cursor.next == null) {
                        last = last.previous;
                        last.next = null;
                    } else {
                        cursor.previous.next = cursor.next;
                        cursor.next.previous = cursor.previous;
                    }
                    return true;
                }
                cursor = cursor.next;
            } while (cursor != null);
        }
        size--;
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (first != null) {
            Element<T> cursor = first;
            do {
                sb.append(cursor.value);
                cursor = cursor.next;
                if (cursor != null) {
                    sb.append(", ");
                }
            } while (cursor != null);
        }
        return sb.append("]").toString();
    }
}
