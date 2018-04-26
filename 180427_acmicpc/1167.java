import java.util.Scanner;
// https://www.acmicpc.net/problem/1167
// out of memory Error ... 100000*100000

public class Main {
	int v;//정점의 갯수
	int tree[][];	//각 정점 사이의 거리		// out of memory
	int length = 0; // 최종 거리
	int l[];
	boolean isVisited[];
	void DiameterOfTree() {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		tree = new int[v][v];
		isVisited = new boolean[v];
		l = new int[v+1];
		for(int i=0;i<v;i++) {
			int a = sc.nextInt()-1;
			int b= sc.nextInt()-1;
			while(b!=-2) {
				int g= sc.nextInt();
				tree[a][b]=g;
				b=sc.nextInt()-1;
			}
		}//입력
		for(int i=0;i<v;i++) {
			isVisited[i] = true;
			dfs(i);
			for(int j=0;j<v;j++) {
				isVisited[j]=false;
				l[j] = 0;
			}
		}
		System.out.println(length);
	}
	void dfs(int a) {
		for(int i=0;i<v;i++) {
			if(tree[a][i]>0&&!isVisited[i]){
				l[i]= l[a]+tree[a][i];
				isVisited[i] = true;
				if(length<l[i])
					length = l[i];
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		new Main().DiameterOfTree();
	}

}
