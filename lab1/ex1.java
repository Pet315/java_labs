import java.util.Scanner;

public class ex1 {
	
	private static float count(float x) {
		Scanner in = new Scanner(System.in);
		float []a = new float[4];
		for (int i=0; i<3; i++) {
			System.out.printf("Integer %d: ", i+1);
			a[i] = in.nextFloat();
			x+=a[i];
		}
		x/=3;
		in.close();
		return x;
	}
	
	public static void main(String[] args) {
		
		float x=0;
		x = count(x);
		System.out.printf("x = %.2f\n", x); // среднее арифметическое
		System.out.printf("x1 = %d\n", Math.round(x)); // ближайшее целое
		
	}
	
}