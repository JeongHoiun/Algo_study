import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/9613
public class Main {
	void GCDSum() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine().trim());
		for(int t=0;t<testcase;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int n  = Integer.parseInt(st.nextToken());
			int num[] = new int[n];
			for(int i=0;i<n;i++) {
				num[i] = Integer.parseInt(st.nextToken());	//입력
			}
			long result = 0;		// long으로 해줘야함
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					result += GCD(num[i],num[j]);
				}
			}
			bw.write(result+"\n");
		}
		br.close();
		bw.close();
	}
	int GCD(int a,int b) {
		//유클리드 호제법
		int r;
		while(true) {
			r = a % b; 
			if (r == 0) return b; 
			else{
				a = b;
				b = r; 
			} 
		}

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Main().GCDSum();
	}

}
