import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/2331

public class Main {
	// A: 각자리수를 곱할 수   P: 몇번 곱할지.
	int A;
	int P;
	void RepeatSequence() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		P = sc.nextInt();
		DFS();
	}
	
	void DFS() {
		// isVisited의 상태변화 , 0 : 방문x 1: 한번 2: 두번
		int isVisited[] = new int[300000];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		//DFS의 경우 Stack을 이용하여 탐색할 수 있다.
		s.push(A);	
		while(!s.isEmpty()) {
			int curN = s.pop();
			if(isVisited[curN]==0) {
				/* 처음으로 방문하는 경우 arr에 집어넣는다. 
				 * isVisited의 상태는 1로 변하고 다음에 넣을 숫자를 연산하여 넣는다.
				 */
				arr.add(curN);
				isVisited[curN]=1;
				int j=0;
				while(curN!=0) {
					int a = curN%10;
					int k =1;
					for(int i=0;i<P;i++) {
						k*=a;
					}
					j+=k;
					curN/=10;
				}
				s.push(j);
			}else if(isVisited[curN]==1){
				/*
				 * 한번 방문한 경험이 있는 경우, arr에서 삭제한다.
				 * isVisited의 상태는 2로 변하고 다음에 넣을 숫자를 연산한다.
				 */
				arr.remove((Object)curN);
				isVisited[curN] = 2;
				int j=0;
				while(curN!=0) {
					int a = curN%10;
					int k =1;
					for(int i=0;i<P;i++) {
						k*=a;
					}
					j+=k;
					curN/=10;
				}
				s.push(j);
			}
			//두번째 방문한 경우 그대로 arr에서 삭제되기 때문에 arr에는 비사이클 정수만 남는다.
			
		}
		
		System.out.println(arr.size());
	}
	
	public static void main(String[] args) {
		new Main().RepeatSequence();
	}

}
