package homework14;


import java.util.HashMap;
import java.util.Map;


public class HashTable<K, V> {
    private int capacity = 4;
    private Entry<K, V>[] table = new Entry[capacity];
    private int size = 0;

    public void put(K key, V value) {
        int hash = key.hashCode();
        Entry<K, V> entry = new Entry<>(hash, key, value);
        int idx = hash & (capacity - 1);
        System.out.println(idx);
        if(table[idx] == null) {
            table[idx] = entry;
        } else {
            Entry<K, V> pointer = table[idx];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = entry;
        }
        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int idx = hash & (capacity - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry<K, V> pointer = table[idx];
        do {
            if (pointer.key.equals(key)) {
                return pointer.value;
            }
            pointer = pointer.next;
        } while (pointer != null);
        return null;
    }

    public V remove(K key) {
        int hash = key.hashCode();
        int idx = hash & (capacity - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry<K, V> pointer = table[idx];
        do {
            if (pointer.next != null) {
                if (pointer.next.key.equals(key)) {
                    return pointer.next.value;
                }
                pointer.next = null;
                pointer.prev = table[idx];
                if (pointer.prev.key.equals(key)) {
                    return pointer.prev.value;
                }
                pointer.prev = null;
                pointer.next = table[idx];
            } else {
                return pointer.value;
            }
            table[idx] = null;
        } while (pointer.key.equals(key));
        return null;
    }



    @Override
    public String toString() {
        int counter = 0;
        StringBuilder sb = new StringBuilder("{");
        for (Entry<K, V> entry : table) {
            if(entry != null) {
                Entry<K, V> pointer = entry;
                do {
                    sb.append(pointer.key + "=" + pointer.value);
                    counter++;
                    if (counter < size) {
                        sb.append(", ");
                    }
                    pointer = pointer.next;
                } while (pointer != null);
            }
        }
        return sb.append("}").toString();
    }


    private class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;
        Entry<K, V> prev;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
