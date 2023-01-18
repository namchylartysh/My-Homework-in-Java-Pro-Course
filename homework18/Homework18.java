package homework18;

/**
 * Java Professional Homework #18
 *
 * @author Artysh
 * @version 16.01 - 19.01
 */

public class Homework18 {
    public static void main(String[] args) {
        String[][] matrix1 = {
                {"2", "1", "8", "4"},
                {"3", "0", "5", "7"},
                {"8", "9", "6", "1"},
                {"4", "5", "3", "9"}
        };
        String[][] matrix2 = {
                {"6", "11", "22", "1"},
                {"73", "5", "9"},
                {"0", "10", "85", "2"},
                {"43", "81", "7", "3"}
        };
        String[][] matrix3 = {
                {"1", "9", "8", "3"},
                {"2", "2", "2", "2"},
                {"5", "7", "4", "1"},
                {"3", "X", "8", "10"}

        };

        System.out.println("matrix1");
        try {
            System.out.println(sumMatrix(matrix1));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println("matrix2");
        try {
            System.out.println(sumMatrix(matrix2));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println("matrix3");
        try {
            System.out.println(sumMatrix(matrix3));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }

    }

    public static int sumMatrix(String[][] x) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        int a = x.length;
        int b = x[a - 1].length;
        if (a != 4 || b != 4) {
            throw new MyArraySizeException("Matrix size must be 4 x 4");
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                try {
                    int result = Integer.parseInt(x[i][j]);
                    sum += result;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Incorrect data in the cell: row, col");
                }
            }
        }
        return sum;
    }


        // проверка размеров массива
        // если размер не соответствует, выброс MyArrayException
        // преобразование всех элементов в matrix в int
        // и суммирование их
        // преобразование строки в целое число: Integer.parseInt(str)
        // если преобразование не удается (исключение), выброс MyArrayDataException(row, col)

}
