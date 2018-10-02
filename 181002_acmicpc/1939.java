import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1939
public class Main {
	static int[][] bridge;
	static int maxBridge;

	int maxWeight(int from, int to, int m) {
		int left = 1;
		int right = maxBridge;

		int mid = (left+right)/2;
		while(left<=right) {
			mid = (left+right)/2;
			//BFS 실행

			boolean isThere = bfs(mid,from,to);

			//left right 나누기
			if(isThere)
				left = mid+1;
			else
				right = mid-1;

		}
		return mid;
	}

	boolean bfs(int n, int x, int y) {
		boolean[] isVisited = new boolean[bridge[0].length];
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(x);
		isVisited[x] = true;
		while(!q.isEmpty()) {
			int cur_T = q.poll();
			if(cur_T==y) return true;

			for(int i=0;i<bridge[0].length;i++) {

				if(bridge[cur_T][i]>=n||bridge[i][cur_T]>=n) {
					if(!isVisited[i]) {
						q.add(i);
						isVisited[i] = true;
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		bridge = new int[n][n];
		maxBridge = 0;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			bridge[a][b] = Integer.parseInt(st.nextToken());
			maxBridge = maxBridge<bridge[a][b]? bridge[a][b]:maxBridge;
		}
		st = new StringTokenizer(br.readLine(), " ");
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(new Main().maxWeight(from-1, to-1, m)));
		bw.close();

	}

}
