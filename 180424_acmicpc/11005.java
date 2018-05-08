import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/11005

public class Main {
	void BaseConversion2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int ten = Integer.parseInt(st.nextToken());
		int conv = Integer.parseInt(st.nextToken());
		String result = "";
		while(ten!=0) {	
			//진법변환의 기본은 나머지연산과 나누기연산.
			int t = ten%conv;
			if(t>=10) {	// 10보다 크거나 같을 경우 알파벳으로 바꿔줌
				t-=10;
				t+='A';
				result = (char)t+result;
			}else {	//10 이하의 수는 바로 char로 형변환 가능.
				t+='0';
				result = (char)t+result;
			}
			ten/=conv;
		}
		System.out.println(result);
	}
	public static void main(String[] args) throws IOException {
		new Main().BaseConversion2();
	}

}
