package lab2;

public class Ex1 {

    /*
    2. Определить значения двух наибольших и разных по значению элементов исходного одномерного массива a[] и их
    индексы (массив может содержать элементы с равными значениями, т.е. необходимо вывести значение и индексы
    элементов с максимальными значениями и значение второго по величине элемента, а также индексы всех
    элементов, имеющих второе по величине значение).
     */

    private static String[] array1;

    public Ex1(String[] args) { array1 = args; }

    int printArray(String[] array) { // виведення масиву на екран
        int check = 1;
        String strArray = "";
        for (int i=0; i<array.length; i++) {
            strArray += array[i] + " ";
        }
        System.out.println('[' + strArray + ']');
        check = 0;
        return check;
    }

    boolean array1Check(String[] arr) { // перевірка, чи цей масив є численим
        boolean check = true;
        for (int i=0; i<arr.length; i++) {
            try {
                Double.parseDouble(arr[i]);
                continue;
            } catch (Exception e) {
                check = false;
            }
        }
        return check;
    }

    Double[] getArray2() { // повертає відсортований від найбільшого до найменшого елемента масив
        Double[] array2 = new Double[array1.length];
        for (int i=0; i<array1.length; i++) {
            array2[i] = Double.parseDouble(array1[i]);
        }

        boolean s=false;
        while(!s) {
            double r;
            s = true;
            for (int i = 0; i < array2.length - 1; i++) {
                if (array2[i] < array2[i+1]) {
                    r = array2[i];
                    array2[i] = array2[i+1];
                    array2[i+1] = r;
                    s = false;
                }
            }
        }
        return array2;
    }

    Integer[] getIndexes() { // повертає масив індексів елементів початкового масиву
        Double[] array = new Double[array1.length];
        Integer[] arrayIndexes = new Integer[array1.length];

        for (int i=0; i<array1.length; i++) {
            array[i] = Double.parseDouble(array1[i]);
        }

        double max;
        int index=0;
        int k=0, l=0;

        for (int i=0; i < array1.length; i++) {
            max = array[i];
            for (int j=i; j < array1.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    index = j;
                }
            }
            //System.out.printf("%d, %.2f\n", index, max);
            if (index == l) {
                index=i;
            }
            arrayIndexes[k] = index;
            k++;
            l=index;
            array[index] = array[i];
        }
        return arrayIndexes;
    }

    int printArray2(Double[] arr, Integer[] arr1) {

        /*
        виведення на екран перших і других за величиною
        елементів масиву та їх індексів у початковому масиві
         */

        int flag = 1, counter=0;
        for (int i=0; i < array1.length-1; i++) {
            System.out.printf("Max element: %.2f, its index: %d\n", arr[i], arr1[i]);
            if (arr[i] > arr[i+1]) {
                counter++;
            }
            if (counter == 2) {
                i = array1.length;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1(args);

        System.out.println("Array 1:");
        ex1.printArray(array1);

        if (ex1.array1Check(array1)) {
            System.out.println("Verification passed\n");
        } else {
            System.exit(1);
        }
        ex1.printArray2(ex1.getArray2(), ex1.getIndexes());
    }
}