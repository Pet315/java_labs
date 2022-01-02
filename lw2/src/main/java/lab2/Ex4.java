package lab2;

public class Ex4 {

    /*
    17. Сформируйте из массива a массив b по следующему алгоритму: элемент массива b равен значению разности между
    максимальным значением элементов массива a и значением данного элемента массива a.
     */

    private static String[] array1;

    public Ex4(String[] args) { array1 = args; }

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

    String[] getArray2() { // повертає новий масив b
        String[] array2 = new String[array1.length];
        double max_elem=0;

        for (int i=0; i<array1.length; i++) {
            double x = Double.parseDouble(array1[i]);
            if (max_elem <= x) {
                max_elem = x;
            }
        }
        //System.out.println(max_elem);

        for (int i=0; i<array1.length; i++) {
            double x = Double.parseDouble(array1[i]);
            array2[i] = Double.toString(max_elem - x);
            //System.out.println(x);
        }
        return array2;
    }

    public static void main(String[] args) {
        Ex4 ex4 = new Ex4(args);

        System.out.println("Array 1:");
        ex4.printArray(array1);

        if (ex4.array1Check(array1)) {
            System.out.println("Verification passed\n");
        } else {
            System.exit(1);
        }

        System.out.println("Array 2:");
        ex4.printArray(ex4.getArray2());

    }

}
