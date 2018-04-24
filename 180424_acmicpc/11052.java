// https://www.acmicpc.net/problem/11052
// 
import java.util.Scanner;

public class Main {
	void SellFishBread() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int price[] = new int[n+1];
		int dp[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			price[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = i; j <= n; j++){
				dp[j]= dp[j] > dp[j-i] + price[i] ? dp[j] : dp[j - i] + price[i];
			}
		}
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
		new Main().SellFishBread();
	}

}
