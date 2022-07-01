package lab2;

public class Ex2 {

    /*
    7. Определить абсолютное значение наименьшей разности между двумя любыми значениями элементов исходного
    одномерного массива a
     */

    private static String[] array1;

    public Ex2(String[] args) { array1 = args; }

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

    double getValue() { // знаходження найменшої різниці між певними елементами
        double min_dif = 0;
        for (int i = 0; i < array1.length - 1; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                double x = Double.parseDouble(array1[i]);
                double y = Double.parseDouble(array1[j]);
                //System.out.println(y-x);
                if ((y-x) < min_dif) {
                    min_dif = y-x;
                }
            }
        }
        return min_dif;
    }

    public static void main(String[] args) {
        Ex2 ex2 = new Ex2(args);

        System.out.println("Array 1:");
        ex2.printArray(array1);

        if (ex2.array1Check(array1)) {
            System.out.println("Verification passed\n");
        } else {
            System.exit(1);
        }
        System.out.println("Значення найменшої різниці: " + Math.abs(ex2.getValue()));
    }

}
