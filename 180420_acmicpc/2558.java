import java.util.Scanner;

class Calc{
	public int add(int a, int b) {
		return a+b;
	}
}

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		Calc d = new Calc();
		System.out.println(d.add(a,b));
		
		
		
	}
}