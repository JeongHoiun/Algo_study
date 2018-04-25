// https://www.acmicpc.net/problem/10451

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	//n : 순열의 크기 , perm = 순열
	int n;
	int perm[][];
	void PermutationCycles() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		while(testcase--!=0) {
			n = sc.nextInt();
			perm = new int[2][n+1];
			//perm[0][x]: 정렬된 순열, perm[1][x] : 비정렬 순열
			for(int i=1;i<=n;i++) {
				perm[1][i] = sc.nextInt();
				perm[0][i] = perm[1][i];
			}
			Arrays.sort(perm[0]);

			System.out.println(DFS());

		}
	}

	int DFS() {
		int cycle = 0;
		boolean isVisited[] = new boolean[n+1];
		Stack<Integer> s = new Stack<Integer>();
		//DFS의 경우 Stack을 이용하여 탐색할 수 있다.
		for(int i=1;i<=n;i++) {
			if(!isVisited[i]) {
				s.push(perm[0][i]);
				while(!s.isEmpty()) {
					int curN = s.pop();
					isVisited[curN] = true;
					if(!isVisited[perm[1][curN]]) {
						s.push(perm[1][curN]);
					}else {
						cycle++;
					}

				}
			}
		}
		return cycle;
	}

	public static void main(String[] args) {
		new Main().PermutationCycles();

	}

}
