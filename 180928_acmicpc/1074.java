import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1074
public class Main {
	static int r;
	static int c;
	
	void z(int x, int y, int n, int vi) {
		if(x==c&&y==r&&n==1) {
			System.out.println(vi);
			return ;
		}
		//if(n==1)
		//	map[y][x] = vi;
		if(n==1) return;
		
		z(x,y,n/2,vi);
		z(x+n/2,y,n/2,vi+(n*n/4));
		z(x,y+n/2,n/2,vi+(n*n/4)+(n*n/4));
		z(x+n/2,y+n/2,n/2,vi+(n*n/4)+(n*n/4)+(n*n/4));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int a=1;
		for(int i=0;i<n;i++) {
			a*=2;
		}
		new Main().z(0,0,a,0);
	}

}
