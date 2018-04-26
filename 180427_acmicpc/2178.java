import java.util.Scanner;
// https://www.acmicpc.net/problem/2178

public class Main {
	/*
	 *  n*m ũ���� �迭
	 *  maze : �̷� , visitLen : �ּҰŸ�
	 *  next_x,next_y, ���� ������ ������
	 */
	int n;
	int m;
	String maze[];
	int visitLen[][];
	int next_x[] = {1,-1,0,0};
	int next_y[] = {0,0,1,-1};

	void SearchMaze() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		maze = new String[n];
		visitLen = new int[m][n];

		for(int i=0;i<n;i++) {
			maze[i] = sc.next();
		}
		
		DFS(0,0,1);// �������� ���ԵǹǷ� count�� 1���� ����
		
		System.out.println(visitLen[m-1][n-1]);
	}

	void DFS(int x, int y, int cnt) {
		if(x==m-1&&y==n-1) 	//������
			return ;
		for(int i=0;i<4;i++) {
			int dx = x+next_x[i];
			int dy = y+next_y[i];
			if(dx<m&&dx>=0&&dy<n&&dy>=0)//��������
				if(maze[dy].charAt(dx)=='1'&&(visitLen[dx][dy]>cnt+1||visitLen[dx][dy]==0)) {
					//�̷��� ���� �����鼭, ���� Ž������ �ʾҰų�, Ž���ߴ��� cnt+1���� Ŭ��� 
					visitLen[dx][dy]=cnt+1;
					DFS(dx,dy,cnt+1);
				}
		}

	}

	public static void main(String[] args) {
		new Main().SearchMaze();
	}

}
