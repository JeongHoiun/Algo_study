import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/2745

public class Main {
	void BaseConversion() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		String conv = st.nextToken();
		int base = Integer.parseInt(st.nextToken());
		int n = 1;
		int ten = 0;
		for (int i=conv.length()-1;i>=0;i--) {
			// 맨 끝에서부터 읽어오면서 진법변환 공식 사용.
			if(conv.charAt(i)>='A') {
				ten += n*(conv.charAt(i)-'A'+10);
			}else
				ten += n*(conv.charAt(i)-'0');
			n*=base;
		}
		System.out.println(ten);
	}
	public static void main(String[] args) throws IOException {
		new Main().BaseConversion();
	}

}
