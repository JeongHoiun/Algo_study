import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/2003
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		int sum = 0;
		int j = 0;
		for(int i=0;i<n;i++) {
			sum+=num[i];
			while(sum>m) {
				sum-=num[j];
				j++;
			}
			if(sum==m) {
				cnt++;
				sum-=num[j];
				j++;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(cnt));
		bw.close();
		
	}

}
