// https://www.acmicpc.net/problem/2193
import java.util.Scanner;
public class Main {
	long dp[][];		// int로 하면 안됨.. 범위 벗어남..
	void PinaryNumber() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[2][91];//앞에껀 0~9를 나타냄, 뒤에꺼가 길이.
		dp[1][1] = 1;
		dp[1][2] = 1;
		for(int i=2;i<=n;i++) {
			//다음 자릿수에 서 항상 처음에는 1이 나옴.
			//1의 경우는 이전의 자릿 수가 무조건 0이여야 함
			//0의 경우는 이전의 자릿수가 0이든 1이든 상관없어서 둘다 더함.
			dp[1][i] = dp[0][i-1];
			dp[0][i] = dp[0][i-1]+dp[1][i-1];
		}
		long result=0;
		for(int i=0;i<2;i++) {
			result += dp[i][n];
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		new Main().PinaryNumber();

	}

}
