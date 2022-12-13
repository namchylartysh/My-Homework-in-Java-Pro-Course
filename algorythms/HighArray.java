package algorythms;

public class HighArray {
    // Задача:
    // Поиск элемента в массиве (ускоренный поиск)
    // Динамическое выделение памяти
    // Сортировка

    private long[] a; // инкапсулируем переменные
    private int nElems; // счетчик элементов, которые мы добавили

    public HighArray(int max) { // создали констурктор
        a = new long[max];   // выделяем память для массива
        nElems = 0;          // счетчик добавленных элементов
    }

    public boolean find(long searchKey) {   // поиск элемента
        // переменная - итератор по массиву
        for (int i = 0; i < nElems; i++) {  // перебираем элементы в цикле
            if (a[i] == searchKey) return true;          // если нашли совпадение выходим из цикла

        }

        return false; //  противном случае возвращаем
    }

    // Пример метода с полной трассировкой его работы
    /*
    public boolean find(long searchKey) {   // поиск элемента
        int i;                              // переменная - итератор по массиву
        for (int i = 0; i < nElems; i++) {// перебираем элементы в цикле
            if (a[i] == searchKey)           // если нашли совпадение выходим из цикла
                break;
                System.out.println("i " + i);
        }
        System.out.println("i after cycle " + i);
        if(i == nElems) {               // если перебрали весь массив возвращаем false
            System.out.println("nElems " + nElems);
            return false;
        }
        else
            return true;                // в противном случае возвращаем
    }
    */

    // поиск индекса элемента по его значению
    public int findIndex(long value) {
        for (int i = 0; i < nElems; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }



    // метод для вставки элемента в массив
    public void insert(long value) {
        if (a.length * 0.8 <= nElems) {    // проверяем нет ли дефицита памяти
            long[] temp = a;                // создаем массив, в котором сохраним старый массив
            a = new long[a.length*2];       // выделяем дополнительный память
            copyArray(temp);                // копируем старый массив в новый массив
            System.out.println("Выделили память");  // выводим сообщение о выделении памяти
        }
        a[nElems] = value; // вставка элемента в позицию
        nElems++; // увеличение счетчика позиций
    }

    private void copyArray(long[] temp) {                // копируем старый массив в новый
        for (int i = 0; i < temp.length; i++) {
            a[i] = temp[i];
        }
    }

    // метод для удаления элемента по значению
    public boolean delete(long value) {
        int i;
        for (i = 0; i < nElems; i++) { // перебираем добавленные элементы
            if(value == a[i]) break;          // если сопвали значения выходим из цикла
        }
        if (i == nElems) { // если перебрали все элементы возвращаем фолс
            return false;
        } else {              // в противном случае
            for (int k = i; k < nElems; k++) { // сдвигаем все элементы после совпадения элементов
                a[k] = a[k + 1]; // сдвиг
            }
            nElems--;  // сокращаем счетчик на единицу
            return true;  // возвращаем true
        }
    }

    public void sort() {      // сортировка пузырьком
        long temp;              // временная переменная, в которой не будем хранить временное значение
        for (int i = 0; i < nElems; i++) {    // Проходим по массиву
            for (int j = 0; j < nElems; j++) {
                if(a[i] < a[j]) {     // если удовлетворено условие выполняем перестановку
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
