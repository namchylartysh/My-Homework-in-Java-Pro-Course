package algorythms;

public class LowArray {
    private long[] a;  // поле массива

    public LowArray(int size) {   // конструктор который принимает размер массива и создает массив
        a = new long[size];   // выделяем память для массива
    }

    public void setElem(int index, long value) {  // добавляем элементы
        a[index] = value;
    }

    public long getElem(int index) { // получаем элемент по индексу
        return a[index];
    }
}
