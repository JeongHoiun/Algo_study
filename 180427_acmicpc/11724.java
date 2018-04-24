// https://www.acmicpc.net/problem/11724
import java.util.Scanner;
import java.util.Stack;

public class Main {
	/* n : 정점의 수
	 * m : 간선의 수
	 * edge : 간선
	 */
	int n, m;
	boolean edge[][];
	void NumOfConnected() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		edge = new boolean[n+1][n+1];
		for(int i=0;i<m;i++) {
			int prev = sc.nextInt();
			int next = sc.nextInt();
			edge[prev][next] = true;
			edge[next][prev] = true;
		}
		DFS();
	}
	void DFS() {
		/*	isVisited : 방문한 정점일 경우 true
		 * 	s : DFS를 실행할 Stack
		 *  curN : 현재 방문한 정점
		 *  cnt : 연결된 요소의 갯수
		 */
		boolean isVisited[] = new boolean[n+1];
		Stack<Integer> s = new Stack<Integer>();
		int cnt=0;

		for(int c=1;c<=n;c++) {
			if(!isVisited[c]) {
				//연결된 정점을 찾을때 마다 시작할 정점을 찾음.
				s.add(c);
				cnt++;
			}
			while(!s.isEmpty()) {
				int curN = s.pop();
				if(!isVisited[curN]) {
					isVisited[curN] = true;
					for(int i=n;i>=1;i--) {
						if(edge[curN][i]&&!isVisited[i]) {
							s.push(i);
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new Main().NumOfConnected();

	}

}
