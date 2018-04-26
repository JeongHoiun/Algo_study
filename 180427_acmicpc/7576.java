import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// https://www.acmicpc.net/problem/7576
//1 ������ Ǯ������.
public class Main {
	/* box : �丶�� �ڽ��� ����
	 * visited : BFS���� �湮���� Ȯ��
	 *  dayc �� �丶����� ���� �;����� �����ϴ� ����
	 *  day : ���� ��¥ 
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
		//bfs�� ���鼭 �丶�䰡 ���� ���� �� �丶�� ��ġ�� dayc�� ������. 
		while(!q.isEmpty()){
			tempy = q.poll();
			tempx = q.poll();
			for(int i=0;i<4;i++){
				if(((tempy+dy[i]<y)&&(tempx+dx[i]<x))&&((tempy+dy[i]>=0)&&(tempx+dx[i]>=0))){
					//���� Ȯ��.
					if((box[tempy+dy[i]][tempx+dx[i]]==0)){
						//���� �ʾҰ�, �丶�䰡 ������
						box[tempy+dy[i]][tempx+dx[i]]=1;
						//����
						visited[tempy+dy[i]][tempx+dx[i]]=true;
						//�湮 Ȯ��
						dayc[tempy+dy[i]][tempx+dx[i]]=dayc[tempy][tempx]+1;
						//��¥ ����
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
				// �̹� ���� �丶����� ��� bfs�� ����.
				box[i][j] = sc.nextInt();
				visited[i][j]=false;
				if(box[i][j]==1){
					q.offer(i);
					q.offer(j);
					dayc[i][j]=0;//ù¶��
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
