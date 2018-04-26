import java.util.Scanner;
// https://www.acmicpc.net/problem/2146
// ���� �����ϰ� ��..
/*	
 * �켱 �ʿ� �ִ� �������� ��ȣ�� �ο���
 * �ٴٿ� �ٸ��� �����鼭 �Ÿ��� ī��Ʈ �ϰ�
 * ���� �ٴ��̰ų�, �ٸ��� ���������� ���� �Ÿ��� �� ª�����
 * ���� �Ÿ��� ī��Ʈ.
 * �̶�, ���� �ο��� ��ȣ�� ������ �ƴ� �ٸ� ������ ������ ���
 * ���� ī��Ʈ �� �Ÿ��� ���� ª�� �� �Ÿ��� �� �Ͽ�
 * ª�� �Ÿ��� ����. ��� �۾� �Ϸ� �� ���
 */
public class Main {
	/*
	 *  n*n ũ���� �迭
	 *  map : 1�� ���� 0�� �ٴ� , visitLen : �ּҰŸ�
	 *  numOfBlock : ���� �ο��� ��ȣ.
	 *  min : ���� ������� ����� ����.
	 *  next_x,next_y, ���� ������ ������
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
		//������ȣ 2667���� ������. �� ���� ��ȣ�� �ο��Ͽ� �ش� ���� ��ȣ�� ����.
		
		for(int i=0;i<4;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i]; 
			if(dx<n&&dx>=0&&dy<n&&dy>=0) {
				//���� ���� ������
				if(map[dx][dy]==1&&!isVisited[dx][dy]) {
					// ������ ��ǥ�� �ǹ��� �ְ�, �湮���� �ʾ�����
					map[dx][dy] = blocknum;
					isVisited[dx][dy] = true;
					DFS1(dx,dy,blocknum);
					//�ǹ��� ���� �ø��鼭 DFS Ž��
				}
			}
		}
	}
	void DFS(int x,int y,int cnt,int block) {
		for(int i=0;i<4;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i];
			if(dx<n&&dx>=0&&dy<n&&dy>=0)//��������
				if(map[dx][dy]==0&&(visitLen[dx][dy]>cnt+1||visitLen[dx][dy]==0)) {
					//�̷��� ���� �����鼭, ���� Ž������ �ʾҰų�, Ž���ߴ��� cnt+1���� Ŭ��� 
					visitLen[dx][dy]=cnt+1;
					DFS(dx,dy,cnt+1,block);
				}else if(map[dx][dy]>2&&map[dx][dy]!=block) {
					//�ٸ� ������ �����ϸ� ���� ī��Ʈ�� ������ �ּҰ��� ���Ѵ�.
					if(min>cnt)
						min= cnt;
				}
		}

		
	}
	public static void main(String[] args) {
		new Main().MakeBridge();

	}

}
