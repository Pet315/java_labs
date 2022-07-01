import java.util.Scanner;
public class ex4 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        double a,b,d,p;
		System.out.print("a = ");
		a = in.nextInt();
		System.out.print("b = ");
		b = in.nextInt();
		d = Math.sqrt(a*a + b*b);
		p = 2*(a+b);
		System.out.println(d);
		System.out.println(p);
    }
	
}