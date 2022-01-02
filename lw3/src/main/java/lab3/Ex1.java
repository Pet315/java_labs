package lab3;
import java.util.Scanner;

public class Ex1 {

    /*
    2. Вывести таблицу преобразований целых десятичных чисел в интервале от min до max с шагом step
    в 16-ном представлении. Параметры задачи задаются как параметры командной строки.
     */

    static void printTable(int min, int max, int step) {
        System.out.println("dc | hx");
        while (min <= max) {
            System.out.print(min);
            System.out.print(" | ");
            System.out.println(Integer.toHexString(min));
            min += step;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int min, max, step;
        System.out.print("min = ");
        min = in.nextInt();
        System.out.print("max = ");
        max = in.nextInt();
        System.out.print("step = ");
        step = in.nextInt();
        printTable(min, max, step);
    }

}