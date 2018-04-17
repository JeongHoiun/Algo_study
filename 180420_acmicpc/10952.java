import java.util.Scanner;

public class Main {
	void Ab5() {
		Scanner sc= new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			if(a==0&&b==0)
				return;
			System.out.println(Add(a,b));
		}
		
	}
	int Add(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		new Main().Ab5();

	}

}
