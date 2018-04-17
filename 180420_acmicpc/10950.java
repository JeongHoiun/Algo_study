import java.util.Scanner;

public class Main {
	void Ab() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i=1;i<=testcase;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(Add(a,b));
		}
		
	}
	int Add(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().Ab();
	}

}
