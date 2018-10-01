import java.io.*;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1261

public class Main {

	static String[] maze;
	static int[][] dp;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	void mazeRunner(int x, int y, int cnt) {
		dp[y][x] = cnt;
		if(x==maze[y].length()-1&&y==maze.length-1) return;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isRange(nx,ny)) continue;
			if(dp[ny][nx] <= cnt) continue;
			if(maze[ny].charAt(nx)=='1') {
				mazeRunner(nx,ny,cnt+1);
			}else if(maze[ny].charAt(nx)=='0') {
				mazeRunner(nx,ny,cnt);
			}
		}
	}
	
	boolean isRange(int x,int y) {
		if(x<0||y<0||x>=maze[0].length()||y>=maze.length)
			return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		maze = new String[m];
		dp = new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=0;i<m;i++) {
			maze[i] = br.readLine();
		}
		
		new Main().mazeRunner(0,0,0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(dp[m-1][n-1]));
		bw.close();
	}

}
