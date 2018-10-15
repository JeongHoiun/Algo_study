import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n;
	static String map[];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int dp[][];
	
	class Road{
		int x;
		int y;
		int cnt;
		Road(int x,int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	void bfs() {
		Queue<Road> q = new LinkedList<Road>();
		
		q.add(new Road(0,0,0));
		
		while(!q.isEmpty()) {
			Road cur = q.remove();
			if(cur.cnt>=dp[cur.y][cur.x]) continue;
			dp[cur.y][cur.x] = cur.cnt;
			if(cur.x==n-1&&cur.y==n-1)
				continue;
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(!boundary(nx,ny)) continue;
				
				q.add(new Road(nx,ny,cur.cnt+(map[ny].charAt(nx)-'0')));
			}
			
		}
		
	}
	
	boolean boundary(int x, int y) {
		if(x>=0&&y>=0&&x<n&&y<n) return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			n = sc.nextInt();
			map = new String[n];
			dp = new int[n][n];
			for(int i=0;i<n;i++) {
				map[i] = sc.next();
				for(int j=0;j<n;j++)
					dp[i][j] = Integer.MAX_VALUE;
			}
			new Solution().bfs();
			System.out.println("#"+t+" "+dp[n-1][n-1]);
		}
	}

}
