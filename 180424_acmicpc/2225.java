// https://www.acmicpc.net/problem/2225
import java.util.Scanner;

public class Main {
	void DivideSum() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		long dp[][] = new long[201][201];	//N = Á¤¼ö K = °¹¼ö dp[N][K]
		for(int i=1;i<=200;i++) {
			dp[i][1] = 1;
		}
	    for (int i = 0; i <= n; i++)
	        dp[i][2] = i + 1;


	    for (int i = 3; i <= k; i++)
	    {
	        for (int j = 0; j <= n; j++)
	            for (int l = 0; l <= j; l++){
	                dp[j][i] = (dp[j][i]+dp[j-l][i-1])%1000000000;
	 
	            }
	        
	    }
		
		System.out.println(dp[n][k]%1000000000);
	}
	public static void main(String[] args) {
		new Main().DivideSum();

	}

}
