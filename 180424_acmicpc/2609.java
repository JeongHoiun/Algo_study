import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	void GCDLCM() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(GCD(a,b));
		System.out.println(LCM(a,b));
	}
	int GCD(int a, int b) {
		int j = Math.min(a, b);
		int result=1;
		for(int i=2;i<=j;i++) {
			if(a%i==0&&b%i==0)
				result = i;
		}
		return result;
	}
	int LCM(int a,int b) {
		int j = Math.max(a,b);
		while(true) {
			if(j%a==0&&j%b==0) {
				return j;
			}
			j++;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Main().GCDLCM();
	}

}
