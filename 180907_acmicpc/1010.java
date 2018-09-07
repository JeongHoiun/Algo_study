import java.io.*;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1010

public class Main {
	static int[][] dp;
	int Bridge(int n, int m) {
		//dp[m][n] = dp[m-1][n-1]+dp[m-1][n];
		for(int i=1;i<=n;i++) {
			dp[i][i] = 1;
		}
		for(int j=1;j<=m;j++) dp[j][1] = j;
		for(int i=2;i<=n;i++) {
			for(int j=2;j<=m;j++) {
				dp[j][i] = dp[j-1][i-1]+dp[j-1][i];
			}
		}
		
		return dp[m][n];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n, m;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			dp = new int[m+1][n+1];
			
			bw.write(String.valueOf(new Main().Bridge(n, m))+"\n");
			bw.flush();
		}
	}

}
