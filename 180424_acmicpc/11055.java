//https://www.acmicpc.net/problem/11055
import java.util.Scanner;

public class Main {
	void MaxIncreasingSubsequence() {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int sequence[] = new int[n];
		for(int i=0;i<n;i++) {
			sequence[i] = sc.nextInt();
		}
		int dp[] = new int[n];
		dp[0] = sequence[0];
		
		//X(n)�� ���� X(n-1)������ ������ ũ�鼭, X(n-1)������ ���������κм����� X(N)�� ���ϸ��.
		for(int i=1;i<n;i++) {
			int maxDp= 0;
			for(int j=0;j<i;j++) {
				if(maxDp<dp[j]&&sequence[i]>sequence[j])
					maxDp=dp[j];
			}
			dp[i] = maxDp+sequence[i];
		}
		
		int max = 0;
		for(int i=0;i<n;i++) {
			if (max<dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		new Main().MaxIncreasingSubsequence();
	}

}
