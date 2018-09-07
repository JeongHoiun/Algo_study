import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/14501

public class Main {
	int bestProfit(int n, int[] t, int[] p) {
		Stack<Integer> dayST = new Stack<Integer>();
		Stack<Integer> sumST = new Stack<Integer>();
		
		for(int i=1;i<=n;i++) {
			dayST.push(i+t[i]);
			sumST.push(p[i]);
		}
		int max = 0;
		while(!dayST.isEmpty()) {
			int day = dayST.pop();
			int sum = sumST.pop();
			if(day>n+1) continue;
			if(sum>max) max = sum;
			for(int i=day;i<=n;i++) {
				dayST.push(i+t[i]);
				sumST.push(sum+p[i]);
			}
		}
		
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(new Main().bestProfit(n,t,p)));
		bw.flush();
		
	}

}
