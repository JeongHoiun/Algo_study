import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int dp[][];
	int maxCandy(int n, int m, int[][] maze) {
		dp[0][0] = maze[0][0];
		for(int i=1;i<n;i++) {
			dp[0][i] = maze[0][i]+dp[0][i-1];
		}
		for(int j=1;j<m;j++) {
			dp[j][0] = maze[j][0]+dp[j-1][0];
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				dp[j][i] = Math.max(dp[j-1][i], Math.max(dp[j-1][i-1], dp[j][i-1]))+maze[j][i];
			}
		}
		
		return dp[m-1][n-1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[M][N];
		dp = new int[M][N];
		for(int n = 0 ; n < N ; n ++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int m = 0 ; m < M ; m ++) {
				maze[m][n] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(new Main().maxCandy(N, M, maze)));
		bw.flush();
		
	}

}
