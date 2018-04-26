import java.util.Arrays;
import java.util.Scanner;
// https://www.acmicpc.net/problem/2667

public class Main {
	// N: 사각형 크기, map: 건물이 있으면 1 없으면 0, block : 각 단지의 건물수
	//isVisited : 방문 했는지 확인
	// next_x next_y : 인접한 네 방향으 다음 좌표로 가기위한 변수
	int N;
	String map[];
	int block[];
	boolean isVisited[][];
	int next_x[] = {1,-1,0,0};
	int next_y[] = {0,0,1,-1};

	void BlockNumbering() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new String[N];
		block = new int[N*N];	
		isVisited = new boolean[N][N];

		for(int i=0;i<N;i++)
			map[i] = sc.next();
		int numOfBlock = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i].charAt(j)=='1'&&!isVisited[j][i]) {
					numOfBlock++;
					isVisited[j][i] = true;
					DFS(j,i,numOfBlock);
				}
			}
		}
		System.out.println(numOfBlock);
		Arrays.sort(block);
		for(int i=0;i<(N*N);i++) 
			if(block[i] !=0) 
				System.out.println(block[i]);

	}
	void DFS(int x, int y,int blocknum) {

		block[blocknum]++;//방문한 블록의 건물 수 증가.
		
		for(int i=0;i<4;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i]; 
			if(dx<N&&dx>=0&&dy<N&&dy>=0) {
				//범위 내에 있으면
				if(map[dy].charAt(dx)=='1'&&!isVisited[dx][dy]) {
					// 인접한 좌표에 건물이 있고, 방문하지 않았으면
					isVisited[dx][dy] = true;
					DFS(dx,dy,blocknum);
					//건물의 수를 늘리면서 DFS 탐색
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().BlockNumbering();
	}

}
