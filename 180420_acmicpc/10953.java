import java.util.Scanner;

public class Main {
	static int add(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		String s;
		for(int i=1;i<=testcase;i++){
			s = sc.next();
			System.out.println(
					add(Character.getNumericValue(s.charAt(0)),
							Character.getNumericValue(s.charAt(2))));
		}
	}
}
