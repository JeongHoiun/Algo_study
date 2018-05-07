import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1850
public class Main {
	void GCD() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long r = gcd(a,b);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<r;i++)
			bw.write("1");
		bw.write("\n");
		br.close();
		bw.close();
	}
	long gcd(long a,long b) {
		//유클리드 호제법
		long r;
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
		new Main().GCD();
	}

}
