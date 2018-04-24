//https://www.acmicpc.net/problem/1707
//runtime error

import java.util.Scanner;
import java.util.Stack;

public class Main {
	/*
	 * v: 정점의 갯수, e:간선의 갯수, edge : 간선
	 */
	int v,e;
	boolean edge[][];

	void BipartiteGraph() {
		/*
		 * 그래프의 사이클이 존재하고, 사이클이 홀수개의 정점으로 이루어진 경우
		 * 이분그래프로 나타낼 수 없다. 를 기준으로 하려 했으나, 어려운 코딩이 될 것 같음.
		 * 각 정점을 DFS로 탐색하여 정점을 지날때 마다 이전에 지나온 정점의 반대 그룹으로 들어가게 함.
		 */
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test=1; test<=testcase;test++) {
			v = sc.nextInt(); e = sc.nextInt();
			edge = new boolean[v+10][v+10];
			for(int i=0;i<e;i++) {
				int e1 = sc.nextInt();	//간선에 연결될 정점 1
				int e2 = sc.nextInt();	//간선에 연결될 정점 2
				edge[e1][e2] = true;
				edge[e2][e1] = true;
			}
			DFS();
		}
	}

	void DFS() {
		/*	isVisited : 그룹1과 그룹2로 나뉘어서 각각 1, 2로 표현
		 * 	s : DFS를 실행할 Stack
		 *  curN : 현재 방문한 정점
		 *  cnt : 연결된 요소의 갯수
		 *  number : 속한 그룹.
		 */
		int isVisited[] = new int[v+10];
		Stack<Integer> s = new Stack<Integer>();

		//연결된 정점을 찾을때 마다 시작할 정점을 찾음.
		s.push(1);
		s.push(1);
		while(!s.isEmpty()) {
			int number = s.pop();//몇번 그룹에 속해있는지 ?
			int curN = s.pop();
			if(isVisited[curN]==0) {
				isVisited[curN] = 3-number;		//3-2 = 1(group) 3-1 = 2(group)
				for(int i=v;i>=1;i--) {
					if(edge[curN][i]&&isVisited[i]==0) {
						s.push(i);
						s.push(isVisited[curN]);
					}
				}
			}
		}
		/*
		 * 이분그래프인지 확인
		 */
		boolean isBinary = true;
		for(int i=1;i<=v;i++) {
			for(int j=1;j<=v;j++) {
				if(edge[i][j]&&isVisited[i]==isVisited[j]) {
					isBinary = false;
				}
			}
			if(!isBinary) break;
		}
		if(isBinary) System.out.println("YES");
		else System.out.println("NO");
	}

	public static void main(String[] args) {
		new Main().BipartiteGraph();
	}

}
