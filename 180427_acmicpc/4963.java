import java.util.Scanner;
// https://www.acmicpc.net/problem/4963

//2667 문제와 매우 흡사, 

public class Main {
	// w:너비 h: 높이, map: 땅 있으면 1 없으면 0
	// isVisited : 방문 했는지 확인
	// next_x next_y : 인접한 8 방향 다음 좌표로 가기위한 변수
	int w;
	int h;
	int map[][];
	boolean isVisited[][];
	int next_x[] = {1,-1,0,0,1,-1,1,-1};
	int next_y[] = {0,0,1,-1,1,-1,-1,1};

	void NumOfIsland() {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		while(w!=0&&h!=0) {
			map = new int[w][h];
			isVisited = new boolean[w][h];

			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++)
					map[j][i] = sc.nextInt();
			
			int numOfBlock = 0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[j][i]==1&&!isVisited[j][i]) {
						numOfBlock++;		//초기에만 섬의 수 증가시키면 됨.
						isVisited[j][i] = true;
						DFS(j,i,numOfBlock);
					}
				}
			}
			System.out.println(numOfBlock);

			w = sc.nextInt();
			h = sc.nextInt();
		}

	}
	void DFS(int x, int y,int blocknum) {

		for(int i=0;i<8;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i]; 
			if(dx<w&&dx>=0&&dy<h&&dy>=0) {
				//범위 내에 있으면
				if(map[dx][dy]==1&&!isVisited[dx][dy]) {
					// 인접한 좌표에 건물이 있고, 방문하지 않았으면
					isVisited[dx][dy] = true;
					DFS(dx,dy,blocknum);
					// DFS 탐색 하며 방문지 늘림
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().NumOfIsland();
	}

}
