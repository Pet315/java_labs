import java.util.Scanner;
public class ex2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        double a, b, alpha, s;
		System.out.print("a = ");
		a = in.nextDouble();
		System.out.print("b = ");
		b = in.nextDouble();
		System.out.print("alpha = ");
		alpha = in.nextDouble();
		s = a*b*Math.sin(Math.toDegrees(alpha));
		System.out.println(s);
    }
	
}
