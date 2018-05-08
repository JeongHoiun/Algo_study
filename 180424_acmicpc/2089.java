import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/2089

public class Main {
	void NegativeBinary() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine().trim());

		if(a==0) {
			System.out.println("0");
			return;
		}
		binary(a);
	}
	
	void binary(int n) {
		if(n==0)
			return;
		if(n%-2==0) {	//짝수
			binary(n/-2);
			System.out.print("0");
		}else {
			binary((n-1)/-2);	//홀수일 때  자리 올림수가 있어야함
			System.out.print("1");
		}
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().NegativeBinary();

	}

}
