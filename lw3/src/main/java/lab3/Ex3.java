package lab3;

import java.util.regex.Pattern;

public class Ex3 {

    /*
    17. Анализ типов аргументов, задаваемых при запуске программы. Если аргумент является десятичным
    числом с целой и дробной частью (шаблон: состоит из одной или нескольких цифр, одной десятичной точки,
    которая может быть в начале, в середине или в конце числа,  и, кроме того, первым символом числа может
    быть знак "+" или "-"), то  тип аргумента "Decimal", иначе "String". Программа выводит количество заданных
    аргументов и, для каждого аргумента, его тип и значение.
     */

    private String numb;
    private boolean is_dec;
    public Ex3(String arg) {
        numb = arg;
        is_dec = Pattern.compile("\\+?\\-?[0-9]*\\.?[0-9]*").matcher(numb).matches();
    }

    public String check_type() {
        if (is_dec) {
            return "decimal";
        } else {
            return "string";
        }
    }
    public int get_dec() {
        if (is_dec) {
            return Integer.decode(numb);
        } else {
            return 0;
        }
    }
    public String print_arg() { return numb; }

    public static void main(String[] args) {
        System.out.println("quantity: " + args.length);
        for (String element:args) {
            Ex3 ex3 = new Ex3(element);
            System.out.println(ex3.print_arg());
            System.out.println(ex3.check_type());
            if (ex3.check_type().equals("String")) {
                System.out.println(ex3.print_arg());
            } else {
                System.out.println(ex3.get_dec());
            }
            System.out.println("---");
        }
    }
}

