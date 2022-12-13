package algorythms;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String[] array;
    private int nElems;

    public Human(int max) {
        array = new String[max];
        nElems = 0;
    }

    public String getIndex(int index) {
        return array[index];
    }

    public String getValue(String value) {
        return value;
    }

    public boolean find(String searchKey) {
        for (int i = 0; i < nElems; i++) {
            if (Objects.equals(array[i], searchKey)) return true;
        }
        return false;
    }

    public int findIndex(String value) {
        for (int i = 0; i < nElems; i++) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(String value) {
        if (array.length < nElems) {
            String[] temp = array;
            array = new String[array.length + 1];
            copyArray(temp);
        }
        array[nElems] = value;
        nElems++;
    }

    private void copyArray(String[] temp) {
        System.arraycopy(temp, 0, array, 0, temp.length);
    }

    public boolean delete(String value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if(Objects.equals(value, array[i])) {
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    public void sortArray() {
        String[] a = new String[nElems];
        int size = a.length;
        if (a.length != 0) {
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i].compareTo(a[j]) > 0) {
                        String temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
                System.out.println(Arrays.toString(a));
            }
        }

    }
/*
    public void sort() {
        String temp;
        for (int i = 0; i < nElems; i++) {
            for (int j = 0; j < nElems; j++) {
                if(array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /*
    public void add(String element) {
        if (array == null) {
            array = new String[] {};
        }
        String[] newArray = new String[][array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        array = newArray;
    }

     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(array != null) {
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i != array.length - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
