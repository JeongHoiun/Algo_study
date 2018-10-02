import java.io.*;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1561
public class Main {
	
	static int[] rollco;
	static int maxTime;
	
	public long lastRollco(long n,int m) {
		if(n<=m) return n;
		long left = 1;
		long right = 60000000000L;
		long result = 0;
		long cnt = 0;
		long time = 0;
		while(left<=right) {
			long mid = (left+right)/2;
	        cnt = m;
	        
	        for (int i = 1; i <= m; i++) {
	            cnt += (mid / rollco[i]);
	        }
	 
	        if (cnt >= n) {
	            time = mid;
	            right = mid - 1;
	        }
	        else {
	            left = mid + 1;
	        }
		}

		cnt = m;
		for (int i = 1; i <= m; i++) {
	        cnt += ((time - 1) / rollco[i]);
	    }
		for (int i = 1; i <= m; i++) {
	        if (time%rollco[i] == 0) cnt++;
	        if (cnt == n) {
	           	result = i;
	            break;
	        }
	    }
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long n = Long.parseLong(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		rollco = new int [m+1];
		maxTime = 0 ;
		for(int i=1;i<=m;i++) {
			rollco[i] = Integer.parseInt(st.nextToken());
			maxTime = maxTime<rollco[i]?rollco[i]:maxTime;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(new Main().lastRollco(n, m)));
		bw.close();
		
		
	}

}
