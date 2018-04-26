import java.util.Scanner;
// https://www.acmicpc.net/problem/2146
// 조금 복잡하게 함..
/*	
 * 우선 맵에 있는 육지마다 번호를 부여함
 * 바다에 다리를 놓으면서 거리를 카운트 하고
 * 아직 바다이거나, 다리가 놓여있지만 현재 거리가 더 짧은경우
 * 현재 거리를 카운트.
 * 이때, 현재 부여된 번호의 육지가 아닌 다른 육지에 도달할 경우
 * 현재 카운트 된 거리와 가장 짧게 간 거리를 비교 하여
 * 짧은 거리를 저장. 모든 작업 완료 후 출력
 */
public class Main {
	/*
	 *  n*n 크기의 배열
	 *  map : 1은 육지 0은 바다 , visitLen : 최소거리
	 *  numOfBlock : 섬에 부여할 번호.
	 *  min : 최종 결과값이 저장될 변수.
	 *  next_x,next_y, 다음 방향의 지시자
	 */
	int n;
	int map[][];
	int visitLen[][];
	boolean isVisited[][];
	int numOfBlock;
	int next_x[] = {1,-1,0,0};
	int next_y[] = {0,0,1,-1};
	int min = Integer.MAX_VALUE;
	void MakeBridge() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visitLen = new int[n][n];
		isVisited = new boolean[n][n];
		numOfBlock=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[j][i] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[j][i]==1&&!isVisited[j][i]) {
					numOfBlock++;
					map[j][i] = numOfBlock;
					isVisited[j][i] = true;
					DFS1(j,i,numOfBlock);
				}
			}
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(map[j][i]>1)
					DFS(j,i,0,map[j][i]);
		System.out.println(min);
	}
	void DFS1(int x, int y,int blocknum) {
		//문제번호 2667에서 가져옴. 각 섬에 번호를 부여하여 해당 땅에 번호를 저장.
		
		for(int i=0;i<4;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i]; 
			if(dx<n&&dx>=0&&dy<n&&dy>=0) {
				//범위 내에 있으면
				if(map[dx][dy]==1&&!isVisited[dx][dy]) {
					// 인접한 좌표에 건물이 있고, 방문하지 않았으면
					map[dx][dy] = blocknum;
					isVisited[dx][dy] = true;
					DFS1(dx,dy,blocknum);
					//건물의 수를 늘리면서 DFS 탐색
				}
			}
		}
	}
	void DFS(int x,int y,int cnt,int block) {
		for(int i=0;i<4;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i];
			if(dx<n&&dx>=0&&dy<n&&dy>=0)//범위한정
				if(map[dx][dy]==0&&(visitLen[dx][dy]>cnt+1||visitLen[dx][dy]==0)) {
					//미로의 길이 맞으면서, 현재 탐색하지 않았거나, 탐색했더라도 cnt+1보다 클경우 
					visitLen[dx][dy]=cnt+1;
					DFS(dx,dy,cnt+1,block);
				}else if(map[dx][dy]>2&&map[dx][dy]!=block) {
					//다른 육지에 도달하면 현재 카운트된 정보를 최소값과 비교한다.
					if(min>cnt)
						min= cnt;
				}
		}

		
	}
	public static void main(String[] args) {
		new Main().MakeBridge();

	}

}
