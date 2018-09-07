import java.io.*;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/2294


public class Main {
	static int dp[];
	static int coin[];
	int minCoin(int n, int k, int[] coin) {
		for(int i=0;i<n;i++) {
			dp[coin[i]] = 1;
		}
		int ans = dp(k);
		if(ans > 10000000) return -1;
		else return ans;
	}
	
	int dp(int k) {
		if(k<=0) return -1;
		if(dp[k] >0)
			return dp[k];
		else {
			int min = 1000000000;
			for(int i=0;i<coin.length;i++) {
				if(k-coin[i] <= 0) continue;
				int tmp = dp(k-coin[i]);
				if(min>tmp) min = tmp;
			}
			
			return dp[k] = min+1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[10000000];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(new Main().minCoin(n,k,coin)));
		bw.close();
	}

}
