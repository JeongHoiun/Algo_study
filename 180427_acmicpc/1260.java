// https://www.acmicpc.net/problem/1260

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	//n : ������ ����, m : ������ ����, v : ���� ���� ��ȣ, edge : ����� ���� ����Ǹ� true �ƴϸ� false
	int n, m, v;
	boolean edge[][];
	void DFSNBFS() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		edge = new boolean[n+1][n+1];
		for(int i=0;i<m;i++) {
			int prev = sc.nextInt();
			int next = sc.nextInt();
			edge[prev][next] = true;
			edge[next][prev] = true;		//�����
		}
		DFS();
		BFS();
	}

	void DFS() {
		boolean isVisited[] = new boolean[n+1];
		Stack<Integer> s = new Stack<Integer>();
		//DFS�� ��� Stack�� �̿��Ͽ� Ž���� �� �ִ�.
		s.push(v);
		while(!s.isEmpty()) {
			int curN = s.pop();
			if(!isVisited[curN]) {
				isVisited[curN] = true;
				System.out.print(curN + " ");
				for(int i=n;i>=1;i--) {
					// i=1;i<=n ���� �Ҽ� ������ ���ؿ��� �������.
					if(edge[curN][i]&&!isVisited[i]) {
						s.push(i);
					}
				}
			}
		}
		System.out.println();
	}
	
	void BFS() {
		boolean isVisited[] = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		//BFS�� Queue�� �̿��Ͽ� �ʺ�켱 Ž���� ����.
		q.add(v);
		while(!q.isEmpty()) {
			int curN = q.poll();
			if(!isVisited[curN]) {
				isVisited[curN] = true;
				System.out.print(curN + " ");
				for(int i=1;i<=n;i++) {
					if(edge[curN][i]&&!isVisited[i])
						q.add(i);
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new Main().DFSNBFS();

	}

}
