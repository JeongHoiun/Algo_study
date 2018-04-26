import java.util.Scanner;
// https://www.acmicpc.net/problem/4963

//2667 ������ �ſ� ���, 

public class Main {
	// w:�ʺ� h: ����, map: �� ������ 1 ������ 0
	// isVisited : �湮 �ߴ��� Ȯ��
	// next_x next_y : ������ 8 ���� ���� ��ǥ�� �������� ����
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
						numOfBlock++;		//�ʱ⿡�� ���� �� ������Ű�� ��.
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
				//���� ���� ������
				if(map[dx][dy]==1&&!isVisited[dx][dy]) {
					// ������ ��ǥ�� �ǹ��� �ְ�, �湮���� �ʾ�����
					isVisited[dx][dy] = true;
					DFS(dx,dy,blocknum);
					// DFS Ž�� �ϸ� �湮�� �ø�
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().NumOfIsland();
	}

}
