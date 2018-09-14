import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[][] w;
	static int min = Integer.MAX_VALUE;
	static int n ;
	static boolean[] visited;
	
	void minTSP(int cur, int sum, int cnt, int start) {
		if(cnt==n&&cur==start) {
			min = min>sum?sum:min;
			return;
		}else if(cnt!=0&&cur==start) return;
		
		for(int i=0;i<n;i++) {
			if(visited[i]||w[cur][i]==0) continue;
			visited[i] = true;
			sum+=w[cur][i];
			if(sum<=min) {
				minTSP(i,sum,cnt+1,start);
			}
			visited[i] = false;
			sum-=w[cur][i];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = new int[n][n];
		visited = new boolean[n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				w[i][j] = sc.nextInt();
		for(int i=0;i<n;i++) {
			new Main().minTSP(i,0,0,i);
		}
		System.out.println(min);
	}

}
