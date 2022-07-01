package lab3;
import java.util.Scanner;

public class Ex2 {

    /*
    13. Создайте программу, которая осуществляет шифрование / расшифровка методом простой замены.
    В нем каждый символ незашифрованного текста из исходного алфавита заменяется другим из алфавита,
    символы в каком представлены в соответствии с ключом шифрования.
     */

    static StringBuffer encryption(String phrase, Integer[] array) {
        StringBuffer process = new StringBuffer();
        System.out.println("Standard: " + phrase);
        for (int i = 0; i < phrase.length(); i++) {
            process.append((char) (phrase.charAt(i)+array[i]));
        }
        return process;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter phrase: ");
        String phrase = in.nextLine();
        System.out.print("Enter array: ");
        Integer[] array = new Integer[phrase.length()];
        for (int i=0; i<phrase.length(); i++) {
            array[i] = in.nextInt();
        }
        System.out.println("New: " + encryption(phrase, array));
    }

}