// https://www.acmicpc.net/problem/1912
import java.util.Scanner;

public class Main {
	void SequenceSum() {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int sequence[] = new int[n+1];
		int dp[] = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			sequence[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++)
	    {
	        
	        if (dp[i - 1] + sequence[i] > sequence[i]){
	            dp[i] = dp[i - 1] + sequence[i];
	        }
	        else
	        {
	            dp[i] = sequence[i];
	        }
	    
	    }
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			if (max<dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().SequenceSum();
	}

}
