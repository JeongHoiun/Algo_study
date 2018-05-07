import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	void LCM() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine().trim());
		for(int t=0;t<testcase;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(a*b/gcd(a,b));
			//a*b = gcd(a,b)*lcm(a,b)
		}
	}
	int gcd(int a,int b) {
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
		new Main().LCM();
	}

}
