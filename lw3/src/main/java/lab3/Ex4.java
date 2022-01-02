package lab3;
import java.util.regex.Pattern;

public class Ex4 {

    /*
    41. Преобразование аргументов, задаваемых при запуске программы. Программа определяет тип аргумента –
    шестнадцатеричное число без знака (шаблон: шестнадцатеричным числом без знака считается строка,
    которая содержит цифры от 0 до 9 и буквы A(a), B(b), C(c), D(d), E(e),F(f)) или строка.
    Введенные аргументы-числа преобразуются в десятичные числа (каждая i-ая цифра шестнадцатеричного
    числа преобразуется в десятичное число Ni по формуле  Ni=16n-i-1, где n – количество цифр в числе;
    i = 0,n – индекс цифры в числе, искомое число является суммой всех Ni). Программа выводит количество
    заданных аргументов, их значения, а также количество аргументов-чисел и их десятичные значения.
     */

    private String numb;
    private boolean is_hex;
    public Ex4(String arg) {
        numb = arg;
        is_hex = Pattern.compile("0[xX][0-9A-Fa-f]+").matcher(numb).matches();
    }

    public String check_type() {
        if (is_hex) {
            return "hex";
        } else {
            return "string";
        }
    }
    public String hexToDec() {
        if (is_hex) {
            StringBuilder process = new StringBuilder();
            for (int i=0; i<numb.length(); i++) {
                process.append(16*numb.length() - i - 1);
            }
            return process.toString();
        }
        return "another type";
    }
    public String print_arg() { return numb; }

    public static void main(String[] args) {
        System.out.println("quantity: " + args.length);
        for (String element:args) {
            Ex4 ex4 = new Ex4(element);
            System.out.println(ex4.print_arg());
            System.out.println(ex4.check_type());
            if (ex4.check_type().equals("String")) {
                System.out.println(ex4.print_arg());
            } else {
                System.out.println(ex4.hexToDec());
            }
        }
    }

}
