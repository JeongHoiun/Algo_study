import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// https://www.acmicpc.net/problem/7576
//1 년전에 풀었던거.
public class Main {
	/* box : 토마토 박스의 정보
	 * visited : BFS에서 방문정보 확인
	 *  dayc 각 토마토들이 언제 익었는지 저장하는 변수
	 *  day : 현재 날짜 
	 */
	static int box[][];
	static boolean visited[][];
	static int dayc[][] = new int[1000][1000];
	static Queue<Integer> q = new LinkedList<Integer>();
	static int day=0;
	public static void BFS(int x, int y){
		int tempx, tempy;
		int dy[] = {1,-1,0,0};
		int dx[] = {0,0,1,-1};
		//bfs를 돌면서 토마토가 익은 날을 각 토마토 위치의 dayc에 저장함. 
		while(!q.isEmpty()){
			tempy = q.poll();
			tempx = q.poll();
			for(int i=0;i<4;i++){
				if(((tempy+dy[i]<y)&&(tempx+dx[i]<x))&&((tempy+dy[i]>=0)&&(tempx+dx[i]>=0))){
					//범위 확인.
					if((box[tempy+dy[i]][tempx+dx[i]]==0)){
						//익지 않았고, 토마토가 있으면
						box[tempy+dy[i]][tempx+dx[i]]=1;
						//익음
						visited[tempy+dy[i]][tempx+dx[i]]=true;
						//방문 확인
						dayc[tempy+dy[i]][tempx+dx[i]]=dayc[tempy][tempx]+1;
						//날짜 저장
						q.offer(tempy+dy[i]); q.offer(tempx+dx[i]);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x,y;
		boolean impossible=false;
		int maxd=0;
		x = sc.nextInt(); y = sc.nextInt();
		//x size , y size
		box = new int[y][x];
		visited= new boolean[y][x];
		for(int i=0;i<y;i++)
			for(int j=0;j<x;j++){
				// 이미 익은 토마토들을 모두 bfs에 저장.
				box[i][j] = sc.nextInt();
				visited[i][j]=false;
				if(box[i][j]==1){
					q.offer(i);
					q.offer(j);
					dayc[i][j]=0;//첫쨋날
					visited[i][j]=true;
				}
			}
		BFS(x,y);
		for(int i=0;i<y;i++){
			for(int j=0;j<x;j++){
				if(box[i][j]==0)
					impossible = true;
				if(dayc[i][j]>maxd)
					maxd=dayc[i][j];
			}
		}
		if(impossible) System.out.println(-1);
		else System.out.println(maxd);
	}

}
