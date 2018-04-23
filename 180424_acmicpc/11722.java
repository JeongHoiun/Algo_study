// https://www.acmicpc.net/problem/11722
import java.util.Scanner;

public class Main {
	void LongestDecresingSubsequence() {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int sequence[] = new int[n];
		for(int i=0;i<n;i++) {
			sequence[i] = sc.nextInt();
		}
		int dp[] = new int[n];
		dp[0] = 1;
		
		//X(n)의 수가 X(n-1)까지의 수보다 크면서, X(n-1)까지의 최장감소부분수열에 +1을 하면됨.
		for(int i=1;i<n;i++) {
			int maxDp= 0;
			for(int j=0;j<i;j++) {
				if(maxDp<dp[j]&&sequence[i]<sequence[j])
					maxDp=dp[j];
			}
			dp[i] = maxDp+1;
		}
		
		int max = 0;
		for(int i=0;i<n;i++) {
			if (max<dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		new Main().LongestDecresingSubsequence();
	}

}
