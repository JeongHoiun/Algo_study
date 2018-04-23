// https://www.acmicpc.net/problem/11054
import java.util.Scanner;

public class Main {
	void LongestBitonicSubsequence() {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int sequence[] = new int[n];
		for(int i=0;i<n;i++) {
			sequence[i] = sc.nextInt();
		}
		
		/*
		 * 최장증가부분수열을 앞에서부터 실행, 최장감소부분수열을 뒤에서부터 실행하여 
		 * 각각의 dp부분을 더하고, 한번씩 겹치기 때문에 -1을 해줌.
		 */
		int dp1[] = new int[n];
		dp1[0] = 1;
		
		for(int i=1;i<n;i++) {
			int maxDp= 0;
			for(int j=0;j<i;j++) {
				if(maxDp<dp1[j]&&sequence[i]>sequence[j])
					maxDp=dp1[j];
			}
			dp1[i] = maxDp+1;
		}
		int dp2[] = new int[n];
		dp2[n-1] = 1;
		
		for(int i=n-2;i>=0;i--) {
			int maxDp= 0;
			for(int j=n-1;j>i;j--) {
				if(maxDp<dp2[j]&&sequence[i]>sequence[j])
					maxDp=dp2[j];
			}
			dp2[i] = maxDp+1;
		}
		int max = 0;
		for(int i=0;i<n;i++) {
			dp1[i]+=dp2[i];
			if(dp1[i]>max)
				max=dp1[i];
		}
		System.out.println(max-1);
	}
	public static void main(String[] args) {
		new Main().LongestBitonicSubsequence();
	}

}
