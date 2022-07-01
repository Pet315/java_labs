package lab2;

public class Ex3 {

    /*
    12. Определить, образуют ли значения элементов исходного одномерного массива a: строго возрастающую
    последовательность (ai < ai+1), строго убывающую последовательность (ai > ai+1) или элементы массива не
    упорядочены и вывести для каждого случая соответствующее сообщение.
     */

    private static String[] array1;

    public Ex3(String[] args) { array1 = args; }

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

    boolean growingCheck() { // перевіряє, чи є послідовність строго зростаючою
        for (int i = 0; i < array1.length - 1; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                double x = Double.parseDouble(array1[i]);
                double y = Double.parseDouble(array1[j]);
                //System.out.println(x-y);
                if (x >= y) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean decreasingCheck() { // перевіряє, чи є послідовність строго спадною
        for (int i = 0; i < array1.length - 1; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                double x = Double.parseDouble(array1[i]);
                double y = Double.parseDouble(array1[j]);
                if (x <= y) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ex3 ex3 = new Ex3(args);

        System.out.println("Array:");
        ex3.printArray(array1);

        if (ex3.array1Check(array1)) {
            System.out.println("Verification passed\n");
        } else {
            System.exit(1);
        }

        if (ex3.growingCheck()) {
            System.out.println("the sequence is growing");
        } else if (ex3.decreasingCheck()) {
            System.out.println("the sequence is decreasing");
        } else {
            System.out.println("the sequence elements are disordered");
        }

    }


}
