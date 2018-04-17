import java.io.InterruptedIOException;
import java.util.Scanner;

public class Main {

	void Ab4(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(Add(a,b));
		}
		
	}
	int Add(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		new Main().Ab4();
	}

}
