import java.io.*;
import java.util.StringTokenizer;
https://www.acmicpc.net/problem/9465
	
public class Main {
	static int[][] dp;
	int sumScore(int[][] arr,int n) {
		//dp[i]x = max(dp[i-1]y,dp[i-2]y)+arr[i]x;
		dp[0][1] = arr[0][1];
		dp[1][1] = arr[1][1];
		
		for(int i=2;i<=n;i++) {
			dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+arr[0][i];
			dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+arr[1][i];
		}

		return Math.max(dp[0][n], dp[1][n]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int testcase = 1; testcase<=T; testcase++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			int[][] arr = new int[2][n+1];
			dp = new int[2][n+1];
			for(int i=1;i<=n;i++) {
				arr[0][i] = Integer.parseInt(st1.nextToken());
				arr[1][i] = Integer.parseInt(st2.nextToken());
			}

			bw.write(String.valueOf(new Main().sumScore(arr, n))+"\n");
			bw.flush();

		}
	}

}
