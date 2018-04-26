import java.util.Arrays;
import java.util.Scanner;
// https://www.acmicpc.net/problem/2667

public class Main {
	// N: �簢�� ũ��, map: �ǹ��� ������ 1 ������ 0, block : �� ������ �ǹ���
	//isVisited : �湮 �ߴ��� Ȯ��
	// next_x next_y : ������ �� ������ ���� ��ǥ�� �������� ����
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

		block[blocknum]++;//�湮�� ����� �ǹ� �� ����.
		
		for(int i=0;i<4;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i]; 
			if(dx<N&&dx>=0&&dy<N&&dy>=0) {
				//���� ���� ������
				if(map[dy].charAt(dx)=='1'&&!isVisited[dx][dy]) {
					// ������ ��ǥ�� �ǹ��� �ְ�, �湮���� �ʾ�����
					isVisited[dx][dy] = true;
					DFS(dx,dy,blocknum);
					//�ǹ��� ���� �ø��鼭 DFS Ž��
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().BlockNumbering();
	}

}
