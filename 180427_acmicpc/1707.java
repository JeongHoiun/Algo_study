//https://www.acmicpc.net/problem/1707
//runtime error

import java.util.Scanner;
import java.util.Stack;

public class Main {
	/*
	 * v: ������ ����, e:������ ����, edge : ����
	 */
	int v,e;
	boolean edge[][];

	void BipartiteGraph() {
		/*
		 * �׷����� ����Ŭ�� �����ϰ�, ����Ŭ�� Ȧ������ �������� �̷���� ���
		 * �̺б׷����� ��Ÿ�� �� ����. �� �������� �Ϸ� ������, ����� �ڵ��� �� �� ����.
		 * �� ������ DFS�� Ž���Ͽ� ������ ������ ���� ������ ������ ������ �ݴ� �׷����� ���� ��.
		 */
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test=1; test<=testcase;test++) {
			v = sc.nextInt(); e = sc.nextInt();
			edge = new boolean[v+10][v+10];
			for(int i=0;i<e;i++) {
				int e1 = sc.nextInt();	//������ ����� ���� 1
				int e2 = sc.nextInt();	//������ ����� ���� 2
				edge[e1][e2] = true;
				edge[e2][e1] = true;
			}
			DFS();
		}
	}

	void DFS() {
		/*	isVisited : �׷�1�� �׷�2�� ����� ���� 1, 2�� ǥ��
		 * 	s : DFS�� ������ Stack
		 *  curN : ���� �湮�� ����
		 *  cnt : ����� ����� ����
		 *  number : ���� �׷�.
		 */
		int isVisited[] = new int[v+10];
		Stack<Integer> s = new Stack<Integer>();

		//����� ������ ã���� ���� ������ ������ ã��.
		s.push(1);
		s.push(1);
		while(!s.isEmpty()) {
			int number = s.pop();//��� �׷쿡 �����ִ��� ?
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
		 * �̺б׷������� Ȯ��
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
