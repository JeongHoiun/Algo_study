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
			//������ȯ�� �⺻�� ����������� �����⿬��.
			int t = ten%conv;
			if(t>=10) {	// 10���� ũ�ų� ���� ��� ���ĺ����� �ٲ���
				t-=10;
				t+='A';
				result = (char)t+result;
			}else {	//10 ������ ���� �ٷ� char�� ����ȯ ����.
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
