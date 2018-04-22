// acmicpc.net/problem/11727
import java.util.Scanner;

public class Main {
	int dp[];
	void Tiling() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		dp[1] = 1;
		System.out.println(nTile(n)%10007);
	}
	
	int nTile(int n) {
		//  n(N_3) = n(N_2)+n(N_1) 
		if(dp[n] > 0) 
			return dp[n];
		else if(n%2==0)
			dp[n] = nTile(n-1)*2+1;
		else if(n%2==1)
			dp[n] = nTile(n-1)*2-1;
		return dp[n]%10007;
	}
	
	public static void main(String[] args) {
		new Main().Tiling();
	}

}
