//timeover  1520

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int map[][];
	int col;
	int row;
	int dp[][];
	
	void downhill() {
		Scanner sc = new Scanner(System.in);
		col = sc.nextInt();		//열
		row = sc.nextInt();		//행
		map = new int[col+1][row+1];
		dp = new int[col+1][row+1];
		for(int i=1;i<=col;i++) {
			for(int j=1;j<=row;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(search(1,1));
		
		/*
		//DFS 방식 ( 시간초과 )
	   
	    
	    int cnt=0;
		
	    Stack<Integer> s = new Stack<Integer>();

		s.push(1);	//x
		s.push(1);	//y

		int x[] ={1,-1,0,0};		//방향지시
		int y[] ={0,0,-1,1};
		while(!s.isEmpty()) {
			int row_y = s.pop();
			int col_x = s.pop();
			if(row_y == row-1 && col_x == col-1) {
				cnt++;
				continue;
			}
			for(int i=0;i<4;i++) {
				if((col_x+x[i]<col) && (col_x+x[i]>=0) && (row_y+y[i]<row) && (row_y+y[i]>=0)) {
					if(map[col_x][row_y]>map[col_x+x[i]][row_y+y[i]]) {		// 이전 길보다 작은 경우 탐색
						s.push(col_x+x[i]);
						s.push(row_y+y[i]);
					}
				}
			}
		}
		
		System.out.println(cnt);*/
	}
	
	//dp, 시간초과...
	int search(int x, int y) {
		if(x==col&&y==row)
			return 1;
		if(dp[x][y]>0)
			return dp[x][y];
		int _x[] = {1, -1, 0, 0};
		int _y[] = {0, 0, 1, -1};
		for(int i=0;i<4;i++) {// 네방향의 다음 길이 현재보다 작은지 판단후 search,
			if(x+_x[i]<=col&&y+_y[i]<=row&&x+_x[i]>0&&y+_y[i]>0) {
				if(map[x+_x[i]][y+_y[i]]<map[x][y])
					dp[x][y] += search(x+_x[i],y+_y[i]);
					
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().downhill();
	}

}
