import java.util.Scanner;

public class Main {
	static int add(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t = 1; t <= testcase ; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Case #" + t + ": " + a + " + " + b + " = "+ add(a,b));
		}
	}

}
