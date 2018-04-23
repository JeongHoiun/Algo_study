// https://www.acmicpc.net/problem/9461
import java.util.Scanner;

public class Main {
	void PadoVanSequence() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[] = new long [101];
		dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;
		
		for(int i=6;i<=n;i++) {
			dp[i] = dp[i-5]+dp[i-1];
		}
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().PadoVanSequence();
	}

}
