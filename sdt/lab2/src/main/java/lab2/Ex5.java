package lab2;

import java.util.HashMap;
import java.util.Arrays;

public class Ex5 {

    /*
    22. Сформировать массив b, элементами которого являются значения индексов элементов исходного одномерного
    массива a в порядке убывания значений элементов.
     */

    private static String[] array1;

    public Ex5(String[] args) {
        array1 = args;
    }

    int printArray(String[] array) { // виведення масиву на екран
        int check = 1;
        String strArray = "";
        for (int i = 0; i < array.length; i++) {
            strArray += array[i] + " ";
        }
        System.out.println('[' + strArray + ']');
        check = 0;
        return check;
    }

    boolean array1Check(String[] arr) { // перевірка, чи цей масив є численим
        boolean check = true;
        for (int i = 0; i < arr.length; i++) {
            try {
                Double.parseDouble(arr[i]);
                continue;
            } catch (Exception e) {
                check = false;
            }
        }
        return check;
    }

    String[] getArrayIndexes() { // повертає масив індексів елементів масиву а, впорядкованого за спаданням
        HashMap<Double, Integer> map = new HashMap<>();
        Double[] array2 = new Double[array1.length];
        String[] arrayIndexes = new String[array1.length];

        for (int i = 0; i < array1.length; i++) {
            map.put(Double.parseDouble(array1[i]), i);
        }
        for (int i = 0; i < array1.length; i++) {
            array2[i] = Double.parseDouble(array1[i]);
        }
        Arrays.sort(array2); // сортування за зростанням
        double tmp;
        for (int i = 0, j = array2.length - 1; i < j; i++, j--) { // "перевертання" масиву
            tmp = array2[i];
            array2[i] = array2[j];
            array2[j] = tmp;
        }
        for (int i = 0; i < array1.length; i++) {
            arrayIndexes[i] = Integer.toString(map.get(array2[i]));
        }
        return arrayIndexes;

    }

    public static void main(String[] args) {
        Ex5 ex5 = new Ex5(args);

        System.out.println("Array 1:");
        ex5.printArray(array1);

        if (ex5.array1Check(array1)) {
            System.out.println("Verification passed\n");
        } else {
            System.exit(1);
        }

        System.out.println("Array 2:");
        ex5.printArray(ex5.getArrayIndexes());

    }
}
