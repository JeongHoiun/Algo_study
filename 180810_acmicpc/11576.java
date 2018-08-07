import java.util.Scanner;
import java.util.Stack;

public class Main {
	void BaseConversion() {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<Integer>();
		int A, B; // A : A����, B : B����
		A = sc.nextInt();
		B = sc.nextInt();
		int m = sc.nextInt(); // �ڸ��� ����
		
		int num[] = new int[m];
		int g;
		int sum =0;
		for(int i=0;i<m;i++) {
			g = sc.nextInt();
			sum += g*Math.pow(A, (m-i-1)); // 3�ڸ��� X*A^2
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
