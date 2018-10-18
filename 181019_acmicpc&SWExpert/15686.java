import java.awt.Point;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	void combination(int x[], int y[], int target_idx, int m, int x_idx, int y_idx) {
		if(m==0) {
			
			chickLen(x,y,target_idx);
			return;
		}
		if(x_idx==map.length&&y_idx==map.length-1) {
			return;
		}else if(x_idx==map.length) {
			x_idx=0;
			y_idx+=1;
		}
		
		if(map[y_idx][x_idx]==2) {
			x[target_idx] = x_idx;
			y[target_idx] = y_idx;
			//»Ì´Â°æ¿ì
			combination(x,y,target_idx+1,m-1,x_idx+1,y_idx);
		}
		//¾È»Ì´Â °æ¿ì
		combination(x,y,target_idx,m,x_idx+1,y_idx);
	}
	
	void chickLen(int x[], int y[], int target_idx) {
		int[][] minlen = new int[map.length][map.length];
		int sum=0;
		for(int i=0;i<target_idx;i++) {
			for(int j=0;j<map.length;j++) {
				for(int k=0;k<map.length;k++) {
					if(map[j][k]!=1) continue;
					
					int len = Math.abs(x[i]-k)+Math.abs(y[i]-j);
					if(minlen[j][k]==0||minlen[j][k]>len) minlen[j][k] = len;
				}
			}
		}
		
		for(int i=0;i<minlen.length;i++) {
			for(int j=0;j<minlen.length;j++) {
				sum+=minlen[i][j];
			}
		}
		if(min>sum) min = sum;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int x[] = new int[m];
		int y[] = new int[m];
		
		new Main().combination(x, y, 0, m, 0, 0);
		
		bw.write(String.valueOf(min)+"\n");
		bw.close();
	}

}
