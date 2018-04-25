import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/2331

public class Main {
	// A: ���ڸ����� ���� ��   P: ��� ������.
	int A;
	int P;
	void RepeatSequence() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		P = sc.nextInt();
		DFS();
	}
	
	void DFS() {
		// isVisited�� ���º�ȭ , 0 : �湮x 1: �ѹ� 2: �ι�
		int isVisited[] = new int[300000];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		//DFS�� ��� Stack�� �̿��Ͽ� Ž���� �� �ִ�.
		s.push(A);	
		while(!s.isEmpty()) {
			int curN = s.pop();
			if(isVisited[curN]==0) {
				/* ó������ �湮�ϴ� ��� arr�� ����ִ´�. 
				 * isVisited�� ���´� 1�� ���ϰ� ������ ���� ���ڸ� �����Ͽ� �ִ´�.
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
				 * �ѹ� �湮�� ������ �ִ� ���, arr���� �����Ѵ�.
				 * isVisited�� ���´� 2�� ���ϰ� ������ ���� ���ڸ� �����Ѵ�.
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
			//�ι�° �湮�� ��� �״�� arr���� �����Ǳ� ������ arr���� �����Ŭ ������ ���´�.
			
		}
		
		System.out.println(arr.size());
	}
	
	public static void main(String[] args) {
		new Main().RepeatSequence();
	}

}
