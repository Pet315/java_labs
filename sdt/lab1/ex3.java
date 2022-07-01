import java.util.Scanner;
public class ex3 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int a, f=1;
		System.out.print("a = ");
		a = in.nextInt();
		for (int i=1; i<=a; i++){
			f *= i;
		}
		System.out.println(f);
    }
	
}