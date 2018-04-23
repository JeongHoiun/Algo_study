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
		
		//X(n)�� ���� X(n-1)������ ������ ũ�鼭, X(n-1)������ ���尨�Һκм����� +1�� �ϸ��.
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
