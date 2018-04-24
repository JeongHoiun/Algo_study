// https://www.acmicpc.net/problem/1260

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	//n : 정점의 갯수, m : 간선의 갯수, v : 시작 정점 번호, edge : 연결된 간선 연결되면 true 아니면 false
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
			edge[next][prev] = true;		//양방향
		}
		DFS();
		BFS();
	}

	void DFS() {
		boolean isVisited[] = new boolean[n+1];
		Stack<Integer> s = new Stack<Integer>();
		//DFS의 경우 Stack을 이용하여 탐색할 수 있다.
		s.push(v);
		while(!s.isEmpty()) {
			int curN = s.pop();
			if(!isVisited[curN]) {
				isVisited[curN] = true;
				System.out.print(curN + " ");
				for(int i=n;i>=1;i--) {
					// i=1;i<=n 으로 할수 있지만 백준에선 안잡아줌.
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
		//BFS는 Queue를 이용하여 너비우선 탐색이 가능.
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
