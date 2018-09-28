import java.util.Scanner;
//https://www.acmicpc.net/problem/1987
public class Main {
	static String[] map;
	static int max = 1;
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	void dfs(int x, int y, String alpha) {
		if(alpha.length()>max) max = alpha.length();
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||ny<0||nx>=map[0].length()||ny>=map.length) continue;
			
			if(!alpha.contains(map[ny].charAt(nx)+"")) {
				dfs(nx,ny,alpha+map[ny].charAt(nx));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		map = new String[r];
		for(int i=0;i<r;i++) {
			map[i] = sc.next();
		}
		new Main().dfs(0,0,map[0].charAt(0)+"");
		System.out.println(max);
	}

}
