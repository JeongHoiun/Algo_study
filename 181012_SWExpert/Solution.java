import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	class Numbering{
		String number;
		int x;
		int y;
		Numbering(String number, int x,int y){
			this.number = number;
			this.x = x;
			this.y = y;
		}
	}
	
	public int seventh() {
		int cnt = 0;
		
		HashMap<String,Boolean> m = new HashMap<String,Boolean>();
		Stack<Numbering> s = new Stack<Numbering>();
		for(int i=0;i<4;i++) 
			for(int j=0;j<4;j++) 
				s.push(new Numbering("",j,i));
		
		while(!s.isEmpty()) {
			Numbering cur = s.pop();
			
			if(cur.number.length()==7) { 
				if(!m.containsKey(cur.number)) {
					cnt++;
					m.put(cur.number, true);
				}
				continue;
			}
			
			for(int i=0;i<4;i++) {
				int nx = dx[i]+cur.x;
				int ny = dy[i]+cur.y;
				if(!Boundary(nx,ny)) continue;
				
				s.push(new Numbering(cur.number+String.valueOf(map[ny][nx]),nx,ny));
			}
			
		}
		
		
		return cnt;
	}
	
	boolean Boundary(int x,int y) {
		if(x>=0&&y>=0&&x<4&&y<4)
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t = 1; t<=testcase; t++) {
			map = new int[4][4];
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("#"+t+" "+new Solution().seventh());
		}
	}

}
