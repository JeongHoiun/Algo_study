// https://www.acmicpc.net/problem/9465
import java.util.Scanner;
public class Main {
	int dp[][];
	void Sticker() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=1;t<=testcase;t++) {
			int n= sc.nextInt();
			int sticker[][] = new int[2][n+2];
			for(int i=1;i<=n;i++) {
				sticker[0][i] = sc.nextInt();
			}
			for(int i=2;i<=n+1;i++) {
				sticker[1][i] = sc.nextInt();
			}
			dp = new int[2][n+2]; 
			//여기까지 Input        
			for (int i = 2; i <= n+1; i++){
				// 벽으로 공유되기 때문에 대각선으로 비교, 위아래로 비교
				dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1] + sticker[0][i]), dp[1][i - 2] + sticker[0][i]);
            	dp[1][i] = Math.max(Math.max(dp[1][i - 1], dp[0][i - 1] + sticker[1][i]), dp[0][i - 2] + sticker[1][i]);
			}
			
			if(dp[0][n]>dp[1][n]) {
				System.out.println(dp[0][n]);
			}else
				System.out.println(dp[1][n]);
		}
	}
	
	public static void main(String[] args) {
		new Main().Sticker();
	}

}
