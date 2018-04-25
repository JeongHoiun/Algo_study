import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/9466

public class Main {
	// n : 학생의수 , student 학생, st : start 정점을 저장할 배열
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
		//result : cycle에 들어가는 정점의 수
		int result=0;
		int isVisited[] = new int[n+1];	//방문 횟수.
		Stack<Integer> s = new Stack<Integer>();
		//DFS의 경우 Stack을 이용하여 탐색할 수 있다.
		for(int i=1;i<=n;i++) {
			if(isVisited[i]==0) {
				//stack의 넣는 순서대로  첫번째 start 정점, 두번째 count, 세번째 현재 정점.
				s.push(perm[i]);
				s.push(1);
				s.push(perm[i]);
				while(!s.isEmpty()) {
					int curN = s.pop();
					int cnt = s.pop();
					int start = s.pop();
					if(isVisited[curN]!=0) {
						if(start!=st[curN]) {
							//이미 방문했던 곳이고 시작정점이 아니면 리턴.
							s.clear();
							break;
						}
						//사이클에 들어간 정점의 갯수를 result에 저장.
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
