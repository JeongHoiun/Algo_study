import java.util.Scanner;

public class Main {
	static int[][] result_fibo;
	
	public void fibo() {
		result_fibo = new int[41][2];
		result_fibo[0][0] = 1;
		result_fibo[0][1] = 0;
		result_fibo[1][0] = 0;
		result_fibo[1][1] = 1;
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		fibonacci(41);
		while(testcase--!=0) {
			int n = sc.nextInt();
			System.out.println(result_fibo[n][0] + " " + result_fibo[n][1]);
		}
		
	}
	
	public void fibonacci(int n) {		//fibonacci의 0과 1의 수 세팅
		for(int i=2;i<n;i++) {
			result_fibo[i][0] = result_fibo[i-1][0] + result_fibo[i-2][0];
			result_fibo[i][1] = result_fibo[i-1][1] + result_fibo[i-2][1];
		}
	}
	
	public static void main(String[] args) {
		new Main().fibo();

	}

}
