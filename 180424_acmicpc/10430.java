import java.util.Scanner;

class Calc{
	public int addre(int a, int b,int c) {
		return (a+b)%c;
	}
	public int readd(int a,int b,int c) {
		return (a%c + b%c)%c;
	}
	public int mulre(int a, int b,int c) {
		return (a*b)%c;
	}
	public int remul(int a, int b,int c) {
		return (a%c * b%c) %c;
	}
}

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b,c;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		Calc d = new Calc();
		System.out.println(d.addre(a,b,c));
		System.out.println(d.readd(a,b,c));
		System.out.println(d.mulre(a,b,c));
		System.out.println(d.remul(a,b,c));
		
		
		
	}
}