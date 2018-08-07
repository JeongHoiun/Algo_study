import java.util.Scanner;
import java.util.Stack;

public class Main {
	void BaseConversion() {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<Integer>();
		int A, B; // A : A진법, B : B진법
		A = sc.nextInt();
		B = sc.nextInt();
		int m = sc.nextInt(); // 자릿수 갯수
		
		int num[] = new int[m];
		int g;
		int sum =0;
		for(int i=0;i<m;i++) {
			g = sc.nextInt();
			sum += g*Math.pow(A, (m-i-1)); // 3자리면 X*A^2
		}
		while(sum>0) {
			s.add(sum % B);
			sum /= B;
		}
		
		int size = s.size();
		for(int i = size-1; i >= 0 ; i --) {
			System.out.print(s.pop()+" ");
		}
	}
	
	public static void main(String[] args) {
		new Main().BaseConversion();
	}

}
