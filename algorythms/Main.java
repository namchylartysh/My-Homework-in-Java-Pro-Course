package algorythms;

/**
 * Algorithm Homework #2
 *
 * @author Artysh
 * @version 12.12
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Main {
    public static void main(String[] args) {

        Human human = new Human(10);

        System.out.println(human);
        human.insert("Vladimir");
        human.insert("Alexander");
        human.insert("John");
        human.insert("Victoria");
        human.insert("Maria");
        human.insert("George");
        human.insert("Ann");
        human.insert("Tatiana");
        human.insert("Elon");
        human.insert("Russell");
        System.out.println(human);
        System.out.println(human.find("John"));
        System.out.println(human.find("Mike"));
        human.delete("Russell");
        System.out.println(human);

        System.out.println(human.findIndex("Maria"));

        human.sortArray();




        /*
        HighArray highArray = new HighArray(10);

        highArray.insert(10);
        highArray.insert(21);
        highArray.insert(34);
        highArray.insert(54);
        highArray.insert(85);

        highArray.display();

        System.out.println(highArray.find(85));

        highArray.delete(54);

        highArray.display();

        highArray.sort();

        highArray.display();

        highArray.insert(34);
        highArray.insert(54);
        highArray.insert(85);
        highArray.insert(35);
        highArray.insert(56);
        highArray.display();

        System.out.println(highArray.findIndex(85));
        System.out.println(highArray.findIndex(123));

        int a = 534671;
        for (int i = 0; i < 1000000; i++) {
            System.out.println("Итерация: " + i);
            if(a == i) {
                System.out.println("Нашли");
                break;
            }
        }

        */


    }

    /*
    Заметки
    Вертикальная линия в IntelijIdea - линия 80 символов. По конвенции java в одну строку должно помещаться не более 80
    символов(аналог красной линии в тетрадке).

     */

    /*
    Теория

    1)

       Структура данных - это способ организации данных в памяти, подразумевающий определенный
       алгоритм работы с собой
       Алгоритм - это последовательность действий.
       Массив - структура данных, которая хранит данные в сплошной области памяти( по аналогии с лесным или жилым массивами)
       Массивы позволяют получать доступ к своим элементам по индексу, таким образом зная адрес начала массива достаточно
       просто прибавить к нему количество индексов, умноженное на размер элемеента массива, чтобы вычислить
       адрес требуемого элемемнта.

       Недостаточк массивов - необходимость соблюдения сплошной области в памяти, таким образом для вставки и удаления элемеента
       приходится выполнить большое количество операций

       Последовательность должна быть конечной, т.е. в принципе иметь конец
       и конец это должен наступать за разумный промежуток времени.
       При оценке алгоритма следует обращаться внимание на количество операций, которое необходимо выполнить для решения
       задачи, а не на время за которое он будет выполнен конкретной системой.
       Структура данных подразумевает некий алгоритм работы с собой. Т.е. алгоритмы без структур данных могут существовать,
       структуры данных без алгоритмов существовать не могут.

       Чтобы объявить массив в Java нужно указать его тип, присвоить

       Scanner  - класс для ввода данных
       System  - класс позволяющий управлять системой
       Random -  класс для генерации ПСЕВДОслучайных

Space compexity
Сложность пространства алгоритма - это объем памяти, необходимый алгоритму для выполнения задачи и вывода результатов.

Что усложняет пространство:

Переменные
Структуры данных
Вызовы функций


    Оценивая сложность алгоритма, уместно делать приблизительные расчеты
    Количество шагов для линейного поиска (все возможные варианты)
    1 2     (n-1) n
    n/2 шагов в среднем требуется, чтобы найти искомое значение




     */

    /*
    Задача №1
    Необходимо описать алгоритм вывода на экран монитора наибольшего значения из двух чисел.

псевдокод:

Start
Number input: Z, X
IF Z > X then Conclusion Z
ELSE output X
End

     */

      /*
    Задача №2
   Из 100 чисел вывести каждое число кратное 3

псевдокод:

Start
  Создать цикл от 1 до 100
  if(i%3 == 0)
  Вывести


End

     */


       /*
    Задача №3
     Найти заданный элемент в массиве по значению(линейный поиск)


     псевдокод

       start
        создать массив
         for (по массиву)
         if(заданное число = значению)
         выводим значение
       end

        */

    /*
    Задача №4
      Сортировка пузырьком
    псевдокод
   start
     for(length)                    cравниваем каждый с каждым.
     for(length)
       перемещение
    end

        */





        // Метод main - точка входа с него начинается исполнение программы


        /*
        //Задача 1
        Scanner scanner = new Scanner(System.in);  // Scanner это класс, позволяющий считывать числа с консоли
        int a;                                     // Объявляем целочисленную переменную
        int b;

        char c = 'a';                                    //Символьная переменная

        while(c != 'e') {   // Цикл(второе условие полноты по Тьюрингу)

            System.out.println("Введите число a: ");

            a = scanner.nextInt();                  // переменная scanner имеет набор методов для работы с консолью

            System.out.println("Введите число b: ");

            b = scanner.nextInt();

            if (a > b) {                            // Условное ветвление(одно из условий полноты по Тьюрингу(язык
                // программирования или нет)
                System.out.println("a > b");      // выводим на консоль результат
            } else                                  // Противоположное условие
            {
                System.out.println("a < b");
            }

            System.out.println("Введите слудующую операцию \n" +
                    "e - Выход\n" +
                    "c - Продолжить "  );
            c = scanner.next().charAt(0);    //Считываем первый символ для определения операции
        }

        //Задача 2
         for (int i = 0; i < 101; i++){
             if(i%3 == 0 && i != 0){
                 System.out.print(i + " ");
             }

         }

         System.out.println(); //  Перевод строки

        //Задача 3            Линейный поиск
        int[] arr = new int[10];     // Создаем массив
        for (int i = 0; i < arr.length; i++) {      //  Заполняем массив
                  arr[i] = i;
        }

        for (int i = 0; i < arr.length; i++)
        {
              if(arr[i] == 5){
                  System.out.println(i);
              }
        }

        int d;
        System.out.println("input number a: ");
        a = scanner.nextInt();

        System.out.println("input number b: ");

        b = scanner.nextInt();


        System.out.println("input number d: ");
        d = scanner.nextInt();

        System.out.println(a+b+d);
        //Задача 4           Сортировка пузырьком

        Random random = new Random();             // Генератор псевдослучаных чисел

        for (int i = 0; i < arr.length; i++) {      //  Заполняем массив  псевдослучайными числами
            arr[i] = random.nextInt(10);
            System.out.print(arr[i] + " ");
        }

        System.out.println();
             int temp;                                 // Декларировали переменную для хранения
        for (int i = 0; i < arr.length; i++) {          // Перебор элементов массива в циклах. Для сравнения каждого
                                                       // элемента со всеми элементами
            for (int j = 0; j < arr.length; j++) {
                  if(arr[i] > arr[j]){                // Сравниваем элементы и меняем их местами, если выполняется условие
                      temp = arr[i];
                      arr[i] = arr[j];
                      arr[j] = temp;
                  }
            }
        }

        for (int i = 0; i < arr.length; i++) {           // Выводим массив
            System.out.print(arr[i] + " ");
        }   */

        /*
        int[] abc = {1, 2, 3, 4, 5};
        int[] bca = {11, 11, 9, 9, 17, 2, 2};
        int[] fgd = {1, 1, 3, 3, 8, 8, 9, 10, 10};
        System.out.println(linearSearch(abc, 2));
        System.out.println(findElement(fgd));
    }  */

    /*
    ЛИНЕЙНЫЙ ПОИСК

    Алгоритм
    Шаг 1: Обход массива
    Шаг 2: Сопоставьте ключевой элемент с элементом массива
    Шаг 3: Если ключевой элемент найден, верните позицию индекса элемента массива
    Шаг 4: Если ключевой элемент не найден, верните -1

    Псевдокод:
    Start
    for (обход массива)
    if (сравнение ключевого элемента с элементом массива)
    возвращаем индекс элемента, иначе возвращаем -1
    End
     */

        /*
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    */

    /*
    Find the element that appears once in a sorted array
    Given a sorted array in which all elements appear twice
    (one after one) and one element appears only once.
    Простое решение состоит в обходе массива слева направо.
    Поскольку массив отсортирован, мы легко можем найти нужный элемент.

    Алгоритм
    Шаг 1: Обход массива через один элемент
    Шаг 2: Если элемент отличается от первого, то мы нашли не задублированный элемент
    Шаг 3: Вернем элемент или позицию в массиве
    Шаг 4: Если ключевой элемент не найден, верните -1 или что-то еще
    ...
    Шаг 5: Исправить ошибку ArrayIndexOutOfBoundsException (у меня не выводит ошибку)

    Псевдокод:
    Start
    for (перебираем элементы массива с шагом 2)
    if (элемент массива не должен совпадать со следующим по индексу элементом)
    возвращаем результат, иначе возвращаем -1
    End

     */

        /*
    public static int findElement(int[] arr) {
        //int size = arr.length;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }
    */

}
