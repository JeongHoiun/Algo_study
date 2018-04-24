// https://www.acmicpc.net/problem/11724
import java.util.Scanner;
import java.util.Stack;

public class Main {
	/* n : ������ ��
	 * m : ������ ��
	 * edge : ����
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
		/*	isVisited : �湮�� ������ ��� true
		 * 	s : DFS�� ������ Stack
		 *  curN : ���� �湮�� ����
		 *  cnt : ����� ����� ����
		 */
		boolean isVisited[] = new boolean[n+1];
		Stack<Integer> s = new Stack<Integer>();
		int cnt=0;

		for(int c=1;c<=n;c++) {
			if(!isVisited[c]) {
				//����� ������ ã���� ���� ������ ������ ã��.
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
