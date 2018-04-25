import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/9466

public class Main {
	// n : �л��Ǽ� , student �л�, st : start ������ ������ �迭
	int n;
	int perm[];
	int st[];
	void TermProject() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		while(testcase--!=0) {
			n = sc.nextInt();
			perm = new int[n+1];
			st = new int[n+1];
			for(int i=1;i<=n;i++) {
				perm[i] = sc.nextInt();
			}
			System.out.println(n-DFS());
		}
	}
	
	int DFS() {
		//result : cycle�� ���� ������ ��
		int result=0;
		int isVisited[] = new int[n+1];	//�湮 Ƚ��.
		Stack<Integer> s = new Stack<Integer>();
		//DFS�� ��� Stack�� �̿��Ͽ� Ž���� �� �ִ�.
		for(int i=1;i<=n;i++) {
			if(isVisited[i]==0) {
				//stack�� �ִ� �������  ù��° start ����, �ι�° count, ����° ���� ����.
				s.push(perm[i]);
				s.push(1);
				s.push(perm[i]);
				while(!s.isEmpty()) {
					int curN = s.pop();
					int cnt = s.pop();
					int start = s.pop();
					if(isVisited[curN]!=0) {
						if(start!=st[curN]) {
							//�̹� �湮�ߴ� ���̰� ���������� �ƴϸ� ����.
							s.clear();
							break;
						}
						//����Ŭ�� �� ������ ������ result�� ����.
						result+=cnt-isVisited[curN];
						s.clear();break;
						
					}
					isVisited[curN]=cnt;
					st[curN] = start;
					s.push(start);
					s.push(cnt+1);
					s.push(perm[curN]);
					
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		new Main().TermProject();

	}

}
