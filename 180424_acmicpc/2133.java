// https://www.acmicpc.net/problem/2133
import java.util.Scanner;
//ÀÌÇØ¾ÈµÊ.
public class Main {
	void FillTiles() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		int result[] = new int[n+1];
		dp[0] = 1; result[0] = 1; dp[2] = 3;
		for(int i=4;i<=n;i+=2) {
			dp[i] = 2;
		}
		for (int i = 2; i <= n; i+=2){
			for (int j = 2; j <= i; j += 2){
				result[i] += dp[j] * result[i - j];
			}
		}
		System.out.println(result[n]);

	}
	public static void main(String[] args) {
		new Main().FillTiles();
	}

}
