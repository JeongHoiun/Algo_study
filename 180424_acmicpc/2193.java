// https://www.acmicpc.net/problem/2193
import java.util.Scanner;
public class Main {
	long dp[][];		// int�� �ϸ� �ȵ�.. ���� ���..
	void PinaryNumber() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[2][91];//�տ��� 0~9�� ��Ÿ��, �ڿ����� ����.
		dp[1][1] = 1;
		dp[1][2] = 1;
		for(int i=2;i<=n;i++) {
			//���� �ڸ����� �� �׻� ó������ 1�� ����.
			//1�� ���� ������ �ڸ� ���� ������ 0�̿��� ��
			//0�� ���� ������ �ڸ����� 0�̵� 1�̵� ������ �Ѵ� ����.
			dp[1][i] = dp[0][i-1];
			dp[0][i] = dp[0][i-1]+dp[1][i-1];
		}
		long result=0;
		for(int i=0;i<2;i++) {
			result += dp[i][n];
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		new Main().PinaryNumber();

	}

}
