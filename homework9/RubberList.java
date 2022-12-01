package homework9;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class RubberList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public void push(T value) {
        add(value);
    }

    public T pop() {
        T value = getLast();
        if (size == 1) {
            first = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return value;
    }

    public T getFirst() {
        return first ==null? null : first.value;
    }

    public T getLast() {
        return last == null? getFirst() : last.value;
    }

    public void add(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
        } else if (last == null) {
            last = new Node<>(value, first, null);
            first.next = last;
        } else {
            Node<T> newLast = new Node<>(value, last, null);
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    public void addAll(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    public boolean remove(T value) {
        if (first != null) {
            Node<T> cursor = first;
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
        if (size == 1) {
            last = null;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private Node<T> cursor = first;
        private T value;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            value = cursor.value;
            cursor = cursor.next;
            return value;
        }

        @Override
        public void remove() {
            if (value != null) {
                RubberList.this.remove(value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (first != null) {
            Node<T> cursor = first;
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

    private class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;
        T element;

        public Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
        public Node(T element) {
            this.element = element;
        }
    }

    private class RubberListQueue<T> implements Queue<T> {
        private Node<T> head;
        private Node<T> tail;

        public RubberListQueue(Node<T> head, Node<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public int size() {
            return RubberList.this.size();
        }

        @Override
        public boolean isEmpty() {
            return head == null;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return (Iterator<T>) new Itr();
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
            return null;
        }

        @Override
        public boolean add(T t) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean offer(T t) {
            return false;
        }

        @Override
        public T remove() {
            return null;
        }

        @Override
        public T poll() {
            return null;
        }

        @Override
        public T element() {
            return null;
        }

        @Override
        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return head.element;
        }
    }
}
