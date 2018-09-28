import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1806
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
		int min = 100001;
		int sum = 0;
		int j = 0;
		boolean g = false;;
		for(int i=0;i<n;i++) {
			sum+=num[i];
			while(!(sum<m)) {
				sum-=num[j];
				j++;
				g = true;
			}
			if(g) {sum+=num[j-1]; j--;}
			g = false;
			if(sum>=m&&min>i-j) min = i - j + 1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(min>n) bw.write("0");
		else bw.write(String.valueOf(min));
		bw.close();
		
	}

}
